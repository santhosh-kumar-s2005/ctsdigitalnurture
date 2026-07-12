package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("START");
        SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication app = new SpringLearnApplication();
        app.demonstrateSingleton();
        app.demonstratePrototype();
        LOGGER.info("END");
    }

    public void demonstrateSingleton() {
        LOGGER.info("START - Singleton Scope");
        ApplicationContext context = new ClassPathXmlApplicationContext("country-singleton.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Same instance? {}", (country == anotherCountry));
        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Another Country : {}", anotherCountry);
        LOGGER.info("END - Singleton Scope");
    }

    public void demonstratePrototype() {
        LOGGER.info("START - Prototype Scope");
        ApplicationContext context = new ClassPathXmlApplicationContext("country-prototype.xml");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        LOGGER.debug("Same instance? {}", (country == anotherCountry));
        LOGGER.debug("Country : {}", country);
        LOGGER.debug("Another Country : {}", anotherCountry);
        LOGGER.info("END - Prototype Scope");
    }
}
