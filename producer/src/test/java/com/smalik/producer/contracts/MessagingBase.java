package com.smalik.producer.contracts;

import com.smalik.producer.Person;
import com.smalik.producer.ProducerApplication;
import com.smalik.producer.ProducerController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ProducerApplication.class })
@AutoConfigureMessageVerifier
@ActiveProfiles("test")
public abstract class MessagingBase {

    @Autowired
    private ProducerController controller;

    public void personAddedIsCalled() {
        Person person = new Person();
        person.setAge(25);
        person.setName("Peter Parker");
        person.setCity("New York City");
        controller.addPerson(person);
    }
}
