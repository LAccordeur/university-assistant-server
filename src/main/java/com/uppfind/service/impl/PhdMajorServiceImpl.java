package com.uppfind.service.impl;

import com.uppfind.dao.mybatis.PhdMajorMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.PhdMajor;
import com.uppfind.service.PhdMajorService;
import com.uppfind.util.page.Page;
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
        response.setData(phdMajors);
        response.setCount(phdMajors.size());
        response.setType("phdMajor");

        return response;
    }

    public Response queryPhdMajorList(String keyword) {

        Response<List<PhdMajor>> response = new Response<List<PhdMajor>>();
        //组装返回的Response对象
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorList(keyword);
        response.setData(phdMajors);
        response.setCount(phdMajors.size());
        response.setType("phdMajor");

        return response;
    }

    public Response queryPhdMajorInfo(String schoolCode, String majorCode) {
        Response<List<PhdMajor>> response = new Response<List<PhdMajor>>();
        //组装返回的Response对象
        List<PhdMajor> phdMajors = phdMajorMapper.queryPhdMajorInfo(Long.parseLong(schoolCode), Integer.parseInt(majorCode));
        response.setData(phdMajors);
        response.setCount(phdMajors.size());
        response.setType("phdMajor");

        return response;
    }

    public Response queryPhdMajorPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<PhdMajor>> response = new Response<Page<PhdMajor>>();

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


        Page<PhdMajor> pageData = null;
        List<PhdMajor> phdMajors = null;


        phdMajors = phdMajorMapper.queryPhdMajorPageList(keyword, offset, rows);
        int resultCount = phdMajorMapper.queryPhdMajorCount(keyword);
        if (phdMajors!= null && phdMajors.size() > 0) {
            pageData = new Page<PhdMajor>(pageSizeInt, currentPageInt, phdMajors.size(), phdMajors);
            response.setData(pageData);
            response.setCount(resultCount);
            response.setType("phdMajor");
        } else {
            response.setData(null);
            response.setCount(0);
            response.setType("phdMajor");
        }

        return response;
    }
}
