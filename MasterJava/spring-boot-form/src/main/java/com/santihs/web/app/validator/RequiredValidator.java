package com.santihs.web.app.validator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class RequiredValidator implements ConstraintValidator<Required, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        return !isNull(value) && !value.isEmpty() && !value.isBlank();
        return !isNull(value) && StringUtils.hasText(value);
    }
}
