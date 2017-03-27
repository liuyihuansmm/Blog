package org.cn.lyh.dao;

import org.apache.ibatis.annotations.Param;
import org.cn.lyh.entity.Notice;

import java.util.List;

/**
 * Created by LYH on 2017-3-22.
 */
public interface NoticeDao {

    /**
     * 新增系统通知
     * @param hostid
     * @param content
     * @param url
     * @return
     */
    int addNotice(@Param("hostid") int hostid, @Param("content") String content, @Param("url") String url);

    /**
     * 修改通知状态
     * @param nid
     * @return
     */
    int updateNotice(@Param("nid") int nid);

    /**
     * 查询hostid用户下状态为status的系统通知
     * @param hostid
     * @param status
     * @return
     */
    List<Notice> queryNotice(@Param("hostid") int hostid,@Param("status") int status);

}
