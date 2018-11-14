package com.smalik.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventPersister {

    private Logger logger = LoggerFactory.getLogger(EventPersister.class);

    public void persist(PersonAddedEvent event) {
        logger.info(
                String.format("Person added: Id=%s, Date=%s, Name=%s, Age=%d",
                        event.getId(),
                        event.getAddedAt().toInstant().toString(),
                        event.getName(),
                        event.getAge()));
    }
}
