package org.cn.lyh.service.impl;

import org.cn.lyh.dao.LogDao;
import org.cn.lyh.dao.UserDao;
import org.cn.lyh.dto.RegistUser;
import org.cn.lyh.entity.Log;
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

    public User signIn(String username, String password) {
        User user = userDao.signIn(username,password);
        if(user == null){
            logger.debug("用户名或密码无效");
            return  null; //TODO
        }
        return  user;
    }

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

    public List<Log> queryAllLog(String hostId) {
        List<Log> logList = logDao.queryAll(hostId);
        return logList;
    }

    //下面两个接口，因为dao层未写好,暂时不考虑
    public boolean addFriend(String nickName) {
        return false;
    }

    public List<User> listFriends() {
        return null;
    }

}
