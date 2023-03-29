package cn.coget.example.tcc;

import cn.coget.example.mapper.Bank2Mapper;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TccBank2Impl implements TccBank2 {

    @Autowired
    private Bank2Mapper bank2Mapper;

    @Override
    public String transfer(BusinessActionContext context, String accountNo, Double amount) {
        System.err.println("transfer 获取到的事务XID " + RootContext.getXID());
        if (amount == 3) {
            throw new RuntimeException("bank2 try 人为异常3!");
        }
        return "OK";
    }

    @Override
    public Boolean commit(BusinessActionContext context) {
        System.err.println("commit 获取到的事务XID " + context.getXid());
        // 幂等操作
        String accountNo = String.valueOf(context.getActionContext("accountNo"));
        Double amount = Double.valueOf(String.valueOf(context.getActionContext("amount")));
        if (bank2Mapper.updateIncreaseAmount(Long.valueOf(accountNo), amount) < 1) {
            throw new RuntimeException("bank1 commit 失败! 记录日志!");
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean rollback(BusinessActionContext context) {
        System.err.println("rollback 获取到的事务XID " + context.getXid());
        // 幂等操作
        String accountNo = String.valueOf(context.getActionContext("accountNo"));
        Double amount = Double.valueOf(String.valueOf(context.getActionContext("amount")));
        if (bank2Mapper.updateDeductionAmount(Long.valueOf(accountNo), amount) < 1) {
            throw new RuntimeException("bank1 rollback 失败! 记录日志!");
        }
        return Boolean.TRUE;
    }
}
