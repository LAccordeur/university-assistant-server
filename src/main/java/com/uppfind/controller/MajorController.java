package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.MasterMajorService;
import com.uppfind.service.PhdMajorService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 专业信息查询相关的controller
 */
@Controller
@RequestMapping(value = "/major", produces = {"application/json;charset=utf8"})
public class MajorController extends BaseController {

    @Autowired
    private PhdMajorService phdMajorService;

    @Autowired
    private MasterMajorService masterMajorService;


    @RequestMapping(value = "/phd/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorSet(String locationName, String universityName, String schoolName) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_SET"));
        logger.info("Request--" + locationName + "_" + universityName + "_" + schoolName);

        return phdMajorService.queryPhdMajorSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/phd/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorList(String keyword,
                                      @RequestParam(required = false) String currentPage,
                                      @RequestParam(required = false) String pageSize) {
        if (keyword != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_LIST_PAGE"));
            logger.info("Request--" + keyword + "_" + currentPage + "_" + pageSize);

            return phdMajorService.queryPhdMajorPageList(keyword, currentPage, pageSize);
        } else {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_LIST"));
            logger.info("Request--" + keyword);

            return phdMajorService.queryPhdMajorList(keyword);
        }
    }

    @RequestMapping(value = "/phd/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryPhdMajorInfo(String schoolId, String majorId) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_INFO"));
        logger.info("Request--" + schoolId + "_" + majorId);

        return phdMajorService.queryPhdMajorInfo(schoolId, majorId);
    }

    @RequestMapping(value = "/master/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorSet(String locationName, String universityName, String schoolName) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_MASTER_MAJOR_SET"));
        logger.info("Request--" + locationName + "_" + universityName + "_" + schoolName);

        return masterMajorService.queryMasterMajorSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/master/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorList(String keyword,
                                      @RequestParam(required = false) String currentPage,
                                      @RequestParam(required = false) String pageSize) {
        if (keyword != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_MASTER_MAJOR_LIST_PAGE"));
            logger.info("Request--" + keyword + "_" + currentPage + "_" + pageSize);

            return masterMajorService.queryMasterMajorPageList(keyword, currentPage, pageSize);
        } else {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_LIST"));
            logger.info("Request--" + keyword);

            return masterMajorService.queryMasterMajorList(keyword);
        }
    }

    @RequestMapping(value = "/master/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryMasterMajorInfo(String schoolId, String majorId) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_PHD_MAJOR_INFO"));
        logger.info("Request--");

        return masterMajorService.queryMasterMajorInfo(schoolId, majorId);
    }


}
