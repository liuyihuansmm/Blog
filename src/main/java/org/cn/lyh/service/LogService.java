package org.cn.lyh.service;

import org.cn.lyh.dto.PageBean;
import org.cn.lyh.entity.Log;

import java.util.List;

/**
 * Created by LYH on 2017/3/6.
 */
public interface LogService {

    /**
     *
     * @param hostId
     * @return
     * 查询hostId用户所有的日志
     */
    List<Log> queryAllLog(String hostId, PageBean page);

    /**
     *
     * @param hostId
     * @param title
     * @param content
     * @return
     * 发表日志
     */
    boolean publishLog(String hostId,String title,byte[] content);

    /**
     *
     * @param lid
     * @return
     * 查询日志
     */
    Log queryById(Integer lid);

    /**
     *
     * @param lid
     * @return
     * 删除日志
     */
    int deleteLog(Integer lid);

    /**
     *
     * @param uid
     * @return
     * 查询uid下有多少日志，以便分页
     */
    Integer count(String uid);


}
