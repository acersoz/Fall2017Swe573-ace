package com.bookstore.datalayer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bookstore.weblayer.model.BookTagPair;

@Repository
public class BookTagQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<BookTagPair> findBookTags(Integer bookId) {

		String jpql = "SELECT NEW com.bookstore.weblayer.model.BookTagPair(bt.tag.name, COUNT(bt)) FROM BookTag AS bt WHERE bt.book.bookId =:bookId GROUP BY bt.tag.tagId ORDER BY bt.tag.tagId ASC";
		
		List<BookTagPair> results = entityManager.createQuery(jpql, BookTagPair.class).setParameter("bookId", bookId).getResultList();
		
		return results;
	}
}
