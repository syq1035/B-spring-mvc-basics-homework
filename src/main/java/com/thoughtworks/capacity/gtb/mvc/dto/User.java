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
    @NotEmpty
    @Size(min = 3, max = 10)
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}")
    private String username;
    @NotEmpty
    @Size(min = 5, max = 12)
    private String password;
    @Email
    private String email;
}
