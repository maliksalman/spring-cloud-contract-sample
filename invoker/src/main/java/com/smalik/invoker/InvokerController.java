package com.smalik.invoker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InvokerController {

    private String producerBaseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public InvokerController(@Value("${producer.base.url}") String producerBaseUrl) {
        this.producerBaseUrl = producerBaseUrl;
    }

    @PostMapping("/")
    public int addPerson(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {

        HttpEntity<Person> request = new HttpEntity<>(new Person(name, age));
        ResponseEntity<Void> entity = restTemplate.postForEntity(producerBaseUrl + "/persons", request, Void.class);
        return entity.getStatusCodeValue();
    }
}
