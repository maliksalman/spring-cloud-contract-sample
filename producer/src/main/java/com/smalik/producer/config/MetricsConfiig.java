package com.smalik.producer.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class MetricsConfiig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> customizeMetrics() {
        return registry -> registry.config()
                .commonTags("env", "dev", "application", "producer");
    }

}
