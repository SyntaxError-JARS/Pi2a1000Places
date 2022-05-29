package com.revature.Pi2a1000Places.util.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.time.LocalDateTime;

public class Logger {

    private static Logger logger;
    private final boolean printToConsole;

    private Logger(boolean printToConsole) {//So the singleton is because we're privatizing its constructor and there's only ever going to be a single instance of the logger.
        this.printToConsole = printToConsole;
    }

    public static Logger getLogger(boolean printToConsole) {
        // logger is being lazily instantiated
        if (logger == null) {
            logger = new Logger(printToConsole);
        }

        return logger;
    }

    public static Logger getLogger() {
        // logger is being lazily instantiated
        if (logger == null) {
            logger = new Logger(true);
        }

        return logger;
    }

    public void log(String message) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL file = loader.getResource("pi2a1000.log");

        try (Writer logWriter = new FileWriter(String.valueOf(file).split(":")[1], true);) {
            logWriter.write(LocalDateTime.now().toString() + " LOG: " + message + "\n");

            if (printToConsole) {
                System.out.println(LocalDateTime.now().toString() + " LOG: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void info(String message) {
    }
}