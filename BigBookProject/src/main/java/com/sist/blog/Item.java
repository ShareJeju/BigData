package com.sist.blog;
// @XmlElement ==> title.get(i).text() ; 태그 안에 있는 값 가져오기
// @XmlAttribute ==> img.get(i).attr() ; 태그의 속성값 가져오기
import com.sun.xml.txw2.annotation.XmlElement;
// blog는 description변수만 필요
public class Item {
	private String itemId;
	private String title;
	private String description;
	private String pubDate;
	private String coverSmallUrl;
	private String coverLargeUrl;
	private String categoryId;
	private String categoryName;
	private String publisher;
	private int rank;
	private String customerReviewRank;
	private int reviewCount;
	private String author;
	private String link;
	public String getItemId() {
		return itemId;
	}
	@XmlElement
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPubDate() {
		return pubDate;
	}
	@XmlElement
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getCoverSmallUrl() {
		return coverSmallUrl;
	}
	@XmlElement
	public void setCoverSmallUrl(String coverSmallUrl) {
		this.coverSmallUrl = coverSmallUrl;
	}
	public String getCoverLargeUrl() {
		return coverLargeUrl;
	}
	@XmlElement
	public void setCoverLargeUrl(String coverLargeUrl) {
		this.coverLargeUrl = coverLargeUrl;
	}
	public String getCategoryId() {
		return categoryId;
	}
	@XmlElement
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	@XmlElement
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getPublisher() {
		return publisher;
	}
	@XmlElement
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getRank() {
		return rank;
	}
	@XmlElement
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getCustomerReviewRank() {
		return customerReviewRank;
	}
	@XmlElement
	public void setCustomerReviewRank(String customerReviewRank) {
		this.customerReviewRank = customerReviewRank;
	}
	public int getReviewCount() {
		return reviewCount;
	}
	@XmlElement
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	public String getAuthor() {
		return author;
	}
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	@XmlElement
	public void setLink(String link) {
		this.link = link;
	}

}
