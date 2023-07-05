package com.projetDev.repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.projetDev.model.Activity;
import com.projetDev.model.User;

import java.util.List;

public interface UserRepository {
    InsertOneResult save(User user);
    UpdateResult update(User user);
    User findByName(String name);
    List<User> findAll();
    DeleteResult delete(String name);
}
