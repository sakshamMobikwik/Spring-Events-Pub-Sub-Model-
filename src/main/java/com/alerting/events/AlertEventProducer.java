package com.alerting.events;

import com.alerting.runnables.EventProducerTaskHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("alertEventProducer")
public class AlertEventProducer extends AbstractEventProducer implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    private Logger logger = LogManager.getLogger(this.getClass());

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public <T> void produce(T event) {
       logger.info("Event Produced : {}",event);
       executorService.execute(new EventProducerTaskHandler(event,publisher));
       executorService.shutdown();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
       this.publisher = applicationEventPublisher;
    }

}
