package com.abhisheksamuely.reactive.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;

import com.abhisheksamuely.reactive.beans.User;
import com.abhisheksamuely.reactive.repository.ReactiveRepository;
import com.abhisheksamuely.reactive.repository.ReactivemongoRepository;
import com.abhisheksamuely.reactive.services.ReactiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveServiceImpl implements ReactiveService {

	@Autowired
	private ReactiveRepository repository;
	
	@Autowired
	private ReactivemongoRepository mongoRepository;
		
	public List<User> getAllUsers(){
		return repository.getAllUsers();
	}

	@Override
	public Flux<User> getAllUsersReactive() {
		return repository.getAllUsersReactive();
	}
	
	

	@Override
	public Mono<User> findUserReactiveById(String id) {
		return repository.getAllUsersReactive().filter(user -> user.getId() == id).take(1).single();
	}
	
	@Override
	public Flux<User> getAllUsersFromMongoReactive() {
		return mongoRepository.findAll();
	}
	
	@Override
	public Mono<User> findByIdFromMongoReactive(String id) {
		return mongoRepository.findById(id);
	}
	
	@Override
	public Mono<User> updateUserFromMongoReactive(User user) {
		return mongoRepository.save(user);
	}
	
	@Override
	public Mono<User> insertUserFromMongoReactive(User user) {
		return mongoRepository.insert(user);
	}
	
	@Override
	public Mono<Void> deleteByIdFromMongoReactive(String id) {
		return mongoRepository.deleteById(id);
	}
	
	
}
