public class SingletonPattern {

    // Logger class implementing Singleton pattern
    public static class Logger {
        private static Logger instance;

        private Logger() {
            // Private constructor to prevent instantiation
        }

        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println(message);
        }
    }

    // Test the Singleton Implementation
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("This is a log message from logger1.");
        logger2.log("This is a log message from logger2.");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
