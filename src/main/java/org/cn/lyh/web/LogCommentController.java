package org.cn.lyh.web;

import org.cn.lyh.entity.User;
import org.cn.lyh.service.LogCommentService;
import org.cn.lyh.service.NoticeService;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LYH on 2017/3/9.
 */
@Controller
public class LogCommentController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogCommentService logCommentService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private UserService userService;

    /**
     *
     * @param lid
     * @param content
     * @param fromid
     * @param toid
     * @return
     * 发表评论
     */
    @RequestMapping(value = "/log/{lid}/comments",method = RequestMethod.POST)
    @Transactional
    public String pubComment(@PathVariable("lid") Integer lid, String content, String fromid,String toid){
        User fromWho = userService.queryById(fromid);
        User toWho = userService.queryById(toid);

        String noticeContent = fromWho.getNickName()+" 评论了您的日志";
        String noticeUrl = "/log/"+lid;

        logCommentService.pubComment(lid,content,fromWho.getUid(),toWho.getUid()); //TODO toid暂时默认log的owner,fromid是当前登录用户
        noticeService.addNotice(toWho.getInnerId(), noticeContent,noticeUrl);
        return "redirect:/log/"+lid;
    }

}
