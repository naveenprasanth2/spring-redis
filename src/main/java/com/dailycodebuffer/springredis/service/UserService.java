package com.dailycodebuffer.springredis.service;

import com.dailycodebuffer.springredis.model.User;
import com.dailycodebuffer.springredis.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }
}
