package com.projetDev.mapper;

import com.projetDev.model.User;
import org.bson.Document;


public class UserMapper {
    public static Document userToDocument(User user ){
        Document document = new Document()
                        .append("name", user.getName())
                        .append("firstName", user.getFirstName())
                        .append("birthDate", user.getBirthDate())
                        .append("genre", user.getGenre())
                        ;
        return document;
    };

    public static User documentToUser(Document document){
        User user = new User(
                document.getString("name"),
                document.getString("firstName"),
                document.getDate("birthDate"),
                document.getString("genre")
        );
        return user;
    }

}

