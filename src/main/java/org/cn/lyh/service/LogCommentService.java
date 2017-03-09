package org.cn.lyh.service;

import org.cn.lyh.entity.LogComment;

import java.util.List;

/**
 * Created by LYH on 2017/3/9.
 */
public interface LogCommentService {

    /**
     *
     * @param lid
     * @param content
     * @param fromid
     * @param toid
     * @return
     * 发表评论/回复
     */
    int pubComment(Integer lid,String content,String fromid,String toid);

    /**
     *
     * @param lid
     * @return
     * 获取log id为lid日志下的所有评论及回复
     */
    List<LogComment> queryAll(Integer lid);
}
