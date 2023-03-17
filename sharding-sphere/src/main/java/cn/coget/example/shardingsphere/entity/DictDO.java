package cn.coget.example.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("t_dict")
public class DictDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String dictType;

    private String dictName;

}
