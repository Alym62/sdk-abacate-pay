package com.github.Alym62.sdk.processors;

import com.github.Alym62.sdk.annotations.Email;
import com.github.Alym62.sdk.utils.AppConfig;
import com.github.Alym62.sdk.exceptions.FieldRequiredException;
import com.github.Alym62.sdk.utils.EmailValidator;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

public class EmailProcessor {
    private EmailProcessor() {}

    private static final ResourceBundle properties = AppConfig.getProperties("messages");

    public static void process(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Email.class)) {
                field.setAccessible(true);
                Object value = getValueField(field, object);

                if (value instanceof String) {
                    final String email = value.toString();
                    if (!EmailValidator.isValid(email)) {
                        String messageDefault = properties.getString("msg.error.email");
                        throw new FieldRequiredException(messageDefault);
                    }
                }
            }
        }
    }

    private static Object getValueField(final Field field, final Object object) {
        try {
            return field.get(object);
        } catch (IllegalAccessException exception) {
            return null;
        }
    }
}
