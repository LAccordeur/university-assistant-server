package com.uppfind.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by LAccordeur on 2017/5/31.
 * 返回给前端的数据
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Response<T> {

    private T result;

    private Integer total;      //总记录数

    private Integer start;

    private Integer count;

    private String type; //返回的查询数据类型

    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", total=" + total +
                ", start=" + start +
                ", count=" + count +
                ", type='" + type + '\'' +
                '}';
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
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
}
