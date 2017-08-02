package com.uppfind.dao.mybatis;

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
     * 根据关键词查询相关的所有专业，返回含有视图中部分专业信息的列表(分页)
     * @param keyword
     * @param offset
     * @param rows
     * @return
     */
    List<MasterMajor> queryMasterMajorPageList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("rows") int rows);


    /**
     * 查询具体硕士专业的详细信息
     * @param schoolCode
     * @param majorCode
     * @return
     */
    List<MasterMajor> queryMasterMajorInfo(@Param("schoolCode") Long schoolCode, @Param("majorCode") Integer majorCode);
}
