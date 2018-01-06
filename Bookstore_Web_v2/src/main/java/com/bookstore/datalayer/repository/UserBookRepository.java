package com.bookstore.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.datalayer.entity.UserBook;;

@Repository
public interface UserBookRepository extends CrudRepository<UserBook, Integer> {

}
