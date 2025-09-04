package com.github.Alym62.sdk;

import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.proxies.CustomerServiceProxy;
import com.github.Alym62.sdk.services.ICustomerService;

public class Main {
    private static final ICustomerService customerService = new CustomerServiceProxy();

    public static void main(String[] args) {
        final Customer customer = Customer.builder()
                .name("Teste SDK 2")
                .cellPhone("(61) 3621-4025")
                .email("aly@email.com")
                .taxId("525.678.651-28")
                .build();

        System.out.println(customer);

        createTest(customer);
    }

    /**
     * @author Alyasaf Meireles
     * Tests for call api abacatePay
     */
    private static void createTest(final Customer customer) {
        customerService.create(customer);
    }
}
