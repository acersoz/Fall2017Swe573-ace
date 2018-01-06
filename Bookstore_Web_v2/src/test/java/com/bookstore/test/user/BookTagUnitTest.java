package com.bookstore.test.user;

import java.util.Iterator;
import java.util.List;

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
import com.bookstore.datalayer.entity.BookTag;
import com.bookstore.datalayer.entity.BookTagId;
import com.bookstore.datalayer.entity.Tag;
import com.bookstore.datalayer.entity.User;
import com.bookstore.datalayer.repository.BookRepository;
import com.bookstore.datalayer.repository.BookTagQueryRepository;
import com.bookstore.datalayer.repository.BookTagRepository;
import com.bookstore.datalayer.repository.TagRepository;
import com.bookstore.datalayer.repository.UserRepository;
import com.bookstore.weblayer.model.BookTagPair;

//import scala.annotation.meta.field;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositorySpringConfiguration.class)
public class BookTagUnitTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private BookTagRepository bookTagRepository;
	
	@Autowired
	private BookTagQueryRepository bookTagQueryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	public void createBookTags() {
		
		Book book = bookRepository.findByBookId(24);
		User user = userRepository.findByUserId(6);
		Tag tag  = tagRepository.findByTagId(26);
		//User user = userRepository.findByUserId(6);
		/*
		Tag tag1 = new Tag();
		tag1.setName("Science");
		
		Tag tag2 = new Tag();
		tag2.setName("Computer Science");*/
		/*
		tagRepository.save(tag1);
		tagRepository.save(tag2);*/
		
		BookTagId bookTagId1 = new BookTagId();
		bookTagId1.setUser(user.getUserId());
		bookTagId1.setBook(book.getBookId());
		bookTagId1.setTag(tag.getTagId());
		
		BookTag booktag1 = new BookTag();
		booktag1.setBookTagId(bookTagId1);
		
		/*
		BookTagId bookTagId2 = new BookTagId();
		bookTagId2.setUser(user.getUserId());
		bookTagId2.setBook(book.getBookId());
		bookTagId2.setTag(tag2.getTagId());
		
		BookTag booktag2 = new BookTag();
		booktag2.setBookTagId(bookTagId2);*/
		
		bookTagRepository.save(booktag1);
		//bookTagRepository.save(booktag2);
		
		Iterator<BookTag> it = bookTagRepository.findAll().iterator();
		
		while(it.hasNext()) {
			BookTag bookTag = it.next();
			bookTag.getBook();
			bookTag.getTag();
		}
		
		List<BookTagPair> results = bookTagQueryRepository.findBookTags(book.getBookId());
		
		Assert.assertTrue(results.size() > 0);
	}
	
}
