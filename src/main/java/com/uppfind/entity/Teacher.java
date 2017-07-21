package com.uppfind.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by LAccordeur on 2017/5/31.
 * 对应teacher视图的实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Teacher {
    private Long id;     //导师代码

    private String name;        //导师姓名

    private String school;      //学院名称

    private Long schoolCode;      //学院代码

    private String university;      //学校名称

    private Integer universityCode;      //学校代码

    private String icon;        //导师照片

    private String gender;      //导师性别

    private String title;       //导师职称

    private String degree;      //导师学位

    private String property;        //导师属性

    private String email;       //邮箱

    private String experience;       //学术经历

    private String introduction;        //简介

    private String project;     //科研项目

    private String paper;       //发表论文

    private Integer phdMajor;       //博士招生资格

    private Integer masterMajor;        //硕士招生资格

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", schoolCode=" + schoolCode +
                ", university='" + university + '\'' +
                ", universityCode=" + universityCode +
                ", icon='" + icon + '\'' +
                ", gender='" + gender + '\'' +
                ", title='" + title + '\'' +
                ", degree='" + degree + '\'' +
                ", property='" + property + '\'' +
                ", email='" + email + '\'' +
                ", experience='" + experience + '\'' +
                ", introduction='" + introduction + '\'' +
                ", project='" + project + '\'' +
                ", paper='" + paper + '\'' +
                ", phdMajor=" + phdMajor +
                ", masterMajor=" + masterMajor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Integer getPhdMajor() {
        return phdMajor;
    }

    public void setPhdMajor(Integer phdMajor) {
        this.phdMajor = phdMajor;
    }

    public Integer getMasterMajor() {
        return masterMajor;
    }

    public void setMasterMajor(Integer masterMajor) {
        this.masterMajor = masterMajor;
    }
}
