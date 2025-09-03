package com.github.Alym62.sdk.exceptions;

import com.github.Alym62.sdk.configurations.AppConfig;

public abstract class SDKAbacatePayException extends RuntimeException {
    private final String message;
    private final int status;

    public SDKAbacatePayException(final String message, final int status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    protected ProblemDetails toProblemDetails() {
        final ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setInstance(AppConfig.getUrlAbacatePay());
        problemDetails.setStatus(status);
        problemDetails.setTitle("Internal server error");
        problemDetails.setMessage(message);

        return problemDetails;
    }
}
