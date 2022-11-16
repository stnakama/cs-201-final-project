package edu.usc.RestaurantReviews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reviewID")
    private Long reviewid;
	
    @Column(name="userID")
    private Long userid;
    
    @Column(name="restaurantID")
    private Long restaurantid;
    
    @Column(name="textReview")
    private String review;
    
    @Column(name="timePosted")
    private Long datetime;

    public Long getReviewID() {
		return reviewid;
	}
	
    public Long getUserID() {
		return userid;
	}

	public Long getRestID() {
		return restaurantid;
	}

	public String getTextRev() {
		return review;
	}
	
	public Long getTimePosted() {
		return datetime;
	}
	
	public void setReviewID(Long re) {
		reviewid = re;
	}

	public void setUserID(Long u) {
		userid = u;
	}
	
	public void setRestID(Long r) {
		restaurantid = r;
	}

	public void setTextRev(String rev) {
		review = rev;
	}

	public void setTimePosted(Long time) {
		datetime = time;
	}
}
