package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.NameRepeatException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public void register(User user) {
        if(userMap.get(user.getUsername()) != null) {
            throw new NameRepeatException("username already exists");
        }
        userMap.put(user.getUsername(), user);
    }
}
