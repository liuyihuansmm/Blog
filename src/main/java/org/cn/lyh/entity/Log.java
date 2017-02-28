package org.cn.lyh.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by LYH on 2017-02-28.
 * 日志实体类
 */
public class Log {

    private Integer lid;

    private User owner;

    private String title;

    private byte[] content;

    private Date createTime;

    public Log(){};

    public Log(User owner, String title, byte[] content) {
        this.owner = owner;
        this.title = title;
        this.content = content;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Log{" +
                "lid=" + lid +
                ", owner=" + owner +
                ", title='" + title + '\'' +
                ", content=" + Arrays.toString(content) +
                ", createTime=" + createTime +
                '}';
    }
}
