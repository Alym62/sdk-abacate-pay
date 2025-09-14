package com.github.Alym62.sdk.proxies;

import com.github.Alym62.sdk.clients.CustomerClient;
import com.github.Alym62.sdk.configurations.AbacatePayConfiguration;
import com.github.Alym62.sdk.utils.AppConfig;
import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.services.ICustomerService;
import com.github.Alym62.sdk.utils.AbacatePayResponse;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class CustomerServiceProxy implements ICustomerService {
    private static CustomerServiceProxy INSTANCE;
    private static final Logger LOG = LogManager.getLogger(CustomerServiceProxy.class);

    private static AbacatePayConfiguration abacatePayConfiguration;
    private final ICustomerService service;

    public static synchronized CustomerServiceProxy getInstance(final AbacatePayConfiguration abacatePayConfiguration) {
        if (INSTANCE == null) {
            INSTANCE = new CustomerServiceProxy(abacatePayConfiguration);
        }

        return INSTANCE;
    }

    private CustomerServiceProxy(final AbacatePayConfiguration configuration) {
        abacatePayConfiguration = configuration;
        this.service = new CustomerService();
    }

    @Override
    public AbacatePayResponse<Customer.CustomerResponse> create(Customer customer) {
        LOG.info("[Customer] -> {}", customer);

        final AbacatePayResponse<Customer.CustomerResponse> result = service.create(customer);

        LOG.info("[Customer - result] -> {}", result.getData());
        return result;
    }

    @Override
    public AbacatePayResponse<List<Customer.CustomerResponse>> list() {
        LOG.info("[Customer] -> Initial request to search list customer");

        AbacatePayResponse<List<Customer.CustomerResponse>> result = service.list();
        if (result == null) LOG.warn("[Customer] -> list customer is empty");

        return result;
    }

    /**
     * @author Alyasaf Meireles
     * Inner class for service call and comunication with API and client - Feign
     */
    static class CustomerService implements ICustomerService {
        private final CustomerClient customerClient;

        /**
         * @author Alyasaf Meireles
         * Implementation of configuration Feign
         */
        private CustomerService() {
            this.customerClient = Feign.builder()
                    .client(new OkHttpClient())
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .logLevel(feign.Logger.Level.FULL)
                    .requestInterceptor(template -> template
                            .header("Authorization", "Bearer " + abacatePayConfiguration.getApiKey()))
                    .target(CustomerClient.class, AppConfig.getUrlAbacatePay());
        }

        @Override
        public AbacatePayResponse<Customer.CustomerResponse> create(Customer customer) {
            return customerClient.createCustomer(customer);
        }

        @Override
        public AbacatePayResponse<List<Customer.CustomerResponse>> list() {
            return customerClient.listCustomer();
        }
    }
}
