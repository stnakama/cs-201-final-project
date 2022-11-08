package edu.usc.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="restaurant_ID")
            private Long id;
        
        @Column(name="Name")
        private String name;

}
