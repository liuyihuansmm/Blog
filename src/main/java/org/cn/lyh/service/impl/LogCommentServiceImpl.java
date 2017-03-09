package org.cn.lyh.service.impl;

import org.cn.lyh.dao.LogCommentDao;
import org.cn.lyh.entity.LogComment;
import org.cn.lyh.service.LogCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LYH on 2017/3/9.
 */
@Service
public class LogCommentServiceImpl implements LogCommentService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogCommentDao logCommentDao;

    /**
     *
     * @param lid
     * @param content
     * @param fromid
     * @param toid
     * @return
     * 发表评论
     */
    @Override
    public int pubComment(Integer lid, String content, String fromid, String toid) {

        return logCommentDao.addComment(lid,content,fromid,toid);
    }

    /**
     *
     * @param lid
     * @return
     * 返回lid日志下的所有评论或回复
     */
    @Override
    public List<LogComment> queryAll(Integer lid) {
        List<LogComment> commentList = logCommentDao.getAll(lid);
        return commentList;
    }
}
