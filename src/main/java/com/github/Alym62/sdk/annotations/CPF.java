package com.github.Alym62.sdk.annotations;

import java.lang.annotation.*;

/**
 * @author Alyasaf Meireles
 * Annotation for validated field tin - (CPF) in class domain
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF {
}
