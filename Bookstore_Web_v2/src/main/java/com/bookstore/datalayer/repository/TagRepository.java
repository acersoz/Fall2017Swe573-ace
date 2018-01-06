package com.bookstore.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.datalayer.entity.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer>{
	public Tag findByName(String tagName);
	public Tag findByTagId(Integer tagId);
}
