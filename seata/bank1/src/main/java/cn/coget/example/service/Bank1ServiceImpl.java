package cn.coget.example.service;

import cn.coget.example.client.Bank2Client;
import cn.coget.example.mapper.Bank1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bank1ServiceImpl implements Bank1Service {

    @Autowired
    private Bank1Mapper bank1Mapper;
    @Autowired
    private Bank2Client bank2Client;

    @Override
    public String transfer(String accountNo, Double amount) {
        return bank2Client.transfer(accountNo, amount);
    }
}
