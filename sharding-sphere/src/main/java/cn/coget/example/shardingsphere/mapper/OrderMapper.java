package cn.coget.example.shardingsphere.mapper;

import cn.coget.example.shardingsphere.entity.OrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<OrderDO> {


}
