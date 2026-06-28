package com.tw.readit.services;

import com.tw.readit.entities.User;
import com.tw.readit.repositories.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable("users")
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @CachePut(value = "users", key = "#result.username")
    public User updateUsername(String username,long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", key = "#username")
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow();
        userRepository.delete(user);
    }
}
