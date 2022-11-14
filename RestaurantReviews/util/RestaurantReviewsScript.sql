USE RestaurantReviewsDatabase;

DROP TABLE IF EXISTS Review;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Restaurant;


CREATE TABLE User ( 
	userID int not null auto_increment, 
    username varchar(50) not null unique, 
    password varchar(64) not null,
    token varchar(255) not null,
    PRIMARY KEY(userID)
);

CREATE TABLE Restaurant (
	restaurantID int not null auto_increment,
    name varchar(50) not null,
    address varchar(150),
    cuisineType enum('American', 'Italian', 'Mexican', 'Chinese', 'Indian', 'Japanese', 'Coffee', 'Other'),
    # cuisineType varchar(150),
    PRIMARY KEY(restaurantID)
);

CREATE TABLE Review (
	reviewID int not null auto_increment,
    userID int not null,
    restaurantID int not null,
    textReview varchar(1000) not null,
    timePosted DATETIME not null,
    PRIMARY KEY(reviewID),
    FOREIGN KEY(userID) REFERENCES User(userID),
	FOREIGN KEY(restaurantID) REFERENCES Restaurant(restaurantID)
);

INSERT INTO User (username, password) VALUES ('user1', 'password1');
INSERT INTO Restaurant (name, address, cuisineType)VALUES ('SampleRestaurant1', 'SampleAddress1', 'American');
INSERT INTO Review (userID, restaurantID, textReview, timePosted) VALUES (1, 1, 'Sample Review from User 1 about Restaurant 1', '2022-11-07');

SELECT * FROM User;
