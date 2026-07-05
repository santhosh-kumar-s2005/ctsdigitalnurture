public class SingletonTest {

    public static void main(String[] args) {

        System.out.println("=== Singleton Pattern Test ===\n");

        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.logWarning("This is a warning message.");

        Logger logger3 = Logger.getInstance();
        logger3.logError("This is an error message.");

        System.out.println("\n=== Instance Verification ===");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("\nSingleton Pattern works correctly! Only ONE instance exists.");
        } else {
            System.out.println("\nSingleton Pattern failed! Multiple instances detected.");
        }
    }
}
