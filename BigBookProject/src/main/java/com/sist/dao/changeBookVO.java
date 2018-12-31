package com.sist.dao;

public class changeBookVO {

	private String location;
	private String genre;
	private int loan_count;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(int loan_count) {
		this.loan_count = loan_count;
	}
	
}
