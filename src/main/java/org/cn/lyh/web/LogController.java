package org.cn.lyh.web;

import org.cn.lyh.entity.Log;
import org.cn.lyh.entity.LogComment;
import org.cn.lyh.entity.User;
import org.cn.lyh.service.LogCommentService;
import org.cn.lyh.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by LYH on 2017/3/6.
 */
@Controller
public class LogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogService logService;

    @Autowired
    private LogCommentService logCommentService;

    @RequestMapping(value = "/logs",method = RequestMethod.GET)
    public String logsUI(HttpSession session, Model model){
        User u = (User) session.getAttribute("currentUser");
        List<Log> logList = logService.queryAllLog(u.getUid());
        model.addAttribute("logList",logList);
        return "home";
    }

    /**
     * 发表日志UI
     * @return
     */
    @RequestMapping(value = "/log/publish")
    public String publishLogUI(){
        return "/log/logEditUI";
    }

    @RequestMapping(value = "/log/publish/do",method = RequestMethod.POST)
    public String publishLog(String title, @RequestParam("content") String strContent, HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        String hostId = currentUser.getUid();
        byte[] content = new byte[0];
        try {
            content = strContent.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        boolean pubFlag = logService.publishLog(hostId,title,content);
        if (!pubFlag) {
            logger.debug("日志发表失败!");
            return "redirect:/logs";//TODO
        }
        return "redirect:/logs";
    }

    /**
     *
     * @param lid
     * @param model
     * @return
     * 点击Readmore按钮后
     */
    @RequestMapping(value = "/log/{lid}",method = RequestMethod.GET)
    public String logDetail(@PathVariable("lid") Integer lid,Model model){
        Log log = logService.queryById(lid);
        User user = log.getOwner();
        List<LogComment> commentList =  logCommentService.queryAll(lid);
        model.addAttribute("user",user);
        model.addAttribute("log",log);
        model.addAttribute("commentList",commentList);
        return "/log/logDetail";
    }

    /**
     *
     * @param lid
     * @return
     * 删除日志
     */
    @RequestMapping(value = "/log/{lid}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delLog(@PathVariable("lid") Integer lid){
        logService.deleteLog(lid);
    }
}
