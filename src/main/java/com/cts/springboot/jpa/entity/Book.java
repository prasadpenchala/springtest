package com.cts.springboot.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book123")
public class Book implements Serializable {
	@Id
	@Column(name = "bookid")
	private Long  bookid;
	private String title;
	private double price;
	private int volume;
	private Date publishdate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectid")
	private Subject subjectid;

	public Book() {

	}

	public Book(long bookid, String title, double price, int volume, Date publishdate) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.price = price;
		this.volume = volume;
		this.publishdate = publishdate;

	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date date) {
		this.publishdate = date;
	}

	public Subject getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Subject subjectid) {
		this.subjectid = subjectid;
	}

	public void show() {
		System.out.println("bookid=" + bookid + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishdate=" + publishdate );
	}

}
