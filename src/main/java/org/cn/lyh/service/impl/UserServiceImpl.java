package org.cn.lyh.service.impl;

import org.cn.lyh.dao.LogDao;
import org.cn.lyh.dao.UserDao;
import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.User;
import org.cn.lyh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lyh on 17-3-1.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogDao logDao;

    /**
     *
     * @param username
     * @param password
     * @return
     * 用户登录校验
     */
    public User signIn(String username, String password) {
        User user = userDao.signIn(username,password);
        if(user == null){
            logger.debug("用户名或密码无效");
            return  null; //TODO
        }
        return  user;
    }

    /**
     *
     * @param username
     * @param nickName
     * @param password
     * @param email
     * @param headPicture
     * @return
     * 用户注册
     */
    public RegistUser signUp(String username, String nickName, String password, String email, String headPicture) {
        int insertCount = userDao.signUp(username,nickName,password,email,headPicture);
        if (insertCount != 0){
            User user = userDao.signIn(username,password);
            return  new RegistUser(true,user);
        }
        logger.debug("用户已注册!");
        return new RegistUser(false,null);
    }

    public List<User> search(String nickName) {
        List<User> userList = userDao.queryByName(nickName);
        if (userList.size() <1){
            logger.debug("查无此用户");
            return null; //TODO
        }
        return  userList;
    }


    public User queryByInnerId(Integer innerId) {
        return userDao.queryByInnerId(innerId);
    }

    @Override
    public User queryById(String uid) {
        return userDao.queryById(uid);
    }

    @Override
    public boolean addPicture(String url, Integer innerid) {
        return userDao.addPic(url,innerid)==1?true:false;
    }

    //下面两个接口，因为dao层未写好,暂时不考虑
    public boolean addFriend(String nickName) {
        return false;
    }

    public List<User> listFriends() {
        return null;
    }

}
