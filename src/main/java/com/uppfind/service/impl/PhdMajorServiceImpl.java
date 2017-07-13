package com.uppfind.service.impl;

import com.uppfind.dao.PhdMajorMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.PhdMajor;
import com.uppfind.service.PhdMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Service
public class PhdMajorServiceImpl implements PhdMajorService {

    @Autowired
    private PhdMajorMapper phdMajorMapper;

    public Response queryPhdMajorSet(String province, String university, String school) {

        Response<List<PhdMajor>> response = new Response<List<PhdMajor>>();
        //组装返回的Response对象
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorSet(province, university, school);
        response.setResult(phdMajors);
        response.setTotal(phdMajors.size());

        return response;
    }

    public Response queryPhdMajorList(String keyword) {

        Response<List<PhdMajor>> response = new Response<List<PhdMajor>>();
        //组装返回的Response对象
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorList(keyword);
        response.setResult(phdMajors);
        response.setTotal(phdMajors.size());
        response.setCount(phdMajors.size());
        response.setStart(0);

        return response;
    }

    public Response queryPhdMajorInfo(String schoolCode, String majorCode) {
        Response<List<PhdMajor>> response = new Response<List<PhdMajor>>();
        //组装返回的Response对象
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorInfo(Long.parseLong(schoolCode), Integer.parseInt(majorCode));
        response.setResult(phdMajors);
        response.setTotal(phdMajors.size());

        return response;
    }
}
