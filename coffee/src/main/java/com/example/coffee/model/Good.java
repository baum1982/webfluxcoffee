package com.example.coffee.model;

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
public class Good {
	
	@Id
	private String goodId;
	@NotNull
	private String name;
	@NotNull
	private Integer price;
	
	

}
