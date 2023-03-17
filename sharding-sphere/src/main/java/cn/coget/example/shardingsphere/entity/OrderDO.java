package cn.coget.example.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("t_order")
public class OrderDO {

    /**
     * 编号
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 标题
     */
    private String title;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;
}
