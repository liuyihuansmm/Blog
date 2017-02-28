package org.cn.lyh.entity;

import java.util.Date;

/**
 * Created by LYH on 2017-02-28.
 * 日志评论实体类
 */
public class LogComment {

    private int lgCommentId;

    private Log log;

    private String content;

    private User fromWho;

    private User toWho;

    private Date createTime;

    public LogComment(){}

    public int getLgCommentId() {
        return lgCommentId;
    }

    public void setLgCommentId(int lgCommentId) {
        this.lgCommentId = lgCommentId;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getFromWho() {
        return fromWho;
    }

    public void setFromWho(User fromWho) {
        this.fromWho = fromWho;
    }

    public User getToWho() {
        return toWho;
    }

    public void setToWho(User toWho) {
        this.toWho = toWho;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
