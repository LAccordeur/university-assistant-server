package com.uppfind.service.impl;

import com.uppfind.dao.SchoolMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.School;
import com.uppfind.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    public Response querySchoolSet(String province, String university) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> schools = schoolMapper.querySchoolSet(province, university);
        response.setData(schools);
        response.setTotal(schools.size());

        return response;
    }

    public Response querySchoolList(String keyword) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> schools = schoolMapper.querySchoolList(keyword);
        response.setData(schools);
        response.setTotal(schools.size());
        response.setCount(schools.size());
        response.setStart(0);

        return response;
    }

    public Response querySchoolInfo(String schoolCode) {

        Response<List<School>> response = new Response<List<School>>();
        //组装返回的Response对象
        List<School> school = schoolMapper.querySchoolInfo(Long.parseLong(schoolCode));
        response.setData(school);
        response.setTotal(school.size());

        return response;
    }
}
