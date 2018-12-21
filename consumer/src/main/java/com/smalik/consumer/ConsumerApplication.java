package com.smalik.consumer;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(Messaging.class)
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> customizeMetrics() {
        return registry -> registry.config()
                .commonTags("env", "dev", "application", "consumer");
    }
}
