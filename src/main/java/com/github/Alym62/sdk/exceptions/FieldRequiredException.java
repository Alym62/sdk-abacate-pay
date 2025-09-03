package com.github.Alym62.sdk.exceptions;

public class FieldRequiredException extends SDKAbacatePayException {
    public FieldRequiredException(String message) {
        super(message, 404);
    }
}
