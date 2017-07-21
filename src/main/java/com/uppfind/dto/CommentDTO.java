package com.uppfind.dto;

/**
 * Created by LAccordeur on 2017/7/21.
 */
public class CommentDTO {
    private String id; //评论对象的主键id

    private Integer type; //评论对象类型

    private String content; //评论内容

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", targetType=" + type +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
