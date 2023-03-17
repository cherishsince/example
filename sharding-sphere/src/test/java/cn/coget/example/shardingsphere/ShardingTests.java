package cn.coget.example.shardingsphere;

import cn.coget.example.shardingsphere.entity.OrderDO;
import cn.coget.example.shardingsphere.entity.UserDO;
import cn.coget.example.shardingsphere.mapper.OrderMapper;
import cn.coget.example.shardingsphere.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class ShardingTests {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    //
    // user

    @Test
    public void userInsertTest() {
        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker(new Locale("zh-CN"));
            userMapper.insert(
                    new UserDO()
                            .setId(null)
                            .setName(faker.name().firstName())
            );
        }
    }

    @Test
    public void userSelectTest() {
        List<UserDO> userDOList = userMapper.selectList(new LambdaQueryWrapper<>());
        for (UserDO userDO : userDOList) {
            System.err.println(userDO);
        }
    }

    @Test
    public void userSelectNameTest() {
        List<UserDO> userDOList = userMapper.selectList(
                new LambdaQueryWrapper<UserDO>()
                        .eq(UserDO::getName, "用户eae318086b1944f5b0bff83f2dc1bd36")
        );
        for (UserDO userDO : userDOList) {
            System.err.println(userDO);
        }
    }

    @Test
    public void userSelectRangeTest() {
        List<UserDO> userDOList = userMapper.selectList(
                new LambdaQueryWrapper<UserDO>()
                        .gt(UserDO::getId, 833126985101213696L)
        );
        for (UserDO userDO : userDOList) {
            System.err.println(userDO);
        }
    }

    @Test
    public void userOrderTest() {
        userMapper.selectUserOrder();
    }

    @Test
    public void userRemoveALlTest() {
        int delete = userMapper.delete(null);
        System.err.println(delete);
    }

    //
    // order

    @Test
    public void orderInsertTest() {
        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker(new Locale("zh-CN"));
            orderMapper.insert(
                    new OrderDO()
                            .setId(null)
                            .setUserId(1L)
                            .setTitle(faker.app().name())
                            .setAmount(new BigDecimal(new Random().nextInt(100) * 100))
            );
        }
    }

    @Test
    public void orderRemoveAllTest() {
        orderMapper.delete(null);
    }
}
