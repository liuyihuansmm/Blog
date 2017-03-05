package org.cn.lyh.web;

import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.Log;
import org.cn.lyh.entity.User;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lyh on 17-3-1.
 */
@Controller
@SessionAttributes( {"currentUser","isLoged"})
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    /**
     *
     * @param username
     * @param password
     * @param model
     * @param httpSession
     * @return
     * 登录
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String signIn(String username, String password, Model model, HttpSession httpSession){

        User user = userService.signIn(username,password);

        if (user!=null){
            httpSession.setAttribute("currentUser",user);
            List<Log> logList = userService.queryAllLog(user.getUid());
            model.addAttribute("currentUser",user);
            model.addAttribute("isLoged",true);
            model.addAttribute("logList",logList);
            return "home";
        }
        return "redirect:/login";
    }

    /**
     *
     * @param regusername
     * @param regnickname
     * @param regpassword
     * @param regemail
     * @param model
     * @return
     * 注册
     */
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String sinUp(String regusername, String regnickname,String regpassword,String regemail,Model model){
       RegistUser user = userService.signUp(regusername,regnickname,regpassword,regemail,null);
       if(!user.isTrue()){
           logger.debug("注册失败:");//TODO
           return "redirect:/login";
       }
       model.addAttribute("currentUser",user.getUser());
       model.addAttribute("isLoged",true);
       return "home";
    }

    @RequestMapping(value = "/logs",method = RequestMethod.GET)
    public String logsUI(HttpSession session,Model model){
        User u = (User) session.getAttribute("currentUser");
        List<Log> logList = userService.queryAllLog(u.getUid());
        model.addAttribute("logList",logList);
        return "home";
    }

    /**
     * 发表日志UI
     * @return
     */
    @RequestMapping(value = "/log/publish")
    public String publishLogUI(){
        return "test";
    }

    @RequestMapping(value = "/log/publish/do",method = RequestMethod.POST)
    public String publishLog(String title, byte[] content,HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        String hostId = currentUser.getUid();
        boolean pubFlag = userService.publishLog(hostId,title,content);
        if (!pubFlag) {
            logger.debug("日志发表失败!");
            return "redirect:/logs";//TODO
        }
        return "redirect:/logs";
    }

}
