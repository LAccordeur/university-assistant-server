package com.uppfind.dao;

import com.uppfind.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 *
 */
public interface SchoolMapper {

    /**
     * 根据省份和学校查询该学校下的所有学院的集合
     * @param province
     * @param university
     * @return
     */
    List<School> querySchoolSet(@Param("province") String province, @Param("university") String university);

    /**
     * 根据关键词查询所有相关学院的信息
     * @param keyword
     * @return
     */
    List<School> querySchoolList(@Param("keyword") String keyword);

    /**
     * 根据学院编号查询学院的具体信息
     * @param schoolCode
     * @return
     */
    School querySchoolInfo(@Param("schoolCode") Long schoolCode);



}
