package com.uppfind.dao.mybatis;

import com.uppfind.entity.MasterMajor;
import com.uppfind.entity.ResearchField;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/10.
 */
public interface ResearchFieldMapper {
    /**
     * 根据关键词查询所有相关的研究方向的老师，返回含有视图中部分信息的列表
     * @param keyword
     * @return
     */
    List<ResearchField> queryMajorFieldList(@Param("keyword") String keyword);

    /**
     * 根据关键词查询所有相关的研究方向的老师，返回含有视图中部分信息的列表（分页）
     * @param keyword
     * @param offset
     * @param rows
     * @return
     */
    List<ResearchField> queryMajorFieldPageList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 总记录数
     * @param keyword
     * @return
     */
    Integer queryMajorFieldCount(@Param("keyword") String keyword);
}
