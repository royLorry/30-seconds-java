package com.learning.30s.dao;

import com.learning.30s.domain.Country;

import org.apache.ibatis.annotations.*;



/**
 * 国家 DAO 接口类
 *
 *
 */
@Mapper // 标志为 Mybatis 的 Mapper
public interface CountryDao {

    /**
     * 根据国家名称，查询国家信息
     *
     * @param countryName 国家名
     */
    @Select("SELECT * FROM domain.country where name = #{countryName}")
    // 返回 Map 结果集
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
    })
    Country findByName(@Param("countryName") String countryName);
}