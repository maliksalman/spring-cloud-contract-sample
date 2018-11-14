package com.smalik.producer;

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

    public ProducerController(Messaging messaging) {
        this.messaging = messaging;
    }

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person person) {
        logger.info(String.format("Adding person: Name=%s, Age=%d", person.getName(), person.getAge()));

        Message<PersonAddedEvent> message = MessageBuilder.withPayload(new PersonAddedEvent(person.getName(), person.getAge())).build();
        messaging.getPersonsChannel().send(message);
    }
}
