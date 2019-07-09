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
     * 根据关键词查询所有相关老师信息（部分信息）
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
     * 分页
     * @param schoolCode
     * @param currentPage
     * @param pageSize
     * @return
     */
    Response queryTeacherPageListById(String schoolCode, String currentPage, String pageSize);

    /**
     * 查询某博士专业的指导老师
     * @param majorCode
     * @return
     */
    Response queryTeacherListByPhdMajorId(String majorCode);

    /**
     * 分页
     * @param majorCode
     * @param currentPage
     * @param pageSize
     * @return
     */
    Response queryTeacherPageListByPhdMajorId(String majorCode, String currentPage, String pageSize);

    /**
     * 查询某硕士专业的指导老师
     * @param majorCode
     * @return
     */
    Response queryTeacherListByMasterMajorId(String majorCode);

    /**
     * 分页
     * @param majorCode
     * @param currentPage
     * @param pageSize
     * @return
     */
    Response queryTeacherPageListByMasterMajorId(String majorCode, String currentPage, String pageSize);

    /**
     * 查询老师的详细信息
     * @param teacherCode
     * @return
     */
    Response queryTeacherInfo(String teacherCode, String token);

    /**
     * 根据关键词查询所有相关老师信息（分页）（部分信息）
     * @param keyword
     * @param pageSize
     * @param currentPage
     * @return
     */
    Response queryTeacherPageList( String keyword, String currentPage, String pageSize);

    /**
     * 根据邮箱查询教师信息
     */
    Response queryTeacherInfoByEmail(String email);

    /**
     * 更新信息领取状态
     * @param email
     * @return
     */
    Response updateFetchStatus(String email);

    Response listAllTeachers();

    Response listAllTeachersPage(String currentPage, String pageSize);

}
