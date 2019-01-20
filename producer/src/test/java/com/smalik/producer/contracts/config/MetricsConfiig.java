package com.smalik.producer.contracts.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class MetricsConfiig {

    @Bean
    public MeterRegistry meterRegistry() {
        return new CompositeMeterRegistry();
    }
}
