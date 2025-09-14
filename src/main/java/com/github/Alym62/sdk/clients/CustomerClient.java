package com.github.Alym62.sdk.clients;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.utils.AbacatePayResponse;
import feign.Headers;
import feign.RequestLine;

import java.util.List;

/**
 * @author Alyasaf Meireles
 * Interface for comunication with API external - Feign
 */
public interface CustomerClient {
    @RequestLine("POST /customer/create")
    @Headers("Content-Type: application/json; charset=utf-8")
    AbacatePayResponse<Customer.CustomerResponse> createCustomer(Customer customer);

    @RequestLine("GET /customer/list")
    @Headers("Content-Type: application/json; charset=utf-8")
    AbacatePayResponse<List<Customer.CustomerResponse>> listCustomer();
}
