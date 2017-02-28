package org.cn.lyh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by LYH on 2017-02-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class LogCommentDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private LogCommentDao logCommentDao;

    @Test
    public void addComment() throws Exception {
            logCommentDao.addComment(2,"感谢分享","liuyihuanssssss","liuyihuan123");
    }

    @Test
    public void getAll() throws Exception {

    }

}