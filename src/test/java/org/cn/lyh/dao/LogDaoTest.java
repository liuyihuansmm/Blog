package org.cn.lyh.dao;

import org.cn.lyh.entity.Log;
import org.cn.lyh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LYH on 2017-02-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class LogDaoTest {

    @Resource
    private LogDao logDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

     @Test
    public void addLog() throws Exception {

         User u = new User("liuyihuan123","嘉祥瑞庭南城说好","lyh1993829","abc@163.com");
         String title="SSM";
         byte[] content ="互联网工资常用框架".getBytes();

         Log log = new Log(u,title,content);
         int index = logDao.addLog(log);
         logger.debug(index+"");
    }

    @Test
    public void updateLog() throws Exception {
        Log log = logDao.queryById(2);
        int index = logDao.updateLog(log.getLid(),"Hibernate",log.getContent());
    }

    @Test
    public void deleteLog() throws Exception {
        int index=logDao.deleteLog(1);
        logger.debug(""+index);
    }

    @Test
    public void queryAll() throws Exception {
        List<Log> logList = logDao.queryAll("liuyihuan123");
        for (Log log:logList){
            logger.debug("结果:"+log);
        }
    }

    @Test
    public void queryById() throws Exception {
        Log log = logDao.queryById(1);
        logger.debug(new String(log.getContent()));
    }
}