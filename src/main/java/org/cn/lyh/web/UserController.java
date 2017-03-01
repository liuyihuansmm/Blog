package org.cn.lyh.web;

import org.cn.lyh.entity.User;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lyh on 17-3-1.
 */
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String signIn(String username,String password, Model model){

        User user = userService.signIn(username,password);

        if (user!=null){
            model.addAttribute("currentUser",user);
            return "home";
        }
        return "redirect:/login";
    }


}
