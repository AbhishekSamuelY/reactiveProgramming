package com.abhisheksamuely.reactive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksamuely.reactive.beans.User;
import com.abhisheksamuely.reactive.services.ReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class ReactiveController {
	
	@Autowired
	ReactiveService service;
	
	@GetMapping
	public List<User> getUsers() {
		return service.getAllUsers();
	}
	
	@GetMapping(value = "/reactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsersReactive() {
		return service.getAllUsersReactive();
	}
	
	@GetMapping(value = "/reactive/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<User> findUserReactiveById(@PathVariable String id) {
		return service.findUserReactiveById(id);
	}
	
	@GetMapping(value = "/reactive/mongo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getAllUsersReactiveByMongo() {
		return service.getAllUsersFromMongoReactive();
	}
	
	@GetMapping(value = "/reactive/mongo/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<User> findUserByIdReactiveMongo(@PathVariable String id) {
		return service.findByIdFromMongoReactive(id);
	}
	
	@PostMapping(value = "/reactive/mongo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<User> insertUserReactiveMongo(@RequestBody User user) {
		return service.insertUserFromMongoReactive(user);
	}
	
	@PutMapping(value = "/reactive/mongo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<User> updateUserReactiveMongo(@RequestBody User user) {
		return service.updateUserFromMongoReactive(user);
	}

	@DeleteMapping(value = "/reactive/mongo/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Void> deleteUserReactiveMongo(@PathVariable String id) {
		return service.deleteByIdFromMongoReactive(id);
	}
}
