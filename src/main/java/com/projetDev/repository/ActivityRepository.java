package com.projetDev.repository;

import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
import com.projetDev.model.Activity;

import java.util.List;


public interface ActivityRepository {
    InsertOneResult save(Activity activity);
    UpdateResult update(Activity activity);
    Activity findByName(String name);
    List<Activity> findAll();
    DeleteResult delete(String name);



}
