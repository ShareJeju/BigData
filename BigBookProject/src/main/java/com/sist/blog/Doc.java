package com.sist.blog;

import javax.xml.bind.annotation.XmlElement;

// @XmlElement ==> title.get(i).text() ; 태그 안에 있는 값 가져오기
// @XmlAttribute ==> img.get(i).attr() ; 태그의 속성값 가져오기

// blog는 description변수만 필요
public class Doc {
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
	@XmlElement
	public void setNo(int no) {
		this.no = no;
	}
	public int getRanking() {
		return ranking;
	}
	@XmlElement
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getBookname() {
		return bookname;
	}
	@XmlElement
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthors() {
		return authors;
	}
	@XmlElement
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	@XmlElement
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublication_year() {
		return publication_year;
	}
	@XmlElement
	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}
	public String getLoan_count() {
		return loan_count;
	}
	@XmlElement
	public void setLoan_count(String loan_count) {
		this.loan_count = loan_count;
	}
	public String getBookImageURL() {
		return bookImageURL;
	}
	@XmlElement
	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}
}
