package com.github.Alym62.sdk.utils;

public class CPFValidator {
    private static final String REGEX_REMOVE_ANY_DONT_DIGIT = "\\D";
    private static final String REGEX_VALIDATION_NUMBERS_EQUALS = "(\\\\d)\\\\1{10}";

    private CPFValidator() {}

    public static boolean isValidCpf(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            return false;
        }

        cpf = cpf.replaceAll(REGEX_REMOVE_ANY_DONT_DIGIT, "");
        if (cpf.length() != 11 || cpf.matches(REGEX_VALIDATION_NUMBERS_EQUALS)) {
            return false;
        }

        final int digitOne = calculateDigit(cpf.substring(0, 9), 10);
        final int digitTwo = calculateDigit(cpf.substring(0, 9) + digitOne, 11);

        return cpf.equals(cpf.substring(0, 9) + digitOne + digitTwo);
    }

    private static int calculateDigit(final String str, int startingWeight) {
        int sum = 0;

        for (char character : str.toCharArray()) {
            sum += (character - '0') * startingWeight--;
        }

        int result = sum % 11;
        return (result < 2) ? 0 : 11;
    }
}
