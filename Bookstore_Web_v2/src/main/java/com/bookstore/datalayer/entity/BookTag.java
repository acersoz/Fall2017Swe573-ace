package com.bookstore.datalayer.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book_tag")
public class BookTag implements Serializable{
	
	private static final long serialVersionUID = 890245234L;
	
	@EmbeddedId
	private BookTagId bookTagId;
	
	@OneToOne
	@JoinColumn(name="book_id", insertable=false, updatable=false)
	private Book book;
	
	@OneToOne
	@JoinColumn(name="tag_id", insertable=false, updatable=false)
	private Tag tag;

	public BookTagId getBookTagId() {
		return bookTagId;
	}

	public void setBookTagId(BookTagId bookTagId) {
		this.bookTagId = bookTagId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}
