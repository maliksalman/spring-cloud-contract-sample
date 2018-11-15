package com.smalik.producer;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private Logger logger = LoggerFactory.getLogger(ProducerController.class);
    private Messaging messaging;
    private Counter counter;

    public ProducerController(Messaging messaging, MeterRegistry metrics) {
        this.messaging = messaging;
        this.counter = metrics.counter("app.person.added");
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person person) {
        logger.info(String.format("Adding person: Name=%s, Age=%d", person.getName(), person.getAge()));

        Message<PersonAddedEvent> message = MessageBuilder.withPayload(new PersonAddedEvent(person.getName(), person.getAge())).build();
        messaging.getPersonsChannel().send(message);
        counter.increment();
    }
}
