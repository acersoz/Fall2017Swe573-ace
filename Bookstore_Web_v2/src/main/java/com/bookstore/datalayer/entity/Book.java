package com.bookstore.datalayer.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bookstore.weblayer.model.BookTagPair;

@Entity
@Table(name = "book")
public class Book implements Serializable{
	
	private static final long serialVersionUID = 890245234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Integer bookId;
	
	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "published_date")
	private String publishedDate;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Transient
	private List<BookTagPair> bookTags;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BookTagPair> getBookTags() {
		return bookTags;
	}

	public void setBookTags(List<BookTagPair> bookTags) {
		this.bookTags = bookTags;
	}
}
