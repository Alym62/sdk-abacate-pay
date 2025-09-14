package com.github.Alym62.sdk.configurations;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import lombok.Getter;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

/**
 * @author Alyasaf Meireles
 * Class of configuration AbacatePay with setups - (ApiKey) and inner class - (DefaultConfigurationCircuitAndRetry, CustomConfigurationCircuitAndRetry)
 */
public class AbacatePayConfiguration {
    @Getter
    private final String apiKey;

    @Getter
    private final RetryConfig retryConfig;

    @Getter
    private final CircuitBreakerConfig circuitBreakerConfig;

    private AbacatePayConfiguration(DefaultConfigurationCircuitAndRetry defaultConfiguration) {
        this.retryConfig = defaultConfiguration.retryConfig;
        this.circuitBreakerConfig = defaultConfiguration.circuitBreakerConfig;
        this.apiKey = defaultConfiguration.apiKey;
    }

    private AbacatePayConfiguration(CustomConfigurationCircuitAndRetry customConfiguration) {
        this.retryConfig = customConfiguration.retryConfig;
        this.circuitBreakerConfig = customConfiguration.circuitBreakerConfig;
        this.apiKey = customConfiguration.apiKey;
    }

    /**
     * @author Alyasaf Meireles
     * Inner Class of default configurations for Retry and CircuitBreaker
     */
    public static final class DefaultConfigurationCircuitAndRetry extends ApiKeyConfiguration {
        private final RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(2))
                .retryOnException(ex -> ex instanceof TimeoutException)
                .build();

        private final CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .slidingWindowSize(5)
                .build();

        public DefaultConfigurationCircuitAndRetry apiKey(final String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public AbacatePayConfiguration build() {
            return new AbacatePayConfiguration(this);
        }
    }

    /**
     * @author Alyasaf Meireles
     * Inner Class of custom configurations for Retry and CircuitBreaker
     */
    public static final class CustomConfigurationCircuitAndRetry extends ApiKeyConfiguration {
        private CircuitBreakerConfig circuitBreakerConfig;
        private RetryConfig retryConfig;

        public CustomConfigurationCircuitAndRetry circuitBreakerConfig(final CircuitBreakerConfig circuitBreakerConfig) {
            this.circuitBreakerConfig = circuitBreakerConfig;
            return this;
        }

        public CustomConfigurationCircuitAndRetry retryConfig(final RetryConfig retryConfig) {
            this.retryConfig = retryConfig;
            return this;
        }

        public CustomConfigurationCircuitAndRetry apiKey(final String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public AbacatePayConfiguration build() {
            return new AbacatePayConfiguration(this);
        }
    }

    /**
     * @author Alyasaf Meireles
     * Inner Class of base configurations for ApiKey AcabatePay
     */
    abstract static class ApiKeyConfiguration {
        protected String apiKey;

        public ApiKeyConfiguration apiKey(final String apiKey) {
            this.apiKey = apiKey;
            return this;
        }
    }
}
