package com.github.Alym62.sdk.utils;

import java.util.regex.Pattern;

public class EmailValidator {
    private EmailValidator() {}

    private static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValid(final String email) {
        if (email == null) {
            return false;
        }

        final Pattern pattern = Pattern.compile(REGEX_EMAIL, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }
}
