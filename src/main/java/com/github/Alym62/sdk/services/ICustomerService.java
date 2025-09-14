package com.github.Alym62.sdk.services;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.utils.AbacatePayResponse;

import java.util.List;

public interface ICustomerService {
    AbacatePayResponse<Customer.CustomerResponse> create(Customer customer);

    AbacatePayResponse<List<Customer.CustomerResponse>> list();
}
