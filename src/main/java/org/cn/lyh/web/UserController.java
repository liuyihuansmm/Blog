package org.cn.lyh.web;

import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.Log;
import org.cn.lyh.entity.User;
import org.cn.lyh.service.LogService;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

    @Autowired
    private LogService logService;
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
            //List<Log> logList = logService.queryAllLog(user.getUid());
            model.addAttribute("currentUser",user);
            model.addAttribute("isLoged",true);
            //model.addAttribute("logList",logList);
            return "redirect:/user/"+user.getInnerId();
        }
        return "redirect:/login";
    }

    @RequestMapping(value = {"/user/{innerId}","/user/{innerId}/logs"})
    public  String homeUI(@PathVariable("innerId") Integer innerId,Model model){
        User user = userService.queryByInnerId(innerId);
        List<Log> logList = logService.queryAllLog(user.getUid());
        model.addAttribute("user",user);
        model.addAttribute("logList",logList);
        return "home";
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
       return "redirect:/user/"+user.getUser().getInnerId();
    }

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @ResponseBody
    public List<String> searchUserAjax(String nickname){
        try {
            nickname =java.net.URLDecoder.decode(nickname, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(nickname);//TODO
        List<String> nameList = new ArrayList<String>();
        if(nickname !=null && !nickname.equals("")){
            List<User> userList = userService.search(nickname);
            for(User u: userList){
                System.out.println(u.getNickName());
                nameList.add(u.getNickName());
            }
        }
        return  nameList;
    }

}
