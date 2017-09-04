package com.uppfind.controller;

import com.uppfind.controller.base.BaseController;
import com.uppfind.dto.Response;
import com.uppfind.util.log.ConstCommonString;
import com.uppfind.util.log.LogUtil;
import com.uppfind.util.user.UserUtil;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LAccordeur on 2017/8/30.
 *
 */
@Controller
@RequestMapping(value = "/user", produces = {"application/json;charset=utf8"})
public class UserController extends BaseController {

    @RequestMapping(value = "/id",
            method = RequestMethod.GET)
    @ResponseBody
    public Response getUserToken() {

        //日志跟踪
        MDC.put(ConstCommonString.TRACE_ID, LogUtil.getTraceId("USER_TOKEN"));
        logger.info("Request--");

        return UserUtil.getUserToken();
    }
}
