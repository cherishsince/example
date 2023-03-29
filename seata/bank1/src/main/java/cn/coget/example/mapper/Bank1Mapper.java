package cn.coget.example.mapper;

import cn.coget.example.dataobject.Bank1;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Bank1Mapper extends BaseMapper<Bank1> {

    @Update("UPDATE bank1 SET amount = amount - #{amount} WHERE id = #{id}")
    int updateDeductionAmount(@Param("id") long id, @Param("amount") double amount);
}
