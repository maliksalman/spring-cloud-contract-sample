package com.smalik.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Messaging {

    String PERSONS = "persons";

    @Input(PERSONS)
    SubscribableChannel getPersonsChannel();
}
