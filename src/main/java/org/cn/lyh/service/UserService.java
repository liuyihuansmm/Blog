package org.cn.lyh.service;

import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.Log;
import org.cn.lyh.entity.User;

import java.util.List;

/**
 * Created by LYH on 2017/3/1.
 * 业务接口设计要站在"使用者"的角度考虑
 * 三个方面:方法定义粒度/参数/返回类型(return /异常)
 */
public interface UserService {

    /**
     *
     * @param username
     * @param password
     * @return
     * 登录
     *
     */
    User signIn(String username, String password);

    /**
     *
     * @param username
     * @param nickName
     * @param password
     * @param email
     * @param headPicture
     * @return
     * 注册
     */
    RegistUser signUp(String username, String nickName, String password, String email, String headPicture);

    /**
     *
     * @param nickName
     * @return
     * 查询用户
     */
    List<User> search(String nickName);

    //下面两个接口，因为dao层未写好,暂时不考虑
    boolean addFriend(String nickName);

    List<User> listFriends();

    /**
     *
     * @param hostId
     * @return
     * 查询hostId用户所有的日志
     */
    //List<Log> queryAllLog(String hostId);

    /**
     *
     * @param hostId
     * @param title
     * @param content
     * @return
     * 发表日志
     */
    //boolean publishLog(String hostId,String title,byte[] content);


}
