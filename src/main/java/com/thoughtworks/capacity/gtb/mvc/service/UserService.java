package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.LoginValidException;
import com.thoughtworks.capacity.gtb.mvc.exception.NameRepeatException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public void register(User user) {
        if (userMap.get(user.getUsername()) != null) {
            throw new NameRepeatException("username already exists");
        }
        user.setId(userMap.size() + 1);
        userMap.put(user.getUsername(), user);
    }

    public  User  login(String username, String password) {
        User user = userMap.get(username);
        if (user == null) {
            throw new LoginValidException("username or password error");
        }
        if(!password.equals(user.getPassword())) {
            throw new LoginValidException("username or password error");
        }
        return user;
    }
}
