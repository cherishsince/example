package cn.coget.example.shardingsphere.mapper;

import cn.coget.example.shardingsphere.entity.DictDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DictMapper extends BaseMapper<DictDO> {
}
