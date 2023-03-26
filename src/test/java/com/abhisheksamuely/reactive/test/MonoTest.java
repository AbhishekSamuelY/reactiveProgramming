package com.abhisheksamuely.reactive.test;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {
	
	@Test
	void testMono() {
		Mono<String> monoString = Mono.just("Hello World!").log();
		monoString.subscribe(System.out::println);
	}
	
	@Test
	void testFlux() {
		Flux<String> monoString = Flux.just("alpha","bravo","charlie","delta")
				.concatWithValues("echo");
		monoString.subscribe(System.out::println);
	}
	
	//@Test
	void testMonoError() {
		Mono<?> monoString = Mono.just("Hello World!")
				.then(Mono.error(new RuntimeException("runtime exception occured")))
				.log();
		monoString.subscribe(System.out::println,e -> System.out.println(e.getMessage()));
	}
	
	//@Test
	void testFluxError() {
		Flux<String> monoString = Flux.just("alpha","bravo","charlie","delta")
				.concatWithValues("echo")
				.concatWith(Flux.error(new RuntimeException("runtime exception occured")))
				.concatWithValues("echo")
				.log();
		monoString.subscribe(System.out::println,e -> System.out.println(e.getMessage()));
	}

}
