package com.chingkwok.service;

import com.chingkwok.bean.entity.User;
import com.chingkwok.component.SnowflakeIdWorker;
import com.chingkwok.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by guojingye on 2019/7/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SnowflakeIdWorker snowflakeIdWorker;

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            long l = snowflakeIdWorker.nextId();
            user.setUserId(l);
            user.setCreationTime(new Date());
            user.setDeleterUserId("1");
            user.setDeletionTime(new Date(0));
            user.setIsDeleted(false);
            user.setCreatorUserId("1");
            user.setCreatorUserName("王"+i);
            user.setLastModificationTime(new Date());
            user.setLastModifierUserId("1");
            user.setEmail("123@qq.com");
            user.setMobile("13000000000");
            user.setNickname("王"+i);
            user.setPassword("123456");
            user.setUsername("wang"+i);
            user.setSalt("12345");
            System.out.println("insert userId:"+l+" workerHashCode:"+snowflakeIdWorker.hashCode());
            int insert = userMapper.insert(user);
            System.out.println("insert result:" + insert);
        }

    }

    @Test
    public void getId() throws Exception{
        long lastId = -1L;
        for (int i = 0; i < 100; i++) {
            long nextId = snowflakeIdWorker.nextId();
            if(lastId == nextId){
                throw new Exception("occurred Error");
            }
            System.out.println(nextId);
            lastId = nextId;
        }
    }



}
