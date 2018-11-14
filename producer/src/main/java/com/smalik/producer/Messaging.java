package com.smalik.producer;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Messaging {

    String PERSONS = "persons";

    @Output(PERSONS)
    MessageChannel getPersonsChannel();
}
