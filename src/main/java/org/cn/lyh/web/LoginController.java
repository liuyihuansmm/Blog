package org.cn.lyh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lyh on 17-2-27.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("/login")
    public String LoginUI(){
        return "login";
    }

}
