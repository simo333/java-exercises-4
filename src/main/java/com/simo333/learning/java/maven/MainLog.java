package com.simo333.learning.java.maven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {

    private static final Logger log = LogManager.getLogger(MainLog.class);

    public static void main(String[] args) {
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
        log.fatal("Fatal");

        log.info("string: {}.", "Hello world");
    }
}
