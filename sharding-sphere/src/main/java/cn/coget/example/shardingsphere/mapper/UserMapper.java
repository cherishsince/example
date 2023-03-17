package cn.coget.example.shardingsphere.mapper;

import cn.coget.example.shardingsphere.entity.UserDO;
import cn.coget.example.shardingsphere.entity.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserDO> {

    @Select("select t.user_id as id, sum(t.amount) as amount from t_order t group by t.user_id")
    UserVO selectUserOrder();
}
