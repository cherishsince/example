package cn.coget.example.service;

import cn.coget.example.client.Bank2Client;
import cn.coget.example.mapper.Bank1Mapper;
import cn.coget.example.tcc.TccBank1;
import io.seata.core.context.RootContext;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TccBank1ServiceImpl implements TccBank1Service {

    @Autowired
    private Bank1Mapper bank1Mapper;
    @Autowired
    private TccBank1 tccBank1;

    long account100 = 100;

    @Override
    @Transactional
    @GlobalTransactional
    public String transfer(String accountNo, Double amount) {
        return tccBank1.transfer(accountNo, amount);
    }
}
