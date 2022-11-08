package edu.usc.RestaurantReviews;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Restaurant")
public class Restaurant {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="restaurantID")
        private Long id;
        
        @Column(name="name")
        private String name;
        
        @Column(name="address")
        private String address;
        
        
        @Column(name="cuisineType")
        private String cuisineType;


        // Getters and Setters
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getCuisineType() {
			return cuisineType;
		}


		public void setCuisineType(String cuisineType) {
			this.cuisineType = cuisineType;
		}
        
        

}
