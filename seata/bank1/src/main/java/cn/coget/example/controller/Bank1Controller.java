package cn.coget.example.controller;

import cn.coget.example.service.Bank1Service;
import cn.coget.example.service.TccBank1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank1")
public class Bank1Controller {

    @Autowired
    private Bank1Service bank1Service;
    @Autowired
    private TccBank1Service tccBank1Service;

    @GetMapping("")
    public String index() {
        return "bank1";
    }

    @GetMapping("/transfer")
    public String transfer(@RequestParam("accountNo") String accountNo,
                           @RequestParam("amount") Double amount) {
        return bank1Service.transfer(accountNo, amount);
    }

    @GetMapping("/tccTransfer")
    public String tccTransfer(@RequestParam("accountNo") String accountNo,
                           @RequestParam("amount") Double amount) {
        return tccBank1Service.transfer(accountNo, amount);
    }
}
