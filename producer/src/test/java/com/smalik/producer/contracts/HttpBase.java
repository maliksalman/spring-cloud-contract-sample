package com.smalik.producer.contracts;

import com.smalik.producer.Messaging;
import com.smalik.producer.ProducerController;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.springframework.messaging.MessageChannel;

import static org.mockito.Mockito.*;

public abstract class HttpBase {

    @Before
    public void setup() {
        Messaging mockMessaging = mock(Messaging.class);
        when(mockMessaging.getPersonsChannel()).thenReturn(mock(MessageChannel.class));

        MeterRegistry mockMetrics = mock(MeterRegistry.class);
        when(mockMetrics.counter(anyString())).thenReturn(mock(Counter.class));

        RestAssuredMockMvc.standaloneSetup(new ProducerController(mockMessaging, mockMetrics));
    }
}
