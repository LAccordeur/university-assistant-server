package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.MasterMajorMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.MasterMajor;
import com.uppfind.service.MasterMajorService;
import com.uppfind.util.page.Page;
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
        response.setData(masterMajors);
        response.setCount(masterMajors.size());
        response.setType("masterMajor");

        return response;
    }

    public Response queryMasterMajorList(String keyword) {
        Response<List<MasterMajor>> response = new Response<List<MasterMajor>>();
        //组装返回的Response对象
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorList(keyword);
        response.setData(masterMajors);
        response.setCount(masterMajors.size());
        response.setType("masterMajor");

        return response;
    }


    public Response queryMasterMajorInfo(String schoolCode, String majorCode) {
        Response<List<MasterMajor>> response = new Response<List<MasterMajor>>();
        //组装返回的Response对象
        List<MasterMajor> masterMajors = masterMajorMapper.queryMasterMajorInfo(Long.parseLong(schoolCode), Integer.parseInt(majorCode));
        response.setData(masterMajors);
        response.setCount(masterMajors.size());
        response.setType("masterMajor");

        return response;
    }

    public Response queryMasterMajorPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<MasterMajor>> response = new Response<Page<MasterMajor>>();

        int currentPageInt = Integer.valueOf(currentPage);
        int pageSizeInt = Integer.valueOf(pageSize);

        //当前页的下限检验
        if (currentPageInt < 1) {
            currentPageInt = 1;
        }
        if (pageSizeInt < 1) {
            pageSizeInt = 10;
        }

        //计算分页信息
        int offset = Page.getStart(currentPageInt, pageSizeInt);
        int rows = pageSizeInt;


        Page<MasterMajor> pageData = null;
        List<MasterMajor> masterMajors= null;


        masterMajors = masterMajorMapper.queryMasterMajorPageList(keyword, offset, rows);
        int resultCount = masterMajorMapper.queryMasterMajorCount(keyword);
        if (masterMajors!= null && masterMajors.size() > 0) {
            pageData = new Page<MasterMajor>(pageSizeInt, currentPageInt, masterMajors.size(), masterMajors);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("masterMajor");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("masterMajor");
        }

        return response;
    }
}
