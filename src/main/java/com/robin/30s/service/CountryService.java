package com.lenovo.wpc.service;

import com.lenovo.wpc.domain.Country;

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