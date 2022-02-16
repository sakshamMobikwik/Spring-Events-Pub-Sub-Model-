package com.example.scheulers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JobScheduler {

    private static final Logger log = LogManager.getLogger(JobScheduler.class);


    @Scheduled(cron = "0 0/1 * * * *")
    public void reportCurrentTime() {
        log.info("Chala");
    }
}