package cn.coget.example.shardingsphere;

import cn.coget.example.shardingsphere.entity.DictDO;
import cn.coget.example.shardingsphere.mapper.DictMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BroadcastTests {

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void insertDicTest() {
        dictMapper.insert(
                new DictDO()
                        .setId(null)
                        .setDictType("gender")
                        .setDictName("性别")
        );
    }
}
