package com.lenovo.wpc.service.impl;

import com.lenovo.wpc.dao.CountryDao;
import com.lenovo.wpc.domain.Country;
import com.lenovo.wpc.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 国家业务逻辑实现类
 *
 *
 */

@Service
public class CountryServiceImpl implements CountryService {
    
    @Autowired
    private CountryDao countryDao;

    public Country findCountryByName(String countryName) {
        return countryDao.findByName(countryName);
    }

}