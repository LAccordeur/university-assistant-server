package com.uppfind.entity;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created by LAccordeur on 2017/7/17.
 * 评论表
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Comment {
    private Integer id; //评论id

    private String targetId; //评论对象id

    private Integer targetType; //评论对象类型

    private String content; //评论内容

    private String userName; //评论者名字

    private String createTime; //评论时间

    private Integer likeCount; //点赞数

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", targetId='" + targetId + '\'' +
                ", targetType=" + targetType +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", likeCount=" + likeCount +
                '}';
    }

    public Comment() {}

    public Comment(String targetId, int targetType, String content, String userName) {
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
