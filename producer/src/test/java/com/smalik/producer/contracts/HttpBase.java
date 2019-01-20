package com.smalik.producer.contracts;

import com.smalik.producer.Messaging;
import com.smalik.producer.ProducerApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProducerApplication.class })
@ActiveProfiles("test")
public abstract class HttpBase {

    @MockBean
    Messaging mockMessaging;

    @Autowired
    WebApplicationContext context;

    @Before
    public void setup() {
        when(mockMessaging.getPersonsChannel()).thenReturn(mock(MessageChannel.class));

        RestAssuredMockMvc.webAppContextSetup(context);
    }
}
