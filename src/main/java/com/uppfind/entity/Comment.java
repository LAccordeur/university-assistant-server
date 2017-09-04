package com.uppfind.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by LAccordeur on 2017/7/17.
 * 评论表
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Comment {
    private Integer id; //评论id

    private String targetId; //评论对象id

    private Integer targetType; //评论对象类型

    private String content; //评论内容

    private String userName; //评论者名字

    private Date createTime; //评论时间

    private Integer likeCount; //点赞数

    private Integer isLike; //该评论是否被某用户点赞

    private String userId;  //点赞用户

    private String icon;   //评论者头像uri


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", targetId='" + targetId + '\'' +
                ", targetType=" + targetType +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", likeCount=" + likeCount +
                ", isLike=" + isLike +
                ", userId='" + userId + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Comment() {}

    public Comment(String targetId, Integer targetType, String token) {
        this.targetId = targetId;
        this.targetType = targetType;
        this.userId = token;
    }

    public Comment(String targetId, Integer targetType, String content, String userName) {
        this.targetId = targetId;
        this.targetType = targetType;
        this.content = content;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
