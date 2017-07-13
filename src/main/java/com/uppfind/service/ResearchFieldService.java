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

}
