package com.bookstore.test.user;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bookstore.datalayer.config.RepositorySpringConfiguration;
import com.bookstore.datalayer.entity.Book;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.entity.UserBook;
import com.bookstore.datalayer.repository.BookRepository;
import com.bookstore.datalayer.repository.UserBookRepository;
import com.bookstore.datalayer.repository.UserRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositorySpringConfiguration.class)
public class UserBookTest {
	
	@Autowired
	private UserBookRepository userBookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void insertUserBook() {
		
		User user = userRepository.findByUserId(6);		
		
		//Book book1 = new Book();
		//book1.setName("Book1");
		
		Book book1 = bookRepository.findByBookId(11);
		
		UserBook userBook1 = new UserBook();
		userBook1.setUser(user);
		userBook1.setBook(book1);
		
		///////////////////////////////////////////////
		
		
		//Book book2 = new Book();
		//book2.setName("Book2");
		
		Book book2 = bookRepository.findByBookId(12);
		
		UserBook userBook2 = new UserBook();
		userBook2.setUser(user);
		userBook2.setBook(book2);
		
		userBookRepository.save(userBook1);
		userBookRepository.save(userBook2);
		
		Book book = bookRepository.findByName("Deep Learning");
		
		Assert.assertNotNull(book.getBookId());
	}

}
