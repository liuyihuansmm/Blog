package org.cn.lyh.dao;

import org.apache.ibatis.annotations.Param;
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
    User signIn(@Param("userName") String userName,@Param("password") String password);

    /**
     * 添加好友
     * @param hostId
     * @param friendId
     * @return
     */
    int addFriend(@Param("hostId") String hostId,@Param("friendId") String friendId);

    /**
     * 根据昵称查找用户
     * @param name
     * @return
     */
    List<User> queryByName(@Param("nickName") String name);
}
