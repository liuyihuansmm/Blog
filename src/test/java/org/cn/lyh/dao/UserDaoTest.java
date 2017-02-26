package org.cn.lyh.dao;

import org.cn.lyh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by lyh on 17-2-26.
 * spring和junit整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void signUp() throws Exception {
        User u = new User("liuyihuan","爸爸妈妈说名字太长不太好","lyh1993829","abc@163.com");
        userDao.signUp(u);
    }

    @Test
    public void signIn() throws Exception {

    }

    @Test
    public void addFriends() throws Exception {

    }

    @Test
    public void queryByName() throws Exception {

    }

}