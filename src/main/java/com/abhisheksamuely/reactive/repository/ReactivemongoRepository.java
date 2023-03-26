package com.abhisheksamuely.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.abhisheksamuely.reactive.beans.User;

@Repository
public interface ReactivemongoRepository extends ReactiveMongoRepository<User, String> {

}
