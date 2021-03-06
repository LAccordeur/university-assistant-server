package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.TeacherService;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 * 老师信息查询的相关controller
 */
@Controller
@RequestMapping(value = "/teacher", produces = {"application/json;charset=utf8"})
public class TeacherController extends BaseController {

    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Response listAllTeachers() {
        return teacherService.listAllTeachers();
    }

    @ResponseBody
    @RequestMapping(value = "/all/page", method = RequestMethod.GET)
    public Response listAllTeachersPage(String currentPage, String pageSize) {
        return teacherService.listAllTeachersPage(currentPage, pageSize);
    }

    @RequestMapping(value = "/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherSet(String locationName, String universityName, String schoolName) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_SET"));
        logger.info("Request--" + locationName + "_" + universityName + "_" + schoolName);

        return teacherService.queryTeacherSet(locationName, universityName, schoolName);
    }

    @RequestMapping(value = "/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherList(@RequestParam(required = false) String keyword,
                                    @RequestParam(required = false) String currentPage,
                                    @RequestParam(required = false) String pageSize,
                                    @RequestParam(required = false) String id,
                                     @RequestParam(required = false) String type) {

        if (keyword != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_LIST_PAGE"));
            logger.info("Request--" + keyword + "_" + currentPage + "_" + pageSize);

            return teacherService.queryTeacherPageList(keyword, currentPage, pageSize);
        } else if (keyword != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_LIST"));
            logger.info("Request--" + keyword);

            return teacherService.queryTeacherList(keyword);
        } else if (id != null && type != null && currentPage != null && pageSize != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_LIST"));
            logger.info("Request--" + id);

            if ("2".equals(type)) {
                return teacherService.queryTeacherPageListById(id, currentPage, pageSize);
            } else if ("3".equals(type)) {
                return teacherService.queryTeacherPageListByPhdMajorId(id, currentPage, pageSize);
            } else if ("4".equals(type)) {
                return teacherService.queryTeacherPageListByMasterMajorId(id, currentPage, pageSize);
            }
        } else if (id != null && type != null) {
            //日志跟踪
            MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_LIST"));
            logger.info("Request--" + id);

            if ("2".equals(type)) {
                return teacherService.queryTeacherListById(id);
            } else if ("3".equals(type)) {
                return teacherService.queryTeacherListByPhdMajorId(id);
            } else if ("4".equals(type)) {
                return teacherService.queryTeacherListByMasterMajorId(id);
            }
        } else if (id != null) {
            return teacherService.queryTeacherListById(id);
        }

        return null;
    }

    @RequestMapping(value = "/info",
            method = RequestMethod.GET)
    @ResponseBody
    public Response queryTeacherInfo(String id, String userId) {
        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("QUERY_TEACHER_INFO"));
        logger.info("Request--" + id);

        return teacherService.queryTeacherInfo(id, userId);
    }


    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    @ResponseBody
    public Response fetchTeacherInfo(String email, String type) {
        if ("1".equals(type)) {
            return teacherService.queryTeacherInfoByEmail(email);
        } else {
            return new Response(HttpStatus.BAD_REQUEST.value(), "参数无效");
        }
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public Response updateFetchStatus(String email, String type) {
        if ("1".equals(type)) {
            return teacherService.updateFetchStatus(email);
        } else {
            return new Response(HttpStatus.BAD_REQUEST.value(), "参数无效");
        }
    }

}
