package com.cts.springboot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.entity.Subject;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.repository.SubjectRepository;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private SubjectRepository subjectRepo;

	public List<Book> getAllBooks() {
		
		return (List<Book>) bookRepo.findAll();
	}

	public List<Subject> getAllSubjects() {
		return (List<Subject>) subjectRepo.findAll();
	}

	public Book getBookById(long bookid) {
		return bookRepo.findOne(bookid);
	}

	public Subject getSubject(long subjectid) {
		return subjectRepo.findOne(subjectid);
	}

	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	public Subject saveSubject(Subject sub) {
		return subjectRepo.save(sub);
	}

	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}

	public void deleteSubject(Subject sub) {
		subjectRepo.delete(sub);
	}
}