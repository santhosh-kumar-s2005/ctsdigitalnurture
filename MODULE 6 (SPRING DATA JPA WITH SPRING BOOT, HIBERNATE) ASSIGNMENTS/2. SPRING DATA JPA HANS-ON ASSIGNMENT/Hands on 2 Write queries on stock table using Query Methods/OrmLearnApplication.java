package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static StockRepository stockRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);

        testFacebookSeptember2019();
        testGoogleCloseGreaterThan1250();
        testTop3HighestVolume();
        testTop3LowestNetflix();
    }

    private static void testFacebookSeptember2019() {
        LOGGER.info("Start - FB September 2019");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse("2019-09-01");
            Date end = sdf.parse("2019-09-30");
            List<Stock> list = stockRepository.findByCodeAndDateBetween("FB", start, end);
            list.forEach(s -> LOGGER.debug("{}", s));
        } catch (Exception e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    private static void testGoogleCloseGreaterThan1250() {
        LOGGER.info("Start - GOOGL close > 1250");
        List<Stock> list = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        list.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testTop3HighestVolume() {
        LOGGER.info("Start - Top 3 highest volume");
        List<Stock> list = stockRepository.findTop3ByOrderByVolumeDesc();
        list.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }

    private static void testTop3LowestNetflix() {
        LOGGER.info("Start - Top 3 lowest NFLX close");
        List<Stock> list = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        list.forEach(s -> LOGGER.debug("{}", s));
        LOGGER.info("End");
    }
}
