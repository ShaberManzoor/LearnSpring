package com.in28min.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigController {
	
	@Autowired
	private CurrencyConfigurationService configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyConfigurationService getAllCourses() {
        return configuration;
    }

}
