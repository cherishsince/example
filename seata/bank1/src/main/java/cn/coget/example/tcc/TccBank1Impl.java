package cn.coget.example.tcc;

import cn.coget.example.client.Bank2Client;
import cn.coget.example.mapper.Bank1Mapper;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TccBank1Impl implements TccBank1 {

    @Autowired
    private Bank1Mapper bank1Mapper;
    @Autowired
    private Bank2Client bank2Client;

    long account100 = 100;

    @Override
    @Transactional
    @GlobalTransactional
    public String transfer(String accountNo, Double amount) {
        System.err.println("transfer 获取到的事务XID " + RootContext.getXID());
        if (bank1Mapper.updateDeductionFreezeAmount(account100, amount) < 1) {
            throw new RuntimeException("bank1 冻结金额失败!");
        }
        if (!bank2Client.tccTransfer(accountNo, amount).equals("OK")) {
            throw new RuntimeException("bank2 try 失败!");
        }
        if (amount == 4) {
            throw new RuntimeException("bank1 try 人为异常4!");
        }
        return "OK";
    }

    @Override
    public Boolean commit(BusinessActionContext context) {
        System.err.println("commit 获取到的事务XID " + context.getXid());
        // 幂等操作
        Double amount = Double.valueOf(String.valueOf(context.getActionContext("amount")));
        if (bank1Mapper.updateDeductionFreezeAmountSuccess(account100, amount) < 1) {
            throw new RuntimeException("bank1 commit 失败! 记录日志!");
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean rollback(BusinessActionContext context) {
        System.err.println("rollback 获取到的事务XID " + context.getXid());
        // 幂等操作
        Double amount = Double.valueOf(String.valueOf(context.getActionContext("amount")));
        if (bank1Mapper.updateDeductionFreezeAmountFail(account100, amount) < 1) {
            throw new RuntimeException("bank1 rollback 失败! 记录日志!");
        }
        return Boolean.TRUE;
    }
}
