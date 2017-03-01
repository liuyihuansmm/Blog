package org.cn.lyh.service;

import org.cn.lyh.entity.User;

/**
 * Created by LYH on 2017/3/1.
 * 业务接口设计要站在"使用者"的角度考虑
 * 三个方面:方法定义粒度/参数/返回类型(return /异常)
 */
public interface UserService {


    boolean signIn(String username, String password);

    User signUp(String username,String nickName,String password,String email,String headPicture);


}
