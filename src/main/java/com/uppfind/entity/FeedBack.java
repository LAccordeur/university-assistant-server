package com.uppfind.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback {
    private Integer num;        //问题序号

    private Timestamp timestamp;        //反馈时间

    private String contact;     //联系方式

    private String problem;     //问题类型

    private String detail;      //反馈内容

    public Feedback() {
    }

    public Feedback(String contact, String problem, String detail) {
        this.contact = contact;
        this.problem = problem;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "num=" + num +
                ", timestamp=" + timestamp +
                ", contact='" + contact + '\'' +
                ", problem='" + problem + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
