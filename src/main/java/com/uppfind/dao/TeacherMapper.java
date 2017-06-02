package com.uppfind.dao;

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
     * 查询含有该关键词的所有老师，返回老师信息列表
     * @param keyword
     * @return
     */
    List<Teacher> queryTeacherList(@Param("keyword") String keyword);

    /**
     * 根据id查询老师的具体信息
     * @param teacherId
     * @return
     */
    Teacher queryTeacherInfo(@Param("teacherId") Long teacherId);
}
