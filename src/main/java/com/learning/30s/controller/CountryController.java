package com.learning.30s.controller;

import com.learning.30s.domain.Country;
import com.learning.30s.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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