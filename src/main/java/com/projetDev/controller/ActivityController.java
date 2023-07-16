package com.projetDev.controller;

import com.projetDev.model.Activity;

import java.util.List;

public interface ActivityController {
    String saveActivity(Activity activity);
    List<Activity> getAll();

    List<Activity> getThisWeek();
    Activity findByName(String name);
    String updateActivity(Activity activity);
    String deleteActivity(String name);
}
