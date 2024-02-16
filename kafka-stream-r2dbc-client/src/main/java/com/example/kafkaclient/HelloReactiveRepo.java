package com.example.kafkaclient;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloReactiveRepo extends ReactiveCrudRepository<Hello, Long> {
}
