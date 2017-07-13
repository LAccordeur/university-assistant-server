package com.uppfind.entity;

/**
 * Created by guoyang on 2017/5/31.
 */


import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 对应学校表的实体类
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class University {
    private Integer id;     //学校代码

    private String university;      //学校名称

    private String englishName;     //学校英文名

    private String establishedTime;       //建立时间形如1988年

    private String location;        //地理位置(省份)

    private String uType;       //学校类型（理工、综合等）

    private String property;        //学校属性（985,211）

    private String department;      //主管部门

    private String website;     //学校官网

    private String icon;        //学校图标（路径）

    private String image;       //学校图片（路径）

    private String introduction;        //学校简介

    private String history;     //学校历史

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", university='" + university + '\'' +
                ", englishName='" + englishName + '\'' +
                ", establishedTime='" + establishedTime + '\'' +
                ", location='" + location + '\'' +
                ", uType='" + uType + '\'' +
                ", property='" + property + '\'' +
                ", department='" + department + '\'' +
                ", website='" + website + '\'' +
                ", icon='" + icon + '\'' +
                ", image='" + image + '\'' +
                ", introduction='" + introduction + '\'' +
                ", history='" + history + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEstablishedTime() {
        return establishedTime;
    }

    public void setEstablishedTime(String establishedTime) {
        this.establishedTime = establishedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
