package com.uppfind.controller;

import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.MasterMajorService;
import com.uppfind.service.PhdMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Controller
@RequestMapping
public class MajorController {

    @Autowired
    private PhdMajorService phdMajorService;

    @Autowired
    private MasterMajorService masterMajorService;


    @RequestMapping(value = "/queryMajor.do",
            method = RequestMethod.GET,
            produces = {"application/json;charset=utf8"})
    @ResponseBody
    public Response<List<School>> queryTeacher(String mode,
                                               String coin,
                                               @RequestParam(required = false) String l,
                                               @RequestParam(required = false) String u,
                                               @RequestParam(required = false) String s,
                                               @RequestParam(required = false) String sc,
                                               @RequestParam(required = false) String p,
                                               @RequestParam(required = false) String pc,
                                               @RequestParam(required = false) String m,
                                               @RequestParam(required = false) String mc,
                                               @RequestParam(required = false) String f) {

        if ("1".equals(coin)) {

            if ("1".equals(mode) && l != null && u != null && s != null) {
                return masterMajorService.queryMasterMajorSet(l, u, s);
            } else if ("2".equals(mode) && m != null) {
                return masterMajorService.queryMasterMajorList(m);
            } else if ("2".equals(mode) && f != null) {
                return masterMajorService.queryMajorFieldList(f);
            } else if ("3".equals(mode) && sc != null && mc != null) {
                return masterMajorService.queryMasterMajorInfo(sc, mc);
            }

        } else if ("2".equals(coin)) {

            if ("1".equals(mode) && l != null && u != null && s != null) {
                return phdMajorService.queryPhdMajorSet(l, u, s);
            } else if ("2".equals(mode) && p != null) {
                return phdMajorService.queryPhdMajorList(p);
            } else if ("3".equals(mode) && sc != null && pc != null) {
                return masterMajorService.queryMasterMajorInfo(sc, pc);
            }
        }


        return null;
    }


}
