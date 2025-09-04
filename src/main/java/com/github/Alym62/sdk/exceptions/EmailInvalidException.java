package com.github.Alym62.sdk.exceptions;

import com.github.Alym62.sdk.configurations.AppConfig;

public class EmailInvalidException extends SDKAbacatePayException {
    private final String message;

    public EmailInvalidException(String message) {
        super(message, 400);
        this.message = message;
    }

    @Override
    protected ProblemDetails toProblemDetails() {
        final ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setInstance(AppConfig.getUrlAbacatePay());
        problemDetails.setStatus(400);
        problemDetails.setTitle("Email invalid, please check");
        problemDetails.setMessage(message);

        return problemDetails;
    }
}
