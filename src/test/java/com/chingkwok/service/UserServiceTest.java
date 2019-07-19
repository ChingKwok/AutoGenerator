package com.chingkwok.service;

import com.chingkwok.bean.entity.User;
import com.chingkwok.component.SnowflakeIdWorker;
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
    SnowflakeIdWorker snowflakeIdWorker;

    @Test
    public void insert(){
        User user = new User();
        user.setUserId(snowflakeIdWorker.nextId());
        user.setCreationTime(new Date());
        user.setDeleterUserId("1");
        user.setDeletionTime(new Date(0));
        user.setIsDeleted(false);
        user.setCreatorUserId("1");
        user.setCreatorUserName("王五");
        user.setLastModificationTime(new Date());
        user.setLastModifierUserId("1");
        user.setEmail("123@qq.com");
        user.setMobile("13000000000");
        user.setNickname("王五");
        user.setPassword("123456");
        user.setUsername("wangwu");
        user.setSalt("12345");
        int insert = userService.insert(user);
        System.out.println("insert result:"+insert);
    }

}
