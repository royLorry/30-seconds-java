package com.learning.java.controller;

import com.learning.java.domain.Country;
import com.learning.java.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Country 控制层
 *
 * 
 */

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value="/api/country")
    public Country getMethodName(@RequestParam(value = "countryName", required = true) String countryName) {
        return countryService.findCountryByName(countryName);
    }


}