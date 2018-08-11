package com.study.atm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath*:spring/*.xml")
public class TestApplication {
    private static Logger logger = LoggerFactory.getLogger(TestApplication.class);

    public static void main(String[] args) {
        logger.info("start spring boot application .......");
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.run(args);
        logger.info("spring boot application has started ...........");
    }
}
