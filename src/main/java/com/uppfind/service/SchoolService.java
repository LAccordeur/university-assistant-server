package com.uppfind.service;

import com.uppfind.dto.Response;

/**
 * Created by LAccordeur on 2017/6/2.
 */
public interface SchoolService {

    /**
     * 根据条件返回学院的集合（名称+id）
     * @param province
     * @param university
     * @return
     */
    Response querySchoolSet(String province, String university);

    /**
     * 根据关键词返回相关学院（含部分学院信息）列表
     * @param keyword
     * @return
     */
    Response querySchoolList(String keyword);

    /**
     * 查询学院详细信息
     * @param schoolCode
     * @return
     */
    Response querySchoolInfo(String schoolCode);
}
