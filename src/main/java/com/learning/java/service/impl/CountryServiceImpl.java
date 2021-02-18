package com.learning.java.service.impl;

import com.learning.java.aop.annotation.Compare;
import com.learning.java.domain.Country;
import com.learning.java.service.CountryService;
import org.springframework.stereotype.Service;

/**
 * 国家业务逻辑实现类
 *
 *
 */

@Service
public class CountryServiceImpl implements CountryService {
    
    // @Autowired
    // private CountryDao countryDao;
    @Compare(type = "Y")
    public Country findCountryByName(String countryName) {
        return new Country(1L, countryName);
    }

}