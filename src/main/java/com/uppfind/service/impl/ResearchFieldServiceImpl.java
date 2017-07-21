package com.uppfind.service.impl;

import com.uppfind.dao.ResearchFieldMapper;
import com.uppfind.dto.Response;
import com.uppfind.entity.ResearchField;
import com.uppfind.service.ResearchFieldService;
import com.uppfind.util.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LAccordeur on 2017/7/10.
 */
@Service
public class ResearchFieldServiceImpl implements ResearchFieldService {

    @Autowired
    private ResearchFieldMapper researchFieldMapper;

    public Response queryMajorFieldList(String keyword) {

        Response<List<ResearchField>> response = new Response<List<ResearchField>>();
        //组装返回的Response对象
        List<ResearchField> researchFields = researchFieldMapper.queryMajorFieldList(keyword);
        response.setData(researchFields);
        response.setCount(researchFields.size());
        response.setType("researchField");

        return response;
    }

    public Response queryMajorFieldPageList(String keyword, String currentPage, String pageSize) {
        Response<Page<ResearchField>> response = new Response<Page<ResearchField>>();

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


        Page<ResearchField> pageData = null;
        List<ResearchField> researchFields = null;


        researchFields = researchFieldMapper.queryMajorFieldPageList(keyword, offset, rows);
        if (researchFields != null && researchFields.size() > 0) {
            pageData = new Page<ResearchField>(pageSizeInt, currentPageInt, researchFields.size(), researchFields);
            response.setData(pageData);
            response.setCount(researchFields.size());
            response.setType("researchField");
        }

        return response;
    }
}
