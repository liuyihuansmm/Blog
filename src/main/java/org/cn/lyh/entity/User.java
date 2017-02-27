package org.cn.lyh.entity;

import java.util.Date;

/**
 * Created by lyh on 17-2-25.
 * 用户实体类
 */
public class User {

    private String uid;

    private Integer innerId;

    private String nickName;

    private String password;

    private String email;

    private String headPicture;

    private Date createTime;

    public User(){}

    public User(String uid, String nickName, String password, String email) {
        this.uid = uid;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getInnerId() {
        return innerId;
    }

    public void setInnerId(Integer innerId) {
        this.innerId = innerId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", innerId=" + innerId +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", headPicture='" + headPicture + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
