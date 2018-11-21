package com.smalik.invoker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "producer.base.url=http://localhost:6565" })
@AutoConfigureStubRunner(ids = {"com.smalik.spring-cloud-contract-sample:producer:+:stubs:6565"}, stubsMode = StubRunnerProperties.StubsMode.CLASSPATH)
public class InvokerControllerTest {

    @Autowired
    private InvokerController controller;

    @Test
    public void testSomething() {
        int returnValue = controller.addPerson("Foo Bar", 100);
        Assert.assertEquals(200, returnValue);
    }
}
