package com.aibibang.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 程序启动入口
 */
@SpringBootApplication
@ComponentScan(value="com.aibibang.app.*")
public class StartApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(StartApplication.class);
        SpringApplication.run(StartApplication.class, args);
        logger.info("Started backend application success!");
    }
}
