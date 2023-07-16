package com.projetDev.controller;

import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import com.projetDev.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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
    public List<Activity> getThisWeek() {
        List<Activity> activityList = this.activityRepository.findAll();
        List<Activity> activityWeekList =new ArrayList<>();
        Logger logger = LoggerFactory.getLogger(ActivityControllerImpl.class);

        for (Activity activity: activityList) {
            if (isInWeek(getWeekNumber(activity.getPublishedDate()))){
                activityWeekList.add(activity);
            }
        }
        return activityWeekList;
    }

    private int getWeekNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    private boolean isInWeek(int targetWeekDay){
        Calendar calendar = Calendar.getInstance();
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        if(targetWeekDay == weekNumber) {
            return true;
        }
        return false;
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
