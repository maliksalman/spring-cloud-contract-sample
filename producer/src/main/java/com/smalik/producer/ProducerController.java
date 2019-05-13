package com.smalik.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProducerController {

    private Logger logger = LoggerFactory.getLogger(ProducerController.class);
    private Messaging messaging;

    public ProducerController(Messaging messaging) {
        this.messaging = messaging;
    }

    @PostMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addPerson(@RequestBody Person person) {
        logger.info(String.format("Adding person: Name=[%s] City=[%s] Age=[%d]", person.getName(), person.getCity(), person.getAge()));

        PersonAddedEvent event = new PersonAddedEvent(person.getName(), person.getCity(), person.getAge());
        Message<PersonAddedEvent> message = MessageBuilder.withPayload(event).build();

        messaging.getPersonsChannel().send(message);
        return event.getId();
    }

}
