package com.uppfind.service;

import com.uppfind.dto.Response;

/**
 * Created by LAccordeur on 2017/6/2.
 */
public interface TeacherService {

    /**
     * 查询相关条件下老师的集合（姓名+id）
     * @param province
     * @param university
     * @param school
     * @return
     */
    Response queryTeacherSet(String province, String university, String school);

    /**
     * 根据关键词查询老师信息（部分信息）
     * @param keyword
     * @return
     */
    Response queryTeacherList(String keyword);

    /**
     * 根据学院id查询老师信息（部分信息）
     * @param schoolCode
     * @return
     */
    Response queryTeacherListById(String schoolCode);

    /**
     * 查询老师的详细信息
     * @param teacherCode
     * @return
     */
    Response queryTeacherInfo(String teacherCode);
}
