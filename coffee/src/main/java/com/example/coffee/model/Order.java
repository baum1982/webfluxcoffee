package com.example.coffee.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	
	@Id
	private String orderId;
	@NotNull
	private String name;
	@NotNull
	private Integer price;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String statusCode;
	
	private Date orderDate;
	
	private List<OrderedGood> orderedGoods;
	
}
