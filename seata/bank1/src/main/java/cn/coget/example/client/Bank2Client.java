package cn.coget.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "BANK2", url = "http://127.0.0.1:8082")
public interface Bank2Client {

    @GetMapping( "/bank2/transfer")
    String transfer(@RequestParam("accountNo") String accountNo, @RequestParam("amount") Double amount);
}
