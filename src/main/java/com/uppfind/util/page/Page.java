package com.uppfind.util.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 分页对象. 包含当前页数据及分页信息如总记录数.
 * @author guoyang
 */
public class Page<T> implements Serializable {


    public static final int DEFAULT_PAGE_SIZE = 10;
    private static final long serialVersionUID = 5859907455479273251L;

    private int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数

    /**
     * 当前页码，从1开始记数
     */
    private long currentPage = 1;

    private long start = 0; // 当前页第一条数据在List中的位置,从0开始

    private List<T> data = new ArrayList<T>(); // 当前页中存放的记录,类型一般为List

    private long resultCount; // 总记录数

    public Page(int pageSize, long start, long currentPage) {
        this.pageSize = pageSize;
        this.start = start;
        this.currentPage = currentPage;
    }

    public Page(int pageSize, long currentPage, List<T> data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.data = data;
    }

    /**
     * 默认构造方法.
     * @param start     本页数据在数据库中的起始位置
     * @param totalSize 数据库中总记录条数
     * @param data      本页包含的数据
     */
    public Page(long start, long totalSize, List<T> data) {
        this.start = start;
        this.resultCount = totalSize;
        this.data = data;
        if (this.data == null) {
            this.data = new ArrayList<T>();
        }
    }

    /**
     * 默认构造方法.
     * @param start     本页数据在数据库中的起始位置
     * @param totalSize 数据库中总记录条数
     * @param pageSize  本页容量
     * @param data      本页包含的数据
     */
    public Page(long start, long totalSize, int pageSize, List<T> data) {
        this(start, totalSize, data);
        this.pageSize = pageSize;
    }

    public Page() {
    }

    /**
     * 获得第一条记录的截取位置
     * @return 第一条记录的截取位置
     */
    public long getStart() {
        if (currentPage - 1 >= 0) {
            return (currentPage - 1) * pageSize;
        }
        return 0;
    }

    public void setStart(long start) {
        this.start = start;
    }

    /**
     * 取总记录数.
     * @return 符合查询条件的记录总数
     */
    public long getResultCount() {
        return this.resultCount;
    }

    public void setResultCount(long resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * 取总页数.
     * @return 符合查询条件的记录总页数
     */
    public long getPageCount() {
            return (resultCount - 1) / pageSize + 1;
    }

    /**
     * 取每页数据容量.
     * @return 每页可容纳的记录数量
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 取当前页中的记录.
     * @return 当前数据页
     */
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 取该页当前页码，1为第一页，通过计算得到start / pageSize
     * @return 当前页的页码
     */
    public long getCurrentPage() {
        return (start / pageSize) + 1;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 直接获取当前页
     * @return
     */
    public long currentPageDirectly() {
        return currentPage;
    }

    /**
     * 该页是否有下一页.
     * @return 如果当前页是最后一页，返回false，否则返回true
     */
    public boolean hasNextPage() {
        return this.getCurrentPage() < this.getPageCount() - 1;
    }

    /**
     * 该页是否有上一页.
     * @return 如果当前页码为0，返回true，否则返回false
     */
    public boolean hasPreviousPage() {
        return this.getCurrentPage() > 0;
    }

    /**
     * @param pageSize
     * @param start
     * @param currentPage
     */
    public void setPage(int pageSize, long start, long currentPage) {
        this.pageSize = pageSize;
        this.start = start;
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}