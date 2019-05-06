package com.smalik.invoker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InvokerController {

    private RandomPersonGenerator personGenerator = new RandomPersonGenerator();
    private RestTemplate restTemplate = new RestTemplate();

    private String producerBaseUrl;

    public InvokerController(@Value("${producer.base.url}") String producerBaseUrl) {
        this.producerBaseUrl = producerBaseUrl;
    }

    @Scheduled(fixedDelay = 15000)
    public String addPerson() {
        HttpEntity<Person> request = new HttpEntity<>(personGenerator.generate());
        ResponseEntity<String> entity = restTemplate.postForEntity(producerBaseUrl + "/persons", request, String.class);
        return entity.getBody();
    }
}
