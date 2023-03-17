package cn.coget.example.shardingsphere.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors
public class UserVO {

    private Long id;

    private String name;

    private BigDecimal amount;
}
