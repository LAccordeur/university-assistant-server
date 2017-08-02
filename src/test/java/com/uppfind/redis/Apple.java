package com.uppfind.redis;

import java.io.Serializable;

/**
 * Created by LAccordeur on 2017/8/1.
 */
public class Apple {
    private String id;
    private String color;

    @Override
    public String toString() {
        return "Apple{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
