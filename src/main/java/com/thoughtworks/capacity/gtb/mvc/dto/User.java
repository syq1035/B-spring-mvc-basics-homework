package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "username must not be null")
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "username must be consisted of numbers, letters and underscores and length between 3 digit and 10 digit")
    private String username;
    @NotEmpty(message = "password must not be null")
    @Size(min = 5, max = 12, message = "The length of password must be between 5 digit and 12 digit")
    private String password;
    @Email(message = "email address must not be invalid")
    private String email;
}
