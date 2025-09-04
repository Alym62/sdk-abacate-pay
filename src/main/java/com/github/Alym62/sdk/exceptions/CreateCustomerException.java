package com.github.Alym62.sdk.exceptions;

public class CreateCustomerException extends SDKAbacatePayException {
    public CreateCustomerException(String message) {
        super(message, 400);
    }
}
