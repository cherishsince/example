package cn.coget.example.controller;

import cn.coget.example.service.Bank2Service;
import cn.coget.example.service.TccBank2Service;
import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank2")
public class Bank2Controller {

    @Autowired
    private Bank2Service bank2Service;
    @Autowired
    private TccBank2Service tccBank2Service;

    @GetMapping("")
    public String index() {
        return "bank2";
    }

    @GetMapping("/transfer")
    public String transfer(
            BusinessActionContext context,
            @RequestParam("accountNo") String accountNo,
                           @RequestParam("amount") Double amount) {
        return bank2Service.transfer(accountNo, amount);
    }

    @GetMapping("/tccTransfer")
    public String tccTransfer(@RequestParam("accountNo") String accountNo,
                           @RequestParam("amount") Double amount) {
        return tccBank2Service.transfer(accountNo, amount);
    }
}
