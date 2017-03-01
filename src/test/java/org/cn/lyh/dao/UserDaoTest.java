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
        userDao.signUp("liuyihuan123","嘉祥瑞庭南城说好","lyh1993829","abc@163.com",null);
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
    public void addFriend() throws Exception {
        //liuyihuan123,liuyihuanssssss
        String host="liuyihuan123";
        String friend="liuyihuanssssss";
        int result = userDao.addFriend(host,friend);
        log.debug(""+result);
    }

    @Test
    public void queryByName() throws Exception {
        List<User> listUser = userDao.queryByName("好");
        if(listUser.size()==0){
            log.debug("未查到用户");
        }else{
            for(User u: listUser){
                log.info(u.toString());
            }
        }
    }

}