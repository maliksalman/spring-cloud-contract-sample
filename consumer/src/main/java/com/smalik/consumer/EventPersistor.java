package com.smalik.consumer;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Random;

@Component
public class EventPersistor {

    private Logger logger = LoggerFactory.getLogger(EventPersistor.class);
    private Random random = new Random();

    private Duration waitDuration;
    private Timer timer;


    public EventPersistor(MeterRegistry registry, @Value("${max.persist.duration:2}") long seconds) {
        this.timer = registry.timer("app.person.persisted");
        this.waitDuration = Duration.ofSeconds(seconds);
    }

    public void persist(PersonAddedEvent event) {
        timer.wrap(() -> {
            try {
                Thread.sleep(random.nextInt((int)waitDuration.toMillis()));
                logger.info(
                        String.format("Person added: Id=%s, Date=%s, Name=%s, Age=%d",
                                event.getId(),
                                event.getAddedAt().toInstant().toString(),
                                event.getName(),
                                event.getAge()));
            } catch (InterruptedException e) {
                logger.info("Got interrupted", e);
            }
        }).run();
    }
}
