package com.cts.springboot.jpa;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.entity.Subject;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.service.BookService;

@SpringBootApplication
public class Application {

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner run(BookRepository repository) {
		return (args) -> {

			saveSubjectDetails();

			List<Book> bookList = bookService.getAllBooks();
			System.out.println("book list Using findAll()::" + bookList.size());

			bookList.forEach(book -> System.out.println("BookId :" + book.getBookid() + "Book Price:: "
					+ book.getPrice() + " Book Titile::" + book.getTitle() + " Book Volume ::" + book.getVolume()
					+ " Subject Id ::" + book.getSubjectid().getSubjectid() + " Subject duration Hours ::"
					+ book.getSubjectid().getDurationInHours() + "subject Title ::"
					+ book.getSubjectid().getSubtitle()));

			Book bookone = bookService.getBookById(1004);
			System.out.println("Get Book details one book Using findOne::" + "Book Publish Date ::"
					+ bookone.getPublishdate() + "Book Price:: " + bookone.getPrice() + " Book Titile::"
					+ bookone.getTitle() + " Book Volume ::" + bookone.getVolume());

			Subject subject = bookService.getSubject(2003);
			System.out.println("Get Subject details for one subject Using findOne" + "Subject Duration Hours:: "
					+ subject.getDurationInHours() + "Subject Title::" + subject.getSubtitle());

		};
	}

	public Book saveBookDetails(Book book) {
		return bookService.saveBook(book);
	}

	public void saveSubjectDetails() {
		System.out.println("Subject Id : ");
		Book book2 = new Book(1002, "oracle", 200, 2, new Date());
		Book book3 = new Book(1003, "MySQL", 300, 3, new Date());
		Book book4 = new Book(1004, "css", 400, 4, new Date());
		Book book5 = new Book(1005, "java", 500, 8, new Date());

		Subject javaSubject = new Subject(2003, "J2ee", 10);
		Subject dbSubject = new Subject(2004, "Database", 5);

		book4.setSubjectid(javaSubject);
		book5.setSubjectid(javaSubject);

		book2.setSubjectid(dbSubject);
		book3.setSubjectid(dbSubject);

		Set<Book> bookset = new HashSet<Book>();
		Set<Book> bookset1 = new HashSet<Book>();

		System.out.println("....Before insert......." + bookset1.size());

		bookset1.add(book2);
		bookset1.add(book3);
		bookset.add(book4);
		bookset.add(book5);

		javaSubject.setBooks(bookset);
		dbSubject.setBooks(bookset1);

		System.out.println("....After insert......." + bookset1.size());

		bookService.saveSubject(javaSubject);
		bookService.saveSubject(dbSubject);
		//bookService.deleteBook(book2);
		System.out.println("The above Book is deleted........");
//		bookService.deleteSubject(dbSubject);
		System.out.println("The above Subject is deleted........");
	}

}
