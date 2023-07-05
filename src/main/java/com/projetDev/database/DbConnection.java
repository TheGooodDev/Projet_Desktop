package com.projetDev.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.projetDev.repository.ActivityRepositoryImpl;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbConnection implements AutoCloseable{

    private static final Logger logger = LoggerFactory.getLogger(DbConnection.class);
    private  MongoClient mongoClient;
    private MongoDatabase database;


    public DbConnection(String name, String password) {
        String connectionString = "mongodb+srv://"+name+":"+password+"@cluster0.0xoxxwo.mongodb.net/?retryWrites=true&w=majority";
        mongoClient = MongoClients.create(connectionString);

        this.database = mongoClient.getDatabase("myWorkout");
        logger.info("Database connection successful");

    }

    public ActivityRepositoryImpl getActivityRepository(){
        MongoCollection<Document> activitiesCollection = database.getCollection("activities");
        logger.info("Get activity repository");
        return new ActivityRepositoryImpl(activitiesCollection);
    }

    @Override
    public void close() throws Exception {
        mongoClient.close();
        throw new Exception("Database connection closed");
    }
}
