package com.uppfind.service;

import com.uppfind.dto.Response;

/**
 * Created by LAccordeur on 2017/7/10.
 */
public interface ResearchFieldService {
    /**
     * 根据关键词查询相关专业方向信息
     * @param keyword
     * @return
     */
    Response queryMajorFieldList(String keyword);

    /**
     * 根据关键词查询相关专业方向信息（分页）
     * @param keyword
     * @param pageSize
     * @param currentPage
     * @return
     */
    Response queryMajorFieldPageList( String keyword, String currentPage, String pageSize);
}
