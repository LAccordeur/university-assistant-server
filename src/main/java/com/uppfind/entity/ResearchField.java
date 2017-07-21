package com.uppfind.entity;

/**
 * Created by LAccordeur on 2017/7/10.
 */

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 导师研究方向实体
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResearchField {
    private Long id;        //导师代码

    private Integer majorCode;      //招生专业代码

    private String name;        //导师姓名

    private String university;      //学校名称

    private Integer universityCode;     //学校代码

    private String school;      //学院名称

    private Long schoolCode;        //学院代码

    private String icon;        //学院图标

    private String image;       //学院图片

    private String major;       //招生专业名称

    private String field;       //专业细分方向

    @Override
    public String toString() {
        return "ResearchField{" +
                "id=" + id +
                ", majorCode=" + majorCode +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", universityCode=" + universityCode +
                ", school='" + school + '\'' +
                ", schoolCode=" + schoolCode +
                ", icon='" + icon + '\'' +
                ", image='" + image + '\'' +
                ", major='" + major + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(Integer majorCode) {
        this.majorCode = majorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(Integer universityCode) {
        this.universityCode = universityCode;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Long getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(Long schoolCode) {
        this.schoolCode = schoolCode;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
