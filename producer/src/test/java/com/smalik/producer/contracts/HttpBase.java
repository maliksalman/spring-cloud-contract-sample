package com.smalik.producer.contracts;

import com.smalik.producer.Messaging;
import com.smalik.producer.ProducerController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.springframework.messaging.MessageChannel;

import static org.mockito.Mockito.*;

public abstract class HttpBase {

    @Before
    public void setup() {
        Messaging mockMessaging = mock(Messaging.class);
        when(mockMessaging.getPersonsChannel()).thenReturn(mock(MessageChannel.class));

        RestAssuredMockMvc.standaloneSetup(new ProducerController(mockMessaging));
    }
}
