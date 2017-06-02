package com.uppfind.dto;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by LAccordeur on 2017/5/31.
 * 返回给前端的数据
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Response<T> {
    private Integer total;      //总记录数

    private Integer start;

    private Integer count;

    private T data;

    @Override
    public String toString() {
        return "Response{" +
                "total=" + total +
                ", start=" + start +
                ", count=" + count +
                ", data=" + data +
                '}';
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
