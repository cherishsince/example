package cn.coget.example.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("bank2")
public class Bank2 {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Double amount;
}
