package com.smalik.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.smalik.spring-cloud-contract-sample:producer:+:stubs"}, stubsMode = StubRunnerProperties.StubsMode.CLASSPATH)
public class EventPersistorTest {

    @Autowired
    private StubTrigger stubTrigger;

    @MockBean
    private EventPersistor persister;

    @Test
    public void testPersonAddedEventRecevied() {

        stubTrigger.trigger("person_added_event");

        ArgumentCaptor<PersonAddedEvent> eventArgumentCaptor = ArgumentCaptor.forClass(PersonAddedEvent.class);

        verify(persister).persist(eventArgumentCaptor.capture());
        assertEquals("super-man", eventArgumentCaptor.getValue().getName());
        assertEquals(35, eventArgumentCaptor.getValue().getAge());
    }
}
