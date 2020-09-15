package com.learning.java.service;

import com.learning.java.domain.Country;


/**
 * 国家业务逻辑接口类
 *
 *
 */

public interface CountryService {

    /**
     * 根据国家名称，查询国家信息
     * @param countryName
     */
    Country findCountryByName(String countryName);
}