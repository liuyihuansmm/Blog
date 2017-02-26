package org.cn.lyh.dao;

import org.cn.lyh.entity.User;

import java.util.List;

/**
 * Created by lyh on 17-2-26.
 */
public interface UserDao {

    /**
     * 用户注册
     * @param user
     * @return
     */
    int signUp(User user);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    User signIn(String userName,String password);

    /**
     * 添加好友
     * @param user
     * @return
     */
    List<User> addFriends(User user);

    /**
     * 查找用户
     * @param name
     * @return
     */
    List<User> queryByName(String name);
}
