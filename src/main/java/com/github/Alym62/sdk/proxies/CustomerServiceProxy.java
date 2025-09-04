package com.github.Alym62.sdk.proxies;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.exceptions.CreateCustomerException;
import com.github.Alym62.sdk.responses.AbacatePayResponse;
import com.github.Alym62.sdk.responses.CustomerResponse;
import com.github.Alym62.sdk.services.ICustomerService;
import com.github.Alym62.sdk.services.impl.CustomerService;
import lombok.extern.java.Log;

@Log
public class CustomerServiceProxy implements ICustomerService {
    private final ICustomerService service = new CustomerService();

    @Override
    public AbacatePayResponse<CustomerResponse> create(Customer customer) {
        log.info("[Customer] -> {" + customer + "}");

        final AbacatePayResponse<CustomerResponse> result = service.create(customer);
        if (result == null) {
            throw new CreateCustomerException("Dont possible create customer in AbacatePay");
        }

        log.info("[Result of request] -> {" + result + "}");
        log.info("[Customer - result] -> {" + result.getData() + "}");
        return result;
    }
}
