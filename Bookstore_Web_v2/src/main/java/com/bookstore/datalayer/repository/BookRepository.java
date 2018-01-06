package com.bookstore.datalayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.datalayer.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findByName(String bookname);
	public Book findByBookId(Integer bookId);

}
