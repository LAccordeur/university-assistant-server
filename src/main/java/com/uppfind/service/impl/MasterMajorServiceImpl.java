package com.uppfind.service.impl;

import com.uppfind.dao.MasterMajorMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.MasterMajor;
import com.uppfind.service.MasterMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/6/2.
 */
@Service
public class MasterMajorServiceImpl implements MasterMajorService {

    @Autowired
    private MasterMajorMapper masterMajorMapper;

    public Response queryMasterMajorSet(String province, String university, String school) {

        Response<List<MasterMajor>> response = new Response<List<MasterMajor>>();
        //组装返回的Response对象
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorSet(province, university, school);
        response.setResult(masterMajors);
        response.setTotal(masterMajors.size());

        return response;
    }

    public Response queryMasterMajorList(String keyword) {
        Response<List<MasterMajor>> response = new Response<List<MasterMajor>>();
        //组装返回的Response对象
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorList(keyword);
        response.setResult(masterMajors);
        response.setTotal(masterMajors.size());
        response.setCount(masterMajors.size());
        response.setStart(0);

        return response;
    }


    public Response queryMasterMajorInfo(String schoolCode, String majorCode) {
        Response<List<MasterMajor>> response = new Response<List<MasterMajor>>();
        //组装返回的Response对象
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorInfo(Long.parseLong(schoolCode), Integer.parseInt(majorCode));
        response.setResult(masterMajors);
        response.setTotal(masterMajors.size());

        return response;
    }
}
