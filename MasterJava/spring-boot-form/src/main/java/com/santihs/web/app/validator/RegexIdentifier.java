package com.santihs.web.app.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = RegexIdentifierValidator.class)
public @interface RegexIdentifier {
    String message() default "Id invalid from custom annotation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

