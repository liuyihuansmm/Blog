package org.cn.lyh.dto;

import org.cn.lyh.entity.User;

/**
 * Created by lyh on 17-3-1.
 */
public class RegistUser {

    private boolean isTrue;

    private User user;

    public RegistUser(boolean isTrue,User user){
        this.isTrue = isTrue;
        this.user =user;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
