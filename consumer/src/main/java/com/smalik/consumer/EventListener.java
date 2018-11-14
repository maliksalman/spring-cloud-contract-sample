package com.smalik.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EventListener {

    private Messaging messaging;
    private EventPersister persister;

    public EventListener(Messaging messaging, EventPersister persister) {
        this.messaging = messaging;
        this.persister = persister;
    }

    @StreamListener(Messaging.PERSONS)
    public void handlePersonAddedEvent(@Payload PersonAddedEvent event) {
        persister.persist(event);
    }
}
