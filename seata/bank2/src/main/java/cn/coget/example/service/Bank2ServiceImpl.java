package cn.coget.example.service;

import cn.coget.example.mapper.Bank2Mapper;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Bank2ServiceImpl implements Bank2Service {

    @Autowired
    private Bank2Mapper bank2Mapper;

    @Override
    public String transfer(String accountNo, Double amount) {
        System.err.println("获取到的事务XID " + RootContext.getXID());
        if (bank2Mapper.updateIncreaseAmount(Long.valueOf(accountNo), amount) < 1) {
            throw new RuntimeException("bank2增加金额失败!");
        }
        if (amount == 3) {
            throw new RuntimeException("人为的异常3!");
        }
//        try {
//            Thread.sleep(5000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return "OK";
    }
}
