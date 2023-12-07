package com.santihs.web.app.validator;

import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexIdentifierValidator implements ConstraintValidator<RegexIdentifier, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^\\d{3}-\\d{3}-\\d{3}-[A-Z]{3}$");
    }
}
