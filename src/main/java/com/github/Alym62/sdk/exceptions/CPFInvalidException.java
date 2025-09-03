package com.github.Alym62.sdk.exceptions;

import com.github.Alym62.sdk.configurations.AppConfig;

/**
 * @author Alyasaf Meireles
 * Exception for business errors of CPF
 */
public class CPFInvalidException extends SDKAbacatePayException {
    private final String message;

    public CPFInvalidException(String message) {
        super(message, 404);
        this.message = message;
    }

    @Override
    protected ProblemDetails toProblemDetails() {
        final ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setInstance(AppConfig.getUrlAbacatePay());
        problemDetails.setStatus(404);
        problemDetails.setTitle("CPF invalid, please check");
        problemDetails.setMessage(message);

        return problemDetails;
    }
}
