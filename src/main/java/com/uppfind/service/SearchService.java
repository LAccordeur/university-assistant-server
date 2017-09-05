package com.uppfind.service;

import com.uppfind.dto.Response;

/**
 * Created by LAccordeur on 2017/7/12.
 */
public interface SearchService {
    Response queryAllList(String keyword);

    Response queryAllPageList(String keyword, String currentPage, String pageSize);

    Response queryAllListByThread(String keyword);

    Response getHeatSearch();
}
