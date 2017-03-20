package org.cn.lyh.service.impl;

import org.cn.lyh.dao.LogDao;
import org.cn.lyh.dto.PageBean;
import org.cn.lyh.entity.Log;
import org.cn.lyh.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LYH on 2017/3/6.
 */
@Service
public class LogServiceImpl implements LogService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogDao logDao;

    /**
     *
     * @param hostId
     * @return
     * 查询用户id为hostId的所有日志，加入分页
     */
    public List<Log> queryAllLog(String hostId, PageBean page) {
        List<Log> logList = logDao.queryAll(hostId,page);
        return logList;
    }

    /**
     *
     * @param hostId
     * @param title
     * @param content
     * @return
     * 发表日志
     */
    public boolean publishLog(String hostId, String title, byte[] content) {
        int insertCount = logDao.addLog(hostId,title,content);
        if(insertCount>0){
            return true;
        }
        return  false;
    }

    /**
     *
     * @param lid
     * @return
     * 查询id为lid的日志
     */
    public Log queryById(Integer lid) {
        return logDao.queryById(lid);
    }

    /**
     *
     * @param lid
     * @return
     * 删除id为lid的日志
     */
    public int deleteLog(Integer lid) {
        return logDao.deleteLog(lid);
    }

    public Integer count(String uid) {
        return logDao.count(uid);
    }
}
