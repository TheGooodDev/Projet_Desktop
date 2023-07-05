package com.projetDev.controller;

import com.projetDev.model.Activity;
import com.projetDev.model.User;

import java.util.List;

public interface UserController {
    String saveUser(User user);
    List<User> getAll();
    User findByName(String name);
    String updateActivity(User user);
    String deleteActivity(String name);
}
