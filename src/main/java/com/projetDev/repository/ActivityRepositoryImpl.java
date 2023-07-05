package com.projetDev.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.projetDev.model.Activity;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.projetDev.mapper.ActivityMapper.activityToDocument;
import static com.projetDev.mapper.ActivityMapper.documentToActivity;

public class ActivityRepositoryImpl implements ActivityRepository {
    MongoCollection<Document> collection;
    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }
    @Override
    public InsertOneResult save(Activity activity) {
        return this.collection.insertOne(activityToDocument(activity));
    }

    @Override
    public UpdateResult update(Activity activity) {
        activity.setCharge(activity.getRpe()*activity.getDuration());
        return this.collection.updateOne(
            new Document("name", activity.getName()),
            new Document("$set", activityToDocument(activity))
        );
    }

    @Override
    public Activity findByName(String name) {
        return documentToActivity(this.collection.find(new Document("name", name)).first());
    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activities = new ArrayList<Activity>();
        this.collection.find().forEach(document -> {
            activities.add(documentToActivity(document));
        });
        return activities;
    }

    @Override
    public DeleteResult delete(String name) {
        return this.collection.deleteOne(new Document("name", name));
    }
}
