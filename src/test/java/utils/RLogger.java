package utils;

import org.apache.log4j.Logger;

public class RLogger {
    private Logger logger;

    public RLogger(Object obj) {
        logger = Logger.getLogger(obj.getClass());
    }
    public void info(String message) {
        logger.info(String.format("[Amazon] %s", message));
    }

    public void info(String message, Throwable t) {
        logger.info(String.format("[Amazon] %s", message), t);
    }

}
