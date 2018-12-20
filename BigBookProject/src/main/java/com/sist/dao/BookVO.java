package com.sist.dao;

public class BookVO {
	private int no;
	private int ranking;
	private String bookname;
	private String authors;
	private String publisher;
	private int publication_year;
	private String loan_count;
	private String bookImageURL;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}
	public String getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(String loan_count) {
		this.loan_count = loan_count;
	}
	public String getBookImageURL() {
		return bookImageURL;
	}
	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}
	
	
}
