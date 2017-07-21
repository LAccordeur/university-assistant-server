package com.uppfind.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by LAccordeur on 2017/7/18.
 * 与点赞表对应的实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Like {

    private Integer id; //主键

    private String targetId; //点赞对象的id

    private Integer targetType; //点赞对象的类型（1为老师）

    private Integer likeCount; //点赞数

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", targetId='" + targetId + '\'' +
                ", targetType=" + targetType +
                ", likeCount=" + likeCount +
                '}';
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
