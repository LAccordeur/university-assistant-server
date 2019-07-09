package com.uppfind.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by LAccordeur on 2017/5/31.
 * 返回给前端的数据
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private T data;

    private Integer count;      //总记录数


    private String type; //返回的查询数据类型

    /**
     * 默认的错误显示消息
     */
    private static final String DEFAULT_ERROR_MESSAGE = "Oops!不知道发生了什么错！客官对不起！";

    /**
     * 编码
     */
    private Integer code;

    /**
     * 描述信息
     */
    private String msg;

    public Response() {

    }

    public Response(Integer code) {
        this.code = code;
    }

    public Response(String msg) {
        this.msg = msg;
    }



    public Response(Throwable throwable, Integer code) {
        this.code = code;
        this.msg = throwable.getMessage();
    }

    /**
     * @param data
     */
    public Response(T data) {
        this.data = data;
    }

    /**
     * @param data
     */
    public Response(T data, String msg) {
        this.msg = msg;
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    @Override
    public String toString() {
        return "Response{" +
                "date=" + data +
                ", count=" + count +
                ", type='" + type + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public T getData() {
        return data;
    }

    public Response(T data, Integer count, String type, Integer code, String msg) {
        this.data = data;
        this.count = count;
        this.type = type;
        this.code = code;
        this.msg = msg;
    }

    public void setData(T date) {
        this.data = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
