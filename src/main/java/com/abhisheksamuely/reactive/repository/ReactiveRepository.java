package com.abhisheksamuely.reactive.repository;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.abhisheksamuely.reactive.beans.User;

import reactor.core.publisher.Flux;

@Component
public class ReactiveRepository {

	
	private static void threadSleep(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers(){
		
	return IntStream.rangeClosed(1, 10)
			.peek(ReactiveRepository::threadSleep)
			.peek(i -> System.out.println("processing user: "+i))
			.mapToObj(i -> new User(String.valueOf(i), "user"+i))
			.collect(Collectors.toList());
	}

	public Flux<User> getAllUsersReactive() {
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("processing reactive user: "+i))
				.map(i -> new User(String.valueOf(i), "user"+i));
	}
}
