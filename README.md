Log4j2 XML Configuration: Log4j2.xml Example
Lokesh Gupta
September 19, 2023
Log4j2
Java Logging
Learn to configure log4j2.xml file to output the log statements to the console, rolling files etc. Learn to configure log4j2 appenders, levels and patterns.

Apache Log4j2 is an upgrade to Log4j 1.x that provides significant improvements over its predecessor such as performance improvement, automatic reloading of modified configuration files, Java 8 lambda support and custom log levels.

If not upgraded already, it is highly recommended to upgrade Log4j2 to the latest version 2.16.0 which has the fix for a recently found vulnerability CVE-2021-45046. Read the latest updates to the library here.

1. Log4j2 Dependencies
   Find the latest version from this link. Please note that using Log4j2 with SLF4J is recommended approach.

1.1. Maven
pom.xml
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-api</artifactId>
<version>2.20.0</version>
</dependency>
<dependency>
<groupId>org.apache.logging.log4j</groupId>
<artifactId>log4j-core</artifactId>
<version>2.20.0</version>
</dependency>

2. ConsoleAppender – Logging to Cosole
   We can use below log4j2.xml file logging output into the console. It uses the ConsoleAppender API.

Please note that if no configuration file can be located while initializing the Log4j2 then DefaultConfiguration will be used. The default configuration causes logging output to go to the console.
Add this file in root folder of your project structure
log4j2.xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- Extra logging related to initialization of Log4j. 
 Set to debug or trace if log4j initialization is failing. -->
<Configuration status="warn">
    <Appenders>
    	<!-- Console appender configuration -->
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout
                pattern="%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n" />
        </Console>
    </Appenders>
    <Loggers>
    	<!-- Root logger referring to console appender -->
        <Root level="info" additivity="false">
            <AppenderRef ref="console" />
        </Root>
    </Loggers>
</Configuration>

3.  Core Log4j2  API logic add in your class 

    import org.apache.logging.log4j.Logger;
    import org.apache.logging.log4j.LogManager;

public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(final String... args) 
	{
		logger.debug("Debug Message Logged !!!");
		logger.info("Info Message Logged !!!");
		logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
	}
}

4. Run your project you should be seeing the result in your console:

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxx
15:37:33.090 [main] ERROR loggerFile - Error Message Logged !!!
java.lang.NullPointerException: NullError
at loggerFile.main(loggerFile.java:12) [classes/:?]

Process finished with exit code 0
