package com.santihs.web.app.models.domain;

import com.santihs.web.app.validator.RegexIdentifier;
import com.santihs.web.app.validator.Required;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{3}-[A-Z]{3}$")
    @RegexIdentifier
    String id;
    @Size(min = 3, max = 8, message = "Username must be at least 3 characters")
    @NotBlank(message = "The user name can't be empty")
    String username;
    @NotEmpty
    String password;
    @Required
    @Email
    String email;
    @NotNull //? It is only for objects
    @Min(5)
    @Max(500)
    Integer account;
    @NotBlank(message = "Not empty from user")
    String name;
    //    @NotEmpty
    @Required
    String lastName;
}
