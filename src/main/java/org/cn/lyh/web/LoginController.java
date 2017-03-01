package org.cn.lyh.web;

import org.cn.lyh.entity.User;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lyh on 17-2-27.
 */
@Controller
@RequestMapping()
public class LoginController {

    @RequestMapping({"/","/login"})
    public String LoginUI(){
        return "login";
    }

}
