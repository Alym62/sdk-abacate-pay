package com.github.Alym62.sdk.clients;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.responses.AbacatePayResponse;
import com.github.Alym62.sdk.responses.CustomerResponse;
import feign.Headers;
import feign.RequestLine;

public interface CustomerClient {
    @RequestLine("POST /customer/create")
    @Headers("Content-Type: application/json; charset=utf-8")
    AbacatePayResponse<CustomerResponse> createCustomer(Customer customer);
}
