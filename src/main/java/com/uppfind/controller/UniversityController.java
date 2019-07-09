package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.University;
import com.uppfind.service.UniversityService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.ConstPunctuation;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LAccordeur on 2017/5/31.
 * 学校信息查询相关的controller
 */
@Controller
@RequestMapping(value = "/university", produces = {"application/json;charset=utf8"})
public class UniversityController extends BaseController {

    @Autowired
    private UniversityService universityService;



    @RequestMapping(value = "/location",
                    method = RequestMethod.GET)
    @ResponseBody
    public Response<List<University>> queryProvinceSet() {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PROVINCE_SET"));
        logger.info("Request--");

        return universityService.queryProvinceSet();
    }


    /**
     * 根据关键词查询学校列表
     * @param keyword
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list",
                    method = RequestMethod.GET)
    @ResponseBody
    public Response queryUniversityList(String keyword,
                                        @RequestParam(required = false) String currentPage,
                                        @RequestParam(required = false) String pageSize) {
        if (keyword != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_UNIVERSITY_LIST_PAGE"));
            logger.info("Request--" + keyword + "_" + currentPage + "_" + pageSize);

            //返回分页列表
            return universityService.queryUniversityPageList(keyword, currentPage, pageSize);
        } else if (keyword != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_UNIVERSITY_LIST"));
            logger.info("Request--" + keyword);

            //返回整个列表
            return universityService.queryUniversityList(keyword);
        }

        return null;
    }


    /**
     * 根据省份查询学校集合（id+名称）
     * @param locationName
     * @return
     */
    @RequestMapping(value = "/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryUniversitySet(String locationName) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_UNIVERSITY_SET"));
        logger.info("Request--" + locationName);

        return universityService.queryUniversitySet(locationName);
    }


    /**
     * 根据学校id查询学校详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryUniversityInfo(String id) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_UNIVERSITY_INFO"));
        logger.info("Request--" + id);

        return universityService.queryUniversityInfo(id);
    }


}
