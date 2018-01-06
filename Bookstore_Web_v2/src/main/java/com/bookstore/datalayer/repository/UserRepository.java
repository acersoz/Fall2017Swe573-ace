package com.bookstore.datalayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.datalayer.entity.User;;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	// findBy �n eki �zel bir durumdur. findBy'dan sonra gelen attribute ismi ile sorgulama yapmay� sa�lar.
	User findByUserId(Integer userId);
	User findByUserNameAndPassword(String userName, String password);
	
}
