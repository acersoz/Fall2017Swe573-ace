package com.bookstore.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.datalayer.entity.BookTag;

@Repository
public interface BookTagRepository extends CrudRepository<BookTag, Integer>{
	
}
