package com.santihs.web.app.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = RequiredValidator.class)
public @interface Required {
    String message() default "Field required not be null or empty";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
