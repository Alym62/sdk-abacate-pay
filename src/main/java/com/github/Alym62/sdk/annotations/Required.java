package com.github.Alym62.sdk.annotations;

import java.lang.annotation.*;

/**
 * @author Alyasaf Meireles
 * Annotation for validated fields of class domain
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    String field();
}
