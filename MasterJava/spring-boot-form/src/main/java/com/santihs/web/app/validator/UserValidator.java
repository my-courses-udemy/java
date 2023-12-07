package com.santihs.web.app.validator;

import com.santihs.web.app.models.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.user.username");
        if (!user.getId().matches("^\\d{3}-\\d{3}-\\d{3}-[A-Z]{3}$")) {
            errors.rejectValue("id", "NotEmpty.user.identifier");
        }
    }
}
