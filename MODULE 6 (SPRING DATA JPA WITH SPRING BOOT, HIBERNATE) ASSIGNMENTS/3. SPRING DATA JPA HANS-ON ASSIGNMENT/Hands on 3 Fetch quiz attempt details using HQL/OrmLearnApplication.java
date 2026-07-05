package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Options;
import com.cognizant.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);
        testGetAttemptDetail();
    }

    private static void testGetAttemptDetail() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}", attempt.getUser().getName());
        LOGGER.debug("Date: {}", attempt.getDate());

        for (AttemptQuestion aq : attempt.getAttemptQuestionList()) {
            System.out.println(aq.getQuestion().getText());
            int optionNum = 1;
            for (Options op : aq.getQuestion().getOptionList()) {
                boolean selected = false;
                for (AttemptOption ao : aq.getAttemptOptionList()) {
                    if (ao.getOption().getId() == op.getId()) {
                        selected = ao.isAnswer();
                    }
                }
                System.out.printf(" %d) %-15s %.1f   %s%n",
                        optionNum++, op.getText(), aq.getQuestion().getScore(), selected);
            }
            System.out.println();
        }
        LOGGER.info("End");
    }
}
