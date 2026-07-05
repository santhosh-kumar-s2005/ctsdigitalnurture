import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Alice";
        int userId = 42;
        double accountBalance = 1500.75;

        logger.info("User {} has logged in.", username);
        logger.debug("Fetching details for user ID: {}", userId);
        logger.warn("Account balance for user {} is low: {}", username, accountBalance);
        logger.error("Failed to process request for user ID: {} and username: {}", userId, username);
    }
}
