public class Logger {

    private static Logger instance;

    private Logger() {
        System.out.println("Logger instance created.");
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public void logError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void logWarning(String message) {
        System.out.println("[WARNING] " + message);
    }
}
