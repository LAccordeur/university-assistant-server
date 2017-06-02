package com.uppfind.dao;

import com.uppfind.entity.PhdMajor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/1.
 */
public interface PhdMajorMapper {

    /**
     * 查询某一学院下所有博士专业，返回所有博士专业（名称，编号）的集合
     * @param province
     * @param university
     * @param school
     * @return
     */
    List<PhdMajor> queryPhdMajorSet(@Param("province") String province, @Param("university") String university, @Param("school") String school);

    /**
     * 根据关键词查询所有相关的博士专业
     * @param keyword
     * @return
     */
    List<PhdMajor> queryPhdMajorList(@Param("keyword") String keyword);

    /**
     * 查询某专业的具体信息
     * @param majorCode
     * @return
     */
    PhdMajor queryPhdMajorInfo(@Param("schoolCode") Long schoolCode, @Param("majorCode") Integer majorCode);
}
