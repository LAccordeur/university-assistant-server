package com.uppfind.service.impl;

import com.uppfind.dao.UniversityMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.University;
import com.uppfind.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by LAccordeur on 2017/5/31.
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityMapper universityMapper;

    public Response queryProvinceSet() {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryProvinceSet();
        response.setResult(universities);
        response.setTotal(universities.size());

        return response;
    }

    public Response queryUniversityList(String keyword) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryUniversityList(keyword);
        response.setResult(universities);
        response.setTotal(universities.size());
        response.setStart(0);
        response.setCount(universities.size());

        return response;
    }

    public Response queryUniversitySet(String province) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> universities = universityMapper.queryUniversitySet(province);
        response.setResult(universities);
        response.setTotal(universities.size());

        return response;
    }

    public Response queryUniversityInfo(String universityCode) {

        Response<List<University>> response = new Response<List<University>>();
        //组装返回的Response对象
        List<University> university = universityMapper.queryUniversityInfo(Integer.parseInt(universityCode));
        response.setResult(university);
        response.setTotal(university.size());
        return response;
    }
}
