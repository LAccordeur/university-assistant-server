package com.uppfind.util.page;



import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: 分页对象. 包含当前页数据及分页信息如总记录数.
 * @author guoyang
 */
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Page<T> {


    public static final Integer DEFAULT_PAGE_SIZE = 10;

    private Integer pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数

    private Integer currentPage = 1; //当前页码，从1开始记数

    private List<T> data = new ArrayList<T>(); // 当前页中存放的记录,类型一般为List

    private Integer resultCount = 0; // 总记录数



    public Page(Integer pageSize, Integer currentPage, List<T> data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.data = data;
    }


    public Page() {
    }

    /**
     * 获得第一条记录的截取位置
     * @return 第一条记录的截取位置
     */
    public Integer getStart() {
        if (currentPage - 1 >= 0) {
            return (currentPage - 1) * pageSize;
        }
        return 0;
    }

    /**
     * 获得第一条记录的截取位置
     * @return 第一条记录的截取位置
     */
    public static Integer getStart(Integer currentPage, Integer pageSize) {
        if (currentPage - 1 >= 0) {
            return (currentPage - 1) * pageSize;
        }
        return 0;
    }


    /**
     * 取总记录数.
     * @return 符合查询条件的记录总数
     */
    public Integer getResultCount() {
        return this.resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    /**
     * 取总页数.
     * @return 符合查询条件的记录总页数
     */
    public Integer getPageCount() {
            return (resultCount - 1) / pageSize + 1;
    }

    /**
     * 取每页数据容量.
     * @return 每页可容纳的记录数量
     */
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
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
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
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



    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", data=" + data +
                ", resultCount=" + resultCount +
                '}';
    }
}