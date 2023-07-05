package com.projetDev.controller;

import com.projetDev.model.Activity;
import com.projetDev.model.User;
import com.projetDev.repository.UserRepository;

import java.util.List;

public class UserControllerImpl implements UserController {
    UserRepository userRepository;
    public UserControllerImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String saveUser(User user) {
        return this.userRepository.save(user).getInsertedId().toString();
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public String updateActivity(User user){
        return this.userRepository.update(user).toString();
    }

    @Override
    public String deleteActivity(String name) {
        return this.userRepository.delete(name).toString();
    }
}
