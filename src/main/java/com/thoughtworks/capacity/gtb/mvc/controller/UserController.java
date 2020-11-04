package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) {
        userService.register(user);
    }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestParam @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "username must be consisted of numbers, letters and underscores and length between 3 digit and 10 digit") String username,
                                      @RequestParam @Size(min = 5, max = 12, message = "The length of password must be between 5 digit and 12 digit") String password) {
        User user = userService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
