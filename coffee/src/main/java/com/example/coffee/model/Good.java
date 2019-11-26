package com.example.coffee.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Document
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Good implements Comparable<Good> {
	
	@Id
	private String id;
	@NotNull
	private String name;
	@NotNull
	private Integer price;
	
	public String getId(){
		if(this.id == null)
			this.id = UUID.randomUUID().toString();
		return id;
	}
	
	@Override
	public int compareTo(Good o) {
		return this.getName().compareTo(o.getName());
	}
}
