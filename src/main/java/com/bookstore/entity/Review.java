package com.bookstore.entity;
// Generated 2021/12/04 14:16:32 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Review generated by hbm2java
 */
@Entity
@Table(name = "review", catalog = "bookstoredb")
@NamedQueries({
	@NamedQuery(name = "Review.listAll",query = "select r from Review r order by r.reviewTime desc"),
	@NamedQuery(name = "Review.countAll",query = "select count(*) from Review"),
	@NamedQuery(name = "Review.findByCustomerAndBook",query = "select r from Review r where r.customer.customerId =: customerId"
															+ " and r.book.bookId =: bookId"),
	@NamedQuery(name = "Review.mostFavoredBooks",query = "select r.book from Review r group by r.book having avg(r.rating)>=4 "
			+ "order by count(r.reviewId) desc,avg(r.rating) desc"),
})
public class Review implements java.io.Serializable {

	private Integer reviewId;
	private Book book;
	private Customer customer;
	private int rating;
	private String headline;
	private String comment;
	
	private Date reviewTime;

	public Review() {
	}

	public Review(Book book, Customer customer, int rating, String headline, String comment, Date reviewTime) {
		this.book = book;
		this.customer = customer;
		this.rating = rating;
		this.headline = headline;
		this.comment = comment;
		this.reviewTime = reviewTime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "review_id", unique = true, nullable = false)
	public Integer getReviewId() {
		return this.reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id", nullable = false)
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "rating", nullable = false)
	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Column(name = "headline", nullable = false, length = 128)
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "comment", nullable = false, length = 100)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "review_time", nullable = false, length = 19)
	public Date getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	
	@Transient
	public String getStars() {
		String result="";
		int numon=(int)rating;
		for (int i = 0; i < numon; i++) {
			if (i==4) {
				result+="on";
				return result;
			}else {
				result+="on,";
			}
		
		}
		int next=numon+1;
		
		for (int i =next; i <=5; i++) {
			if(i==5) {
				result+="off";
			}else {
				result+="off,";
			}
			
		}
		//this.star=result;
		return result;
		

}
	
	
}
