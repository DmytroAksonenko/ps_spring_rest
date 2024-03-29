package com.aksonenko.spring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {

	private int id;

	private String name;
	
	private int author;

	private String genre;

	private int price;

	public Book(int id, String name, int author, String genre, int price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.price = price;
	}

}