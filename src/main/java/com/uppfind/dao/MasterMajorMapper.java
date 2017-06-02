package com.uppfind.dao;

import com.uppfind.entity.MasterMajor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/1.
 */
public interface MasterMajorMapper {

    /**
     * 查询某一学院所有硕士招生专业，返回专业（名称,id）的集合
     * @param province
     * @param university
     * @param school
     * @return
     */
    List<MasterMajor> queryMasterMajorSet(@Param("province") String province, @Param("university") String university, @Param("school") String school);

    /**
     * 根据关键词查询相关的所有专业，返回含有视图中部分专业信息的列表
     * @param keyword
     * @return
     */
    List<MasterMajor> queryMasterMajorList(@Param("keyword") String keyword);

    /**
     * 根据关键词查询所有相关的研究方向的老师，返回含有视图中部分信息的列表
     * @param keyword
     * @return
     */
    List<MasterMajor> queryMajorFieldList(@Param("keyword") String keyword);

    /**
     * 查询具体硕士专业的详细信息
     * @param majorCode
     * @return
     */
    MasterMajor queryMajorMajorInfo(@Param("schoolCode") Long schoolCode, @Param("majorCode") Integer majorCode);
}
