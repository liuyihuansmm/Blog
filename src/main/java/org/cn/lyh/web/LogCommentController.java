package org.cn.lyh.web;

import org.cn.lyh.service.LogCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String pubComment(@PathVariable("lid") Integer lid, String content, String fromid,String toid){
        logCommentService.pubComment(lid,content,fromid,toid); //TODO toid暂时默认log的owner,fromid是当前登录用户
        return "redirect:/log/"+lid;
    }

}
