package com.chingkwok;

import com.chingkwok.utils.GeneratorSqlmap;
import com.chingkwok.component.SnowflakeIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by guojingye on 2019/7/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Autowired
    GeneratorSqlmap generatorSqlmap;

    @Autowired
    SnowflakeIdWorker snowflakeIdWorker;


    @Test
    public void doGenerator()throws Exception{
        generatorSqlmap.generator();
        System.out.println("1");
    }

    @Test
    public void snowflake(){
        long l = snowflakeIdWorker.nextId();
        System.out.println(l);
    }

}
