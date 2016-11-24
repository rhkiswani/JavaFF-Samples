package javaff.samples;

import io.github.rhkiswani.javaff.exceptions.SmartException;
import io.github.rhkiswani.javaff.format.exception.FormatException;
import io.github.rhkiswani.javaff.json.exceptions.JsonException;
import io.github.rhkiswani.javaff.lang.exceptions.IllegalParamException;
import io.github.rhkiswani.javaff.log.Log;
import io.github.rhkiswani.javaff.log.LogFactory;
import javaff.samples.loggers.MyLogger;

import java.util.Date;

/**
 * @see io.github.rhkiswani.javaff.exceptions.SmartException
 * @see io.github.rhkiswani.javaff.lang.exceptions.IllegalParamException
 * @see io.github.rhkiswani.javaff.format.exception.FormatException
 * @see io.github.rhkiswani.javaff.json.exceptions.JsonException
 */
public class Main {

    public static void main(String[] args) {
        // if you have no loggers in the pom.xml Java Util Logger will be used
        testLogs();

        /**
         * When we add the below dependency to the pom.xml all logs will be handled by logback
         *  <dependency>
         *      <groupId>ch.qos.logback</groupId>
         *      <artifactId>logback-classic</artifactId>
         *      <version>1.1.7</version>
         *  </dependency>
         */
        testLogs();

        /**
         * When we add the below dependency to the pom.xml all logs will be handled by log4j
         *  <dependency>
         *      <groupId>org.slf4j</groupId>
         *      <artifactId>slf4j-log4j12</artifactId>
         *      <version>1.7.21</version>
         *  </dependency>
         */
        testLogs();

        // if you want to set your custom logger
        // Note : this logger will be used no matter what, even if you have dependencies in the pom.xml
        LogFactory.instance().setDefault(new MyLogger());

        testLogs();
    }

    private static void testLogs() {

        // normal logs
        Log logger = LogFactory.getLogger(Main.class);

        logger.info("This is [INFO] msg");
        logger.debug("This is [DEBUG] msg");
        logger.error("This is [ERROR] msg");

        // localized
        // all messages should take place in resources/app/messages_en.properties
        logger.info("LOCALIZED_MSG_WITH_ONE_PARAM", "Param 1 String Val");
        logger.debug("LOCALIZED_MSG_WITH_TWO_PARAM", "Param 1 String Val", 1000);
        logger.error("LOCALIZED_MSG_WITH_THREE_PARAM", "Param 1 String Val", 1000, new Date());

        // exceptions

        LogFactory.getLogger(Main.class).error("This is [ERROR] NullPointerException ", new NullPointerException("with normal msg"));

        // any SmartException subclass will be localized by default
        // all messages should take place in resources/exceptions/messages_en.properties
        LogFactory.getLogger(Main.class).error("This is [ERROR] SmartException ", new SmartException("NULL_VAL", "Value"));
        LogFactory.getLogger(Main.class).error("This is [ERROR] FormatException ", new FormatException("FORMAT_EXCEPTION", "Date", "yyyy-MM-as"));
        LogFactory.getLogger(Main.class).error("This is [ERROR] JsonException ", new JsonException("NEGATIVE_VAL", "Value"));
        LogFactory.getLogger(Main.class).error("This is [ERROR] IllegalParamException ", new IllegalParamException("NOT_FOUND", "end point url"));
    }

}
