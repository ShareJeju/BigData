package com.sist.seoulmap;

public class BookjiVO {
	private String no;
	private String ranking;
	private String bookname;
	private String authors;
	private String publisher;
	private String publication_year;
	private int loan_count;
	private String bookImageURL;
	private String gu;
	private int year;
	private String age;
	private String dea;
	
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDea() {
		return dea;
	}
	public void setDea(String dea) {
		this.dea = dea;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
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
	
	public int getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(int loan_count) {
		this.loan_count = loan_count;
	}
	public String getBookImageURL() {
		return bookImageURL;
	}
	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	
		
	
}
