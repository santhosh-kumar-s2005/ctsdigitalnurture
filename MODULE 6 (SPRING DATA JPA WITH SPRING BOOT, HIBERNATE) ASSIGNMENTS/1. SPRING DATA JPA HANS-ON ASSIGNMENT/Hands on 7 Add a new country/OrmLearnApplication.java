package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testAddCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country();
        newCountry.setCode("ZZ");
        newCountry.setName("Test Country");
        countryService.addCountry(newCountry);
        LOGGER.debug("Country added: {}", newCountry);
        try {
            Country found = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Verified in DB: {}", found);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
