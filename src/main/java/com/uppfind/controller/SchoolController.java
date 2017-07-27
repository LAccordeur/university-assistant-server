package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.SchoolService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 学院信息查询相关的controller
 */
@Controller
@RequestMapping(value = "/school", produces = {"application/json;charset=utf8"})
public class SchoolController extends BaseController {

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(value = "/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response querySchoolSet(String locationName, String universityName) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_SCHOOL_SET"));
        logger.info("Request--" + locationName + "_" + universityName);

        return schoolService.querySchoolSet(locationName, universityName);
    }


    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response querySchoolList(@RequestParam(required = false) String keyword,
                                    @RequestParam(required = false) String currentPage,
                                    @RequestParam(required = false) String pageSize,
                                    @RequestParam(required = false) String id) {

        if (keyword != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_SCHOOL_LIST_PAGE"));
            logger.info("Request--" + keyword + "_" + currentPage + "_" + pageSize);

            return schoolService.querySchoolPageList(keyword, currentPage, pageSize);
        } else if (keyword != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_SCHOOL_LIST"));
            logger.info("Request--" + keyword);

            return schoolService.querySchoolList(keyword);
        } else if (id != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_SCHOOL_LIST"));
            logger.info("Request--" + id);

            return schoolService.querySchoolListById(id);
        }
        return null;
    }



    @RequestMapping(value = "/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response querySchoolInfo(String id) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_SCHOOL_INFO"));
        logger.info("Request--" + id);

        return schoolService.querySchoolInfo(id);
    }
}
