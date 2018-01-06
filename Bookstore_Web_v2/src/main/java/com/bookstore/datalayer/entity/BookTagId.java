package com.bookstore.datalayer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookTagId implements Serializable {

	private static final long serialVersionUID = 4705650637392856872L;

	@Column(name = "user_id")
	private Integer user;
	
	@Column(name = "book_id")
	private Integer book;
	
	@Column(name = "tag_id")
	private Integer tag;

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public Integer getBook() {
		return book;
	}

	public void setBook(Integer book) {
		this.book = book;
	}

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	} 
	
}
