package com.example.coffee.ctl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee.model.Good;
import com.example.coffee.svc.GoodService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/good")
@Slf4j
@AllArgsConstructor
public class GoodsController {
	
	private GoodService svc;
	
	
	@GetMapping("/{id}")
	public Mono<Good> getGood(@PathVariable String id) {
		return Mono.just(new Good(id, "Event " + id, 1000)).log();

	}
	
	@GetMapping("/list")
	public Flux<Good> getGoods() {
		return svc.allGoods();

	}
	
	@PostMapping
	public Flux<Good> saveGood(@RequestBody Good good) {
		return svc.saveGood(good);

	}
	
	@DeleteMapping("/{id}")
	public Flux deleteGood(@PathVariable String id) {
		return svc.deleteGood(id);
	}
	
	
	
	

}
