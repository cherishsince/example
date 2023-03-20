package cn.coget.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank2")
public class Bank2Controller {

    @GetMapping("")
    public String index() {
        return "bank2";
    }

    @GetMapping("/transfer")
    public String transfer(@RequestParam("accountNo") String accountNo,
                           @RequestParam("amount") Double amount) {
        return "ok";
    }
}
