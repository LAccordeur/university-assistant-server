package com.uppfind.dao;

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
}
