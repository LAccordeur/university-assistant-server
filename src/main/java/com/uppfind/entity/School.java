package com.uppfind.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by LAccordeur on 2017/5/31.
 * 与学院表对应的实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class School {
    private Long id;     //学院代码

    private String school;      //学院名称

    private String englishName;     //学院英文名

    private Integer universityCode;     //所属学校的id

    private String establishedTime;     //创办时间

    private String icon;        //学院图标

    private String image;       //学院图片

    private String website;     //学院官网

    private String introduction;        //学院简介

    private String majors;       //开设专业

    private String university;      //该学院所属学校

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", englishName='" + englishName + '\'' +
                ", universityCode=" + universityCode +
                ", establishedTime='" + establishedTime + '\'' +
                ", icon='" + icon + '\'' +
                ", image='" + image + '\'' +
                ", website='" + website + '\'' +
                ", introduction='" + introduction + '\'' +
                ", majors='" + majors + '\'' +
                ", university='" + university + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Integer getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(Integer universityCode) {
        this.universityCode = universityCode;
    }

    public String getEstablishedTime() {
        return establishedTime;
    }

    public void setEstablishedTime(String establishedTime) {
        this.establishedTime = establishedTime;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
