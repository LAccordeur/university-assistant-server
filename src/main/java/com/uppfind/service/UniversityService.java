package com.uppfind.service;

import com.uppfind.dto.Response;

import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 */
public interface UniversityService {

    /**
     * 获取省份的集合
     * @return
     */
    Response queryProvinceSet();

    /**
     * 根据关键词查询相应学校的列表
     * @param keyword
     * @return
     */
    Response queryUniversityList(String keyword);
}
