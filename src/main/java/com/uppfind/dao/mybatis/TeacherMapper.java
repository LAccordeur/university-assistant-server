package com.uppfind.dao.mybatis;

import com.uppfind.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 */
public interface TeacherMapper {


    /**
     * 查询某省份某大学某学院下所有老师，返回老师简要信息的集合
     * @param province
     * @param university
     * @param school
     * @return
     */
    List<Teacher> queryTeacherSet(@Param("province") String province, @Param("university") String university, @Param("school") String school);

    /**
     * 查询含有该关键词的所有老师，返回所有老师信息列表
     * @param keyword
     * @return
     */
    List<Teacher> queryTeacherList(@Param("keyword") String keyword);

    /**
     * 查询某学院下所有老师，返回老师信息列表
     * @param schoolCode
     * @return
     */
    List<Teacher> queryTeacherListById(@Param("schoolCode") String schoolCode);


    /**
     * 查询某学院下所有老师，返回老师信息列表(分页)
     * @param schoolCode
     */
    List<Teacher> queryTeacherPageListById(@Param("schoolCode") String schoolCode, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 根据学院id查询总记录数
     * @param schoolCode
     * @return
     */
    Integer queryTeacherCountById(@Param("schoolCode") String schoolCode);


    /**
     * 查询某博士专业的指导老师
     * @param majorCode
     * @return
     */
    List<Teacher> queryTeacherListByPhdMajorId(@Param("majorCode") String majorCode);

    /**
     * 上者的分页
     * @param majorCode
     * @param offset
     * @param rows
     * @return
     */
    List<Teacher> queryTeacherPageListByPhdMajorId(@Param("majorCode") String majorCode, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 根据博士专业id查询总记录数
     * @param majorCode
     * @return
     */
    Integer queryTeacherCountByPhdMajorId(@Param("majorCode") String majorCode);


    /**
     * 查询某硕士专业的指导老师
     * @param majorCode
     * @return
     */
    List<Teacher> queryTeacherListByMasterMajorId(@Param("majorCode") String majorCode);

    /**
     * 分页
     * @param majorCode
     * @param offset
     * @param rows
     * @return
     */
    List<Teacher> queryTeacherPageListByMasterMajorId(@Param("majorCode") String majorCode,@Param("offset") int offset, @Param("rows") int rows);

    /**
     * 根据硕士专业id查询总记录数
     * @param majorCode
     * @return
     */
    Integer queryTeacherCountByMasterMajorId(@Param("majorCode") String majorCode);

    /**
     * 查询含有该关键词的所有老师，返回部分老师信息列表用于分页
     * @param keyword
     * @param offset
     * @param rows
     * @return
     */
    List<Teacher> queryTeacherPageList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("rows") int rows);



    /**
     * 根据id查询老师的具体信息
     * @param teacherId
     * @return
     */
    List<Teacher> queryTeacherInfo(@Param("teacherId") Long teacherId);


    /**
     * 根据关键词查询总记录数
     * @param keyword
     * @return
     */
    Integer queryTeacherCount(@Param("keyword") String keyword);



}
