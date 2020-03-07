package com.learning.30s.service.impl;

import com.learning.30s.dao.CountryDao;
import com.learning.30s.domain.Country;
import com.learning.30s.service.CountryService;

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