package org.cn.lyh.service.impl;

import org.cn.lyh.dao.NoticeDao;
import org.cn.lyh.entity.Notice;
import org.cn.lyh.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LYH on 2017-3-22.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NoticeDao noticeDao;

    public boolean addNotice(int hostid, String content, String url) {
        int count = noticeDao.addNotice(hostid,content,url);
        if (count==0){
            logger.info("添加系统消息失败");
            return false;
        }
        return true;
    }

    public boolean updateNotice(int nid) {
        int count =  noticeDao.updateNotice(nid);
        if (count==0){
            logger.info("更新系统消息状态失败");
            return false;
        }
        return true;
    }

    public List<Notice> queryNotice(int hostid, int status) {
        List<Notice> noticeList;
        noticeList =  noticeDao.queryNotice(hostid,status);
        return  noticeList;
    }
}
