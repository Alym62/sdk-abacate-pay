package com.github.Alym62.sdk.responses;

import com.github.Alym62.sdk.domain.Customer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerResponse {
    private String id;
    private Customer metadata;
}
