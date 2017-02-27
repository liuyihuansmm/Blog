package org.cn.lyh.dao;

import org.cn.lyh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lyh on 17-2-26.
 * spring和junit整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserDaoTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserDao userDao;

    @Test
    public void signUp() throws Exception {
        User u = new User("liuyihuan","爸爸妈妈说名字太长不太好","lyh1993829","abc@163.com");
        userDao.signUp(u);
    }

    @Test
    public void signIn() throws Exception {
      User u = userDao.signIn("liuyihuan","lyh1993829");
      if(u==null){
        log.debug("无效用户");
      }
      else{
          log.info(u.toString());
      }
    }

    @Test
    public void addFriends() throws Exception {

    }

    @Test
    public void queryByName() throws Exception {

    }

}