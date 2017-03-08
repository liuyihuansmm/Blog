package org.cn.lyh.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by lyh on 17-2-27.
 */
@Controller
@RequestMapping()
public class LoginController {

    @RequestMapping({"/","/login"})
    public String LoginUI(HttpSession session){
        /**
         * 安全退出逻辑,清掉session
         */
        if(session.getAttribute("isLoged") != null){
            //方法一
            session.invalidate();
            //方法二
            /**
            Enumeration<String> sessionAttrs = session.getAttributeNames();
            while (sessionAttrs.hasMoreElements())
                session.removeAttribute(sessionAttrs.nextElement());
             **/
        }

        return "login";
    }
}
