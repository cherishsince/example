package cn.coget.example.service;

import cn.coget.example.tcc.TccBank2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TccBank2ServiceImpl implements TccBank2Service {

    @Autowired
    private TccBank2 tccBank2;

    @Override
    public String transfer(String accountNo, Double amount) {
        return tccBank2.transfer(null, accountNo, amount);
    }
}
