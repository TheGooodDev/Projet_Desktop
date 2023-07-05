package com.projetDev.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.projetDev.model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.projetDev.mapper.ActivityMapper.documentToActivity;
import static com.projetDev.mapper.UserMapper.documentToUser;
import static com.projetDev.mapper.UserMapper.userToDocument;

public class UserRepositoryImpl implements UserRepository {
    MongoCollection<Document> collection;
    public UserRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }

    @Override
    public InsertOneResult save(User user) {
        return this.collection.insertOne(userToDocument(user));
    }

    @Override
    public UpdateResult update(User user) {
        return this.collection.updateOne(
                new Document("name", user.getName()),
                new Document("$set", userToDocument(user))
        );
    }

    @Override
    public User findByName(String name) {
        return documentToUser(this.collection.find(new Document("name", name)).first());
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        this.collection.find().forEach(document -> {
            users.add(documentToUser(document));
        });
        return users;
    }

    @Override
    public DeleteResult delete(String name) {
        return this.collection.deleteOne(new Document("name", name));
    }
}
