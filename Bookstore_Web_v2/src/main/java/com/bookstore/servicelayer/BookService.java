package com.bookstore.servicelayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.datalayer.entity.Book;
import com.bookstore.datalayer.entity.BookTag;
import com.bookstore.datalayer.entity.BookTagId;
import com.bookstore.datalayer.entity.Tag;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.repository.BookRepository;
import com.bookstore.datalayer.repository.BookTagQueryRepository;
import com.bookstore.datalayer.repository.BookTagRepository;
import com.bookstore.datalayer.repository.TagRepository;
import com.bookstore.datalayer.repository.UserRepository;
import com.bookstore.weblayer.model.AddBookTag;
import com.bookstore.weblayer.model.BookTagPair;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookTagQueryRepository bookTagQueryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private BookTagRepository bookTagRepository;
	
	@Transactional
	public Boolean save(Book book) {
		
		bookRepository.save(book);
		return true;
	}
	
	@Transactional
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<Book>();
		
		Iterator<Book> iterator = bookRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			Book book = iterator.next();
			books.add(book);
		}
		
		return books;
	}
	
	@Transactional
	public Book findBook(Integer bookId) {
		
		Book book = bookRepository.findOne(bookId);
		List<BookTagPair> bookTags = bookTagQueryRepository.findBookTags(bookId);
		book.setBookTags(bookTags);
		
		return book;
	}
	
	@Transactional
	public boolean addBookTag(Integer bookId, Integer tagId, Integer userId) {
		/*
		Book book = bookRepository.findByBookId(bookId);
		User user = userRepository.findByUserId(userId);
		Tag tag  = tagRepository.findByTagId(tagId);*/
		
		BookTagId bookTagId1 = new BookTagId();
		/*bookTagId1.setUser(user.getUserId());
		bookTagId1.setBook(book.getBookId());
		bookTagId1.setTag(tag.getTagId());*/
		bookTagId1.setUser(userId);
		bookTagId1.setBook(bookId);
		bookTagId1.setTag(tagId);
		
		BookTag booktag1 = new BookTag();
		booktag1.setBookTagId(bookTagId1);
		
		bookTagRepository.save(booktag1);
		
		return true;
	}
	
}
