package com.smalik.producer;

import java.util.Date;
import java.util.UUID;

public class PersonAddedEvent {

    private String id;
    private Date addedAt;
    private String name;
    private String city;
    private int age;

    public PersonAddedEvent(String name, String city, int age) {
        this.id = UUID.randomUUID().toString();
        this.addedAt = new Date();
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
