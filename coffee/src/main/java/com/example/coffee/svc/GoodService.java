package com.example.coffee.svc;

import org.springframework.stereotype.Service;

import com.example.coffee.model.Good;
import com.example.coffee.repo.GoodReactiveRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GoodService {
	
	private GoodReactiveRepository repo;
	
	public Flux<Good> allGoods() {
		return repo.findAll().sort();
	}
	
	public Flux<Good> saveGood(Good good) {
		return Flux.concat(repo.save(good), allGoods()).distinct().sort();
	}

	public Flux deleteGood(String id) {
		return Flux.concat(repo.deleteById(id), allGoods()).distinct().sort();
	}
}
