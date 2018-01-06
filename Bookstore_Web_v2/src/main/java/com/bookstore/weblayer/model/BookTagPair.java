package com.bookstore.weblayer.model;

import java.io.Serializable;

public class BookTagPair implements Serializable {

	private static final long serialVersionUID = 3523416860198168013L;
	private String name;
	private Long count;
	
	public BookTagPair(String name, Long count) {
		this.setName(name);
		this.setCount(count);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
