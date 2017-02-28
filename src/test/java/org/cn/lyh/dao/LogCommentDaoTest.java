package org.cn.lyh.dao;

import org.cn.lyh.entity.LogComment;
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
public class LogCommentDaoTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private LogCommentDao logCommentDao;

    @Test
    public void addComment() throws Exception {
            logCommentDao.addComment(2,"我有个问题请教.能加下好友马","liuyihuanssssss","liuyihuan123");
    }

    @Test
    public void getAll() throws Exception {
        List<LogComment> commentList = logCommentDao.getAll(1);
        for (LogComment logComment:commentList){
            logger.debug("===========分割线===========");
            logger.debug("针whichLog:"+logComment.getLog());
            logger.debug("fromWho:"+logComment.getFromWho());
            logger.debug("toWho:"+logComment.getToWho());
            logger.debug("comment:"+logComment.getContent());
        }

    }

}