package com.uppfind.dao.mybatis;

import com.uppfind.entity.University;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by LAccordeur on 2017/5/31.
 */
public interface UniversityMapper {

    /**
     * 查询所有省份的集合（只有省份名字）
     * @return
     */
    List<University> queryProvinceSet();


    /**
     * 查询指定省份下学校的集合
     * @param province
     * @return
     */
    List<University> queryUniversitySet(@Param("province") String province);

    /**
     * 根据关键字查询所有学校列表（有部分详细信息）
     * @param keyword
     * @return
     */
    List<University> queryUniversityList(@Param("keyword") String keyword);

    /**
     * 根据关键字查询学校列表（分页）（有部分详细信息）
     * @param keyword
     * @param offset
     * @param rows
     * @return
     */
    List<University> queryUniversityPageList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("rows") int rows);



    /**
     * 查询指定学校的详细信息
     * @param universityCode
     * @return
     */
    List<University> queryUniversityInfo(@Param("universityCode") Integer universityCode);
}
