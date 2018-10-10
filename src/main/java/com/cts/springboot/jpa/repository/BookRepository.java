package com.cts.springboot.jpa.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.springboot.jpa.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	

}