package com.startup.seerichallenge.services;

import com.startup.seerichallenge.models.User;
import com.startup.seerichallenge.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }

    public void update(User user) {
        this.userRepository.save(user);
    }

    public void delete(Long userId) {
        this.userRepository.deleteById(userId);
    }

    public List<User> getUserList() {
        return this.userRepository.findAll();
    }

    public Optional<User> searchById(Long userId) {
        return this.userRepository.findById(userId);
    }

    List<User> searchByEmail(String userEmail) {
        return this.userRepository.findByEmail(userEmail);
    }
}
