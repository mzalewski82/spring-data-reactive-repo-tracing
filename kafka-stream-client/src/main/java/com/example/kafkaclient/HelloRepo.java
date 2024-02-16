package com.example.kafkaclient;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepo extends CrudRepository<Hello, ObjectId> {
}
