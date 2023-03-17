package cn.coget.example.shardingsphere;

import cn.coget.example.shardingsphere.entity.OrderDO;
import cn.coget.example.shardingsphere.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class ReadWriteTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertTest() {
        int res = orderMapper.insert(
                new OrderDO()
                        .setId(null)
                        .setTitle("测试交易 " + System.currentTimeMillis())
                        .setAmount(new BigDecimal(new Random().nextDouble() * 100))
        );
        System.err.println(res);
        String a = "";
    }

    @Test
    public void selectTest() {
        List<OrderDO> orderDOS = orderMapper.selectList(new LambdaQueryWrapper<>());
        for (OrderDO orderDO : orderDOS) {
            System.err.println(orderDO);
        }
    }

    @Test
    @Transactional
    public void tranTest() {
        insertTest();
        selectTest();
    }

    @Test
    public void randomTest() {
        selectTest();
        selectTest();

    }
}
