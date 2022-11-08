package edu.usc.restaurant.model;

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
        

        
        @Column(name="cusineType")
        private String cusineType;
        

}
