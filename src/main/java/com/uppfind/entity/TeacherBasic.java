package com.uppfind.entity;

/**
 * @Author : guoyang
 * @Description :
 * @Date : Created on 2018/3/21
 */
public class TeacherBasic {
    private String realName;

    private String photo;

    private String sex;

    private String birth;

    private String title;

    private String certificate;

    private String property;

    private String email;

    private String academicExperience;

    private String introduction;

    private String scienceIntroduction;

    private String publishPaper;

    private String phdMajor;

    private String masterMajor;

    private String school;

    private String schoolEnglishName;

    private String college;

    private String collegeEnglishName;

    @Override
    public String toString() {
        return "TeacherBasic{" +
                "realName='" + realName + '\'' +
                ", photo='" + photo + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", title='" + title + '\'' +
                ", certificate='" + certificate + '\'' +
                ", property='" + property + '\'' +
                ", email='" + email + '\'' +
                ", academicExperience='" + academicExperience + '\'' +
                ", introduction='" + introduction + '\'' +
                ", scienceIntroduction='" + scienceIntroduction + '\'' +
                ", publishPaper='" + publishPaper + '\'' +
                ", phdMajor='" + phdMajor + '\'' +
                ", masterMajor='" + masterMajor + '\'' +
                ", school='" + school + '\'' +
                ", schoolEnglishName='" + schoolEnglishName + '\'' +
                ", college='" + college + '\'' +
                ", collegeEnglishName='" + collegeEnglishName + '\'' +
                '}';
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
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

    public String getAcademicExperience() {
        return academicExperience;
    }

    public void setAcademicExperience(String academicExperience) {
        this.academicExperience = academicExperience;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getScienceIntroduction() {
        return scienceIntroduction;
    }

    public void setScienceIntroduction(String scienceIntroduction) {
        this.scienceIntroduction = scienceIntroduction;
    }

    public String getPublishPaper() {
        return publishPaper;
    }

    public void setPublishPaper(String publishPaper) {
        this.publishPaper = publishPaper;
    }

    public String getPhdMajor() {
        return phdMajor;
    }

    public void setPhdMajor(String phdMajor) {
        this.phdMajor = phdMajor;
    }

    public String getMasterMajor() {
        return masterMajor;
    }

    public void setMasterMajor(String masterMajor) {
        this.masterMajor = masterMajor;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolEnglishName() {
        return schoolEnglishName;
    }

    public void setSchoolEnglishName(String schoolEnglishName) {
        this.schoolEnglishName = schoolEnglishName;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollegeEnglishName() {
        return collegeEnglishName;
    }

    public void setCollegeEnglishName(String collegeEnglishName) {
        this.collegeEnglishName = collegeEnglishName;
    }
}
