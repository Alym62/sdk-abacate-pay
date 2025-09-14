package com.github.Alym62.sdk.processors;

import com.github.Alym62.sdk.annotations.Required;
import com.github.Alym62.sdk.utils.AppConfig;
import com.github.Alym62.sdk.exceptions.FieldRequiredException;

import java.lang.reflect.Field;
import java.util.ResourceBundle;

public class RequiredProcessor {
    private RequiredProcessor() {}

    private static final ResourceBundle properties = AppConfig.getProperties("messages");

    public static void process(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                field.setAccessible(true);
                Object value = getValueField(field, object);

                if (value == null) {
                    final Required annotation = field.getAnnotation(Required.class);
                    String messageDefault = properties.getString("msg.error.field");

                    messageDefault = messageDefault.replace("${field}", annotation.field());

                    throw new FieldRequiredException(messageDefault);
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
