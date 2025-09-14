package com.github.Alym62.sdk;

import com.github.Alym62.sdk.configurations.AbacatePayConfiguration;
import com.github.Alym62.sdk.domain.Customer;
import com.github.Alym62.sdk.proxies.CustomerServiceProxy;
import com.github.Alym62.sdk.services.ICustomerService;
import com.github.Alym62.sdk.utils.AbacatePayResponse;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final AbacatePayConfiguration configuration = new AbacatePayConfiguration.DefaultConfigurationCircuitAndRetry()
                .apiKey("abc_dev_Lt22PXqTB5TkmUN1QGGBgERX")
                .build();
        final ICustomerService service = CustomerServiceProxy.getInstance(configuration);

        final AbacatePayResponse<Customer.CustomerResponse> customerCreated = service.create(
                Customer.builder()
                        .name("Jonny") // Fake name
                        .cellPhone("(61) 3622-4002") // Fake cellphone
                        .email("jnn@email.com") // Fake email
                        .taxId("935.584.681-98") // Fake cpf
                        .build()
        );
        final AbacatePayResponse<List<Customer.CustomerResponse>> customerList = service.list();

        System.out.println(customerCreated);
        System.out.println(customerList);
    }
}
