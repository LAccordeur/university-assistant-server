package com.uppfind.dao.mybatis;

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
     * 根据关键词查询所有相关学院的信息(分页)
     * @param keyword
     * @param offset
     * @param rows
     * @return
     */
    List<School> querySchoolPageList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("rows") int rows);


    /**
     * 根据大学id查询相关学院信息
     * @param universityCode
     * @return
     */
    List<School> querySchoolListById(@Param("universityCode") String universityCode);

    /**
     * 根据学院编号查询学院的具体信息
     * @param schoolCode
     * @return
     */
    List<School> querySchoolInfo(@Param("schoolCode") Long schoolCode);

    /**
     * 总记录数
     * @param keyword
     * @return
     */
    Integer querySchoolCount(@Param("keyword") String keyword);

}
