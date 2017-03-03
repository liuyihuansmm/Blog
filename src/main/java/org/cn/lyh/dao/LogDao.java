package org.cn.lyh.dao;

import org.apache.ibatis.annotations.Param;
import org.cn.lyh.entity.Log;

import java.util.List;

/**
 * Created by LYH on 2017-02-28.
 */
public interface LogDao {

    /**
     * 发表日志
     * @param hostId
     * @param title
     * @param content
     * @return
     */
    int addLog(@Param("hostId") String hostId,@Param("title") String title,@Param("content") byte[] content);

    /**
     * 修改日志
     * @param lid
     * @param tiltle
     * @param content
     * @return
     */
    int updateLog(@Param("lid") int lid,@Param("title") String tiltle, @Param("content") byte[] content);

    /**
     * 删除日志
     * @param lid
     * @return
     */
    int deleteLog(int lid);

    /**
     * 遍历hostid用户下所有日志
     * @param hostId
     * @return
     */
    List<Log> queryAll(@Param("hostid") String hostId);

    /**
     * 根据lid查询Log
     * @param lid
     * @return
     */
    Log queryById(@Param("lid") int lid);
}
