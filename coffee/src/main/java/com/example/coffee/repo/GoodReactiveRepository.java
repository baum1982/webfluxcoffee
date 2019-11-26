package com.example.coffee.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.coffee.model.Good;

public interface GoodReactiveRepository extends ReactiveCrudRepository<Good, String> {

}
