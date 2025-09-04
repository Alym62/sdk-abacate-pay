package com.github.Alym62.sdk.services;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.responses.AbacatePayResponse;
import com.github.Alym62.sdk.responses.CustomerResponse;

public interface ICustomerService {
    AbacatePayResponse<CustomerResponse> create(Customer customer);
}
