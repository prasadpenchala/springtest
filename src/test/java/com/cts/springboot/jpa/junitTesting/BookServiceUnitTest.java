package com.cts.springboot.jpa.junitTesting;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.springboot.jpa.entity.Book;
import com.cts.springboot.jpa.repository.BookRepository;
import com.cts.springboot.jpa.service.BookService;

public class BookServiceUnitTest {

	@Mock
	private BookRepository daoMock;

	// injecting mock object into employee service
	@InjectMocks
	private BookService service1;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	//@Ignore
	@Test
	public void testGetAllBooks() {
		System.out.println("Inside testGetAllBooks method....");
		when(daoMock.findAll()).thenReturn(getTestData());
		assertNotNull(service1.getAllBooks());
		assertEquals(service1.getAllBooks().size(), 2);
	}

	//@Ignore
	@Test
	public void testSaveBook() {
		Book book = new Book();
		when(daoMock.save(org.mockito.Mockito.any(Book.class))).thenReturn(book);
		assertEquals(service1.saveBook(new Book()), book);
	}

	@Test
	public void testGetBookById() {
		System.out.println("Inside testGetBookById........... ");
		Book dummy = new Book();
		dummy.setBookid(1234);

		when(daoMock.findOne(org.mockito.Mockito.any(Long.class))).thenReturn(dummy);

		Book b = service1.getBookById(1001);
		System.out.println(b.getBookid());

		assertThat(service1.getBookById(1001), is(notNullValue()));
	}

	private List<Book> getTestData() {
		Book book = new Book();
		book.setBookid(1001);
		book.setTitle("Spring");
		book.setPrice(300);
		book.setVolume(3);
		book.setPublishdate(new Date());

		Book book1 = new Book();
		book1.setBookid(1002);
		book1.setTitle("Java");
		book1.setPrice(350);
		book1.setVolume(2);
		book1.setPublishdate(new Date());
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		books.add(book1);
		return books;
	}

}
