package com.abhisheksamuely.reactive.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.abhisheksamuely.reactive.beans.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveService {
	List<User> getAllUsers();
	Flux<User> getAllUsersReactive();
	Mono<User> findUserReactiveById(String id);
	Flux<User> getAllUsersFromMongoReactive();
	Mono<User> findByIdFromMongoReactive(String id);
	Mono<User> updateUserFromMongoReactive(User user);
	Mono<User> insertUserFromMongoReactive(User user);
	Mono<Void> deleteByIdFromMongoReactive(String id);
}
