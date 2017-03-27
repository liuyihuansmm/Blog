package org.cn.lyh.service;


import org.cn.lyh.entity.Notice;

import java.util.List;

/**
 * Created by LYH on 2017-3-22.
 */
public interface NoticeService {

    boolean addNotice(int hostid, String content, String url);

    boolean updateNotice(int nid);

    List<Notice> queryNotice(int hostid, int status);

}
