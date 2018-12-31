package com.sist.dao;

public class BookyjVO {
	private String no;
	private String ranking;
	private String bookname;
	private String authors;
	private String publisher;
	private String publication_year;
	private String loan_count;
	private String bookImageURL;
	
	private String location; // 지역
	private String genre; // 책주제(책장르)
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
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
	public String getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(String publication_year) {
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
