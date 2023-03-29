package cn.coget.example.service;

public interface Bank2Service {

    /**
     * 转账
     *
     * @param accountNo
     * @param amount
     * @return
     */
    String transfer(String accountNo, Double amount);
}
