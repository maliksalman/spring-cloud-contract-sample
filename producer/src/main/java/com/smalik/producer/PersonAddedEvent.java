package com.smalik.producer;

import java.util.Date;
import java.util.UUID;

public class PersonAddedEvent {

    private String id;
    private Date addedAt;
    private String name;
    private int age;

    public PersonAddedEvent(String name, int age) {
        this(UUID.randomUUID().toString(), new Date(), name, age);
    }

    public PersonAddedEvent(String id, Date addedAt, String name, int age) {
        this.id = id;
        this.addedAt = addedAt;
        this.name = name;
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
}
