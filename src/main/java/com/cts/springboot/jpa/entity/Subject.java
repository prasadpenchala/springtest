package com.cts.springboot.jpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject555")
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "subjectid")
	private Long  subjectid;
	@Column(name = "subtitle")
	private String subtitle;
	@Column(name = "durationInHours")
	private int durationInHours;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "subjectid", fetch = FetchType.EAGER)
	private Set<Book> books = new HashSet<Book>();

public Subject(long subjectid, String subtitle, int durationInHours) {
		super();
		this.subjectid =subjectid;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
	}

	public Subject() {

	}

	
	public long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(long subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void display() {
	System.out.println("subjectid=" + subjectid + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours);
	}

	
}