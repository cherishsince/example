package cn.coget.example.service;

public interface Bank1Service {

    /**
     * 转账
     *
     * @param accountNo
     * @param amount
     * @return
     */
    String transfer(String accountNo, Double amount);
}
