package com.learning.java.service.impl;

import com.learning.java.dao.CountryDao;
import com.learning.java.domain.Country;
import com.learning.java.service.CountryService;
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