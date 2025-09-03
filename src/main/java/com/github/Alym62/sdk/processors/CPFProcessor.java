package com.github.Alym62.sdk.processors;

import com.github.Alym62.sdk.annotations.CPF;
import com.github.Alym62.sdk.configurations.AppConfig;
import com.github.Alym62.sdk.exceptions.CPFInvalidException;
import com.github.Alym62.sdk.utils.CPFValidator;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

public class CPFProcessor {
    private CPFProcessor() {}

    private static final ResourceBundle properties = AppConfig.getProperties("messages");

    public static void process(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(CPF.class)) {
                field.setAccessible(true);
                Object value = getValueField(field, object);

                if (value instanceof String) {
                    final String cpf = value.toString();
                    if (!CPFValidator.isValidCpf(cpf)) {
                        CPF annotation = field.getAnnotation(CPF.class);
                        String messageDefault = properties.getString(annotation.message());

                        throw new CPFInvalidException(messageDefault);
                    }
                }

                return;
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
