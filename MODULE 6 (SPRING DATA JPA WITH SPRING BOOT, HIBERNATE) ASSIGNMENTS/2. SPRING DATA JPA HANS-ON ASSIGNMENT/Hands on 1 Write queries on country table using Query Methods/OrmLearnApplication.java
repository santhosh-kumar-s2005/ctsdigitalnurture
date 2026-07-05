package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryRepository countryRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        testSearchByContaining();
        testSearchByContainingOrdered();
        testSearchByStartingWith();
    }

    private static void testSearchByContaining() {
        LOGGER.info("Start - search containing 'ou'");
        List<Country> list = countryRepository.findByNameContaining("ou");
        list.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testSearchByContainingOrdered() {
        LOGGER.info("Start - search containing 'ou' ordered by name");
        List<Country> list = countryRepository.findByNameContainingOrderByName("ou");
        list.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }

    private static void testSearchByStartingWith() {
        LOGGER.info("Start - search starting with 'Z'");
        List<Country> list = countryRepository.findByNameStartingWith("Z");
        list.forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End");
    }
}
