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
     * 根据省份查询该省分下所有大学,返回（名称+id）
     * @param province
     * @return
     */
    Response queryUniversitySet(String province);

    /**
     * 根据关键词查询相应学校的列表，返回学校的部分信息
     * @param keyword
     * @return
     */
    Response queryUniversityList(String keyword);

    /**
     * 根据关键词查询相应学校的列表，返回学校的部分信息(分页)
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     */
    Response queryUniversityPageList(String keyword, String currentPage, String pageSize);


    /**
     * 返回某大学的具体信息
     * @param universityCode
     * @return
     */
    Response queryUniversityInfo(String universityCode);


}
