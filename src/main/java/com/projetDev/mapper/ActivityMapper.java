package com.projetDev.mapper;

import com.projetDev.model.Activity;
import org.bson.Document;

public class ActivityMapper {
    public static Document activityToDocument(Activity activity) {
        Document document = new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("publishedDate", activity.getPublishedDate())
                .append("rpe", activity.getRpe())
                .append("charge", activity.getCharge())
                ;
        return document;
    };

    public static Activity documentToActivity(Document document) {
        Activity activity = new Activity(
            document.getObjectId("_id"),
            document.getString("name"),
            document.getInteger("duration"),
            document.getDate("publishedDate"),
            document.getInteger("rpe"),
            document.getInteger("charge")
        );
        return activity;
    }
}
