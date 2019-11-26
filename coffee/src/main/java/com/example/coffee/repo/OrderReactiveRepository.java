package com.example.coffee.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.coffee.model.Order;

public interface OrderReactiveRepository extends ReactiveCrudRepository<Order, String> {

}
