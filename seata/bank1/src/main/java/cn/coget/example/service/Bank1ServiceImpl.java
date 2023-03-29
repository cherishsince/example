package cn.coget.example.service;

import cn.coget.example.client.Bank2Client;
import cn.coget.example.dataobject.Bank1;
import cn.coget.example.mapper.Bank1Mapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class Bank1ServiceImpl implements Bank1Service {

    @Autowired
    private Bank1Mapper bank1Mapper;
    @Autowired
    private Bank2Client bank2Client;

    @Override
    @GlobalTransactional
    @Transactional
    public String transfer(String accountNo, Double amount) {
        doUpdate(amount);
        bank2Client.transfer(accountNo, amount);
        if (amount == 4) {
            throw new RuntimeException("人为异常4!");
        }
        return "OK";
    }

    @Transactional
    public void doUpdate(Double amount) {
        System.err.println("获取到的事务XID " + RootContext.getXID());
        if (bank1Mapper.updateDeductionAmount(100, amount) < 1) {
            throw new RuntimeException("账户1 扣减金额失败!");
        }
    }
}
