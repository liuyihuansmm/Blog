package org.cn.lyh.web;

import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.User;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by lyh on 17-3-1.
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String signIn(String username, String password, Model model, HttpSession httpSession){

        User user = userService.signIn(username,password);

        if (user!=null){
            httpSession.setAttribute("currentUser",user);
            model.addAttribute("currentUser",user);
            return "test";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String sinUp(String regusername, String regnickname,String regpassword,String regemail,Model model){
       RegistUser user = userService.signUp(regusername,regnickname,regpassword,regemail,null);
       if(!user.isTrue()){
           logger.debug("注册失败:");//TODO
           return "redirect:/login";
       }
       model.addAttribute("currentUser",user.getUser());
       return "test";
    }

}
