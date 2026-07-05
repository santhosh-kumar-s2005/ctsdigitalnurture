import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.debug("Debug message - visible in both console and file appenders");
        logger.info("Info message - application has started");
        logger.warn("Warning message - something might need attention");
        logger.error("Error message - something went wrong");
    }
}
