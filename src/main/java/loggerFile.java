import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loggerFile {
    private static final Logger logger = LogManager.getLogger(loggerFile.class);

    public static void main(final String... args)
    {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx");
        logger.debug("Debug Message Logged !!!");
        logger.info("Info Message Logged !!!");
        logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
    }
}
