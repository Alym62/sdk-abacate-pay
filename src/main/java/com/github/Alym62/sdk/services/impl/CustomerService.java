package com.github.Alym62.sdk.services.impl;

import com.github.Alym62.sdk.clients.CustomerClient;
import com.github.Alym62.sdk.configurations.AppConfig;
import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.responses.AbacatePayResponse;
import com.github.Alym62.sdk.responses.CustomerResponse;
import com.github.Alym62.sdk.services.ICustomerService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.extern.java.Log;

@Log
public class CustomerService implements ICustomerService {
    private final CustomerClient customerClient;

    public CustomerService() {
        this.customerClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(template -> template.header("Authorization", "Bearer " + AppConfig.getApiKey()))
                .target(CustomerClient.class, AppConfig.getUrlAbacatePay());
    }

    @Override
    public AbacatePayResponse<CustomerResponse> create(Customer customer) {
        return customerClient.createCustomer(customer);
    }
}
