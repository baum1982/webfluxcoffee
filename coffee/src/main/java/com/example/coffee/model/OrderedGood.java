package com.example.coffee.model;

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
public class OrderedGood extends Good {
	private Integer count;
}
