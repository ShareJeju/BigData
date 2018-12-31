package com.sist.seoulmap;

public class BookMaxVO {
	private int loan_count; //총합
	private String gu; //구
	private int year; //해당년도
	private String age; //해당나이대
	private String dea;  //대출권수
	
	public int getLoan_count() {
		return loan_count;
	}
	public void setLoan_count(int loan_count) {
		this.loan_count = loan_count;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
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
	
	
}
