package com.smalik.producer.config;

import com.smalik.producer.Messaging;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Messaging.class)
public class RabbitConfig {
}
