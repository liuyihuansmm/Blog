package org.cn.lyh.dao;

import org.apache.ibatis.annotations.Param;
import org.cn.lyh.entity.LogComment;

import java.util.List;

/**
 * Created by LYH on 2017-02-28.
 */
public interface LogCommentDao {

    /**
     *
     * @param lid
     * @param content
     * @param fromId
     * @param toId
     * @return
     *
     * 发表/回复评论
     */
    int addComment(@Param("lid") int lid, @Param("content") String content,
                   @Param("fromId") String fromId, @Param("toId") String toId);

    List<LogComment> getAll(@Param("logId") int logId);

}
