package org.cn.lyh.service.impl;

import org.cn.lyh.dao.LogDao;
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

    public List<Log> queryAllLog(String hostId) {
        List<Log> logList = logDao.queryAll(hostId);
        return logList;
    }

    public boolean publishLog(String hostId, String title, byte[] content) {
        int insertCount = logDao.addLog(hostId,title,content);
        if(insertCount>0){
            return true;
        }
        return  false;
    }
}
