package com.projetDev;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import com.projetDev.repository.ActivityRepositoryImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://feliciencourdesse:yqJBSTE2qwDcemEh@cluster0.0xoxxwo.mongodb.net/?retryWrites=true&w=majority";
        try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")){
            ActivityControllerImpl activityController = new ActivityControllerImpl(dbConnection.getActivityRepository());
            Activity activity = new Activity(
                    "test3",
                    100,
                    8,
                    new Date(new Date().getTime())
            );
            activityController.saveActivity(activity);


        } catch (Exception e) {
            logger.error("An error occurred during connection ==> {}", e.toString());
        }
    }
}
