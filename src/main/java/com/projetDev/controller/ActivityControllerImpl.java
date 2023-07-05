package com.projetDev.controller;

import com.projetDev.model.Activity;
import com.projetDev.repository.ActivityRepository;

import java.util.List;

public class ActivityControllerImpl  implements ActivityController{
    ActivityRepository activityRepository;
    public ActivityControllerImpl(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }
    @Override
    public String saveActivity(Activity activity) {
        return this.activityRepository.save(activity).getInsertedId().toString();
    }

    @Override
    public List<Activity> getAll() {
        return this.activityRepository.findAll();
    }

    @Override
    public Activity findByName(String name) {
        return this.activityRepository.findByName(name);
    }

    @Override
    public String updateActivity(Activity activity) {
        return this.activityRepository.update(activity).toString();
    }

    @Override
    public String deleteActivity(String name) {
        return this.activityRepository.delete(name).toString();
    }
}
