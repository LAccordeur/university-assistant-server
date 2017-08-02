package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.service.SearchService;
import com.uppfind.service.TeacherService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

/**
 * Created by LAccordeur on 2017/7/12.
 */
@Controller
@RequestMapping
public class SearchController extends BaseController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/all/list",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    Response<List<Response<Object>>> queryAll(String keyword) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_ALL"));
        logger.info("Request--" + keyword);

        return searchService.queryAllList(keyword);
    }

    @RequestMapping(value = "/heatSearch",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    Response<Set<String>> getHeatSearch() {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("HEAT_SEARCH"));
        logger.info("Request--");

        return searchService.getHeatSearch();
    }

}
