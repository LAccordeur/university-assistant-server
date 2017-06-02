package com.uppfind.service;

import com.uppfind.dto.Response;

/**
 * Created by LAccordeur on 2017/6/2.
 */
public interface MasterMajorService {

    /**
     * 查询某学院下所有硕士专业的集合（名称+id）
     * @param province
     * @param university
     * @param school
     * @return
     */
    Response queryMasterMajorSet(String province, String university, String school);

    /**
     * 根据关键词查询相关硕士专业信息（部分信息）
     * @param keyword
     * @return
     */
    Response queryMasterMajorList(String keyword);

    /**
     * 根据关键词查询相关专业方向信息
     * @param keyword
     * @return
     */
    Response queryMajorFieldList(String keyword);

    /**
     * 查询专业详细信息
     * @param schoolCode
     * @param majorCode
     * @return
     */
    Response queryMasterMajorInfo(String schoolCode, String majorCode);
}
