USE RestaurantReviewsDatabase;

DROP TABLE IF EXISTS Review;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Restaurant;


CREATE TABLE User ( 
userID int not null auto_increment, 
username varchar(50) not null unique, 
password varchar(64) not null,
token varchar(255),
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
    username varchar(50) not null,
    restaurantID int not null,
    restaurantName varchar(50) not null,
    textReview varchar(1000) not null,
    timePosted DATETIME not null,
    PRIMARY KEY(reviewID),
    FOREIGN KEY(userID) REFERENCES User(userID),
	FOREIGN KEY(restaurantID) REFERENCES Restaurant(restaurantID)
);

INSERT INTO User (username, password) VALUES ('Alice', 'alicepassword');
INSERT INTO User (username, password) VALUES ('Bob', 'bobpassword');
INSERT INTO User (username, password) VALUES ('Charles', 'charlespassword');

INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Rock & Reilly\'s', '3201 S Hoover St, Los Angeles, CA 90089', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Stout Burgers & Beers', '835 W Jefferson Blvd Suite 1710, Los Angeles, CA 90089', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Greenleaf Kitchen & Cocktails', '929 W Jefferson Blvd #1650, Los Angeles, CA 90089', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Honeybird', '3201 S Hoover St #1835, Los Angeles, CA 90089', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Study Hall', '2827 S Hoover St, Los Angeles, CA 90007', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Ono Hawaiian BBQ', '3010 S Figueroa St, Los Angeles, CA 90007', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Carl\'s Jr.', '2912 S Figueroa St, Los Angeles, CA 90007', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Jack in the Box', '2921 S Figueroa St, Los Angeles, CA 90007', 'American');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Five Guys', '530 W 27th St Suite 101, Los Angeles, CA 90007', 'American');

INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Il Giardino Ristorante', '3201 S Hoover St #1850, Los Angeles, CA 90089', 'Italian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Monarca Pasta & Grill', '2703 S Vermont Ave, Los Angeles, CA 90007', 'Italian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Rosso Oros Pizzeria', '3522 S Figueroa St, Los Angeles, CA 90007', 'Italian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Pasta Roma', '2827 S Figueroa St, Los Angeles, CA 90007', 'Italian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Viztango Cafe', '3017 S Figueroa St, Los Angeles, CA 90007', 'Italian');


INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Chipotle Mexican Grill', '3748 S Figueroa St, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('City Tacos', '835 W Jefferson Blvd Ste 1735, Los Angeles, CA 90089', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('La Catrina Restaurant', '1564 W Adams Blvd, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Tacos El Unico', '1375 W Adams Blvd, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('La Barca', '2414 S Vermont Ave, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('El Huero Drive Thru', '3000 S Figueroa St, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Holbox', '3655 S Grand Ave #C9, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Chichen Itza', '3655 S Grand Ave #C6, Los Angeles, CA 90007', 'Mexican');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Taqueria Vista Hermosa', '3655 S Grand Ave #C5, Los Angeles, CA 90007', 'Mexican');


INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Chinese Street Food', '3201 S Hoover St #1807, Los Angeles, CA 90007', 'Chinese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Panda Express', '2828 S Figueroa St, Los Angeles, CA 90007', 'Chinese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Northern Cafe', '2904 S Figueroa St, Los Angeles, CA 90007', 'Chinese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Chinatown Express', '2811 S Figueroa St, Los Angeles, CA 90007', 'Chinese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Very Good Chinese', '2520 S Figueroa St, Los Angeles, CA 90007', 'Chinese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Qin West Noodle', '2520 S Figueroa St, Los Angeles, CA 90007', 'Chinese');

INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Manas Indian Cuisine', '2823 S Vermont Ave, Los Angeles, CA 90007', 'Indian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Himalayan House', '1277 W Jefferson Blvd, Los Angeles, CA 90007', 'Indian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('23rd Street Cafe Indian Restaurant', '936 W 23rd St, Los Angeles, CA 90007', 'Indian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('House of Curry', '1888 S Western Ave, Los Angeles, CA 90006', 'Indian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Mr. Masala', '949 S Figueroa St, Los Angeles, CA 90015', 'Indian');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Bombay Beach', '1338 W 7th St, Los Angeles, CA 90017', 'Indian');

INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Yoshinoya', '3021 S Figueroa St, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Soy Japanese Grill and Roll', '2813 S Figueroa St, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Ramen Kenjo', '929 W Jefferson Blvd, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('SUPAMU', '929 W Jefferson Blvd, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Momota Ramen House', '3019 S Figueroa St, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('California Sushi & Teriyaki', '2518 S Figueroa St, Los Angeles, CA 90007', 'Japanese');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Ebaes', '2314 S Union Ave, Los Angeles, CA 90007', 'Japanese');

INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Cafe Dulce', '3096 McClintock Ave Ste 1420, Los Angeles, CA 90007', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Starbucks', '3201 S Hoover St, Los Angeles, CA 90089', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Ministry of Coffee', '844 W 32nd St, Los Angeles, CA 90007', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Dunkin\'', '3335 S Figueroa St, Los Angeles, CA 90007', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Factory Tea Bar', '2700 S Figueroa St Suite #105, Los Angeles, CA 90007', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Pasteles', '2821 S Vermont Ave, Los Angeles, CA 90007', 'Coffee');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Cacique Espresso Catering', '2703 S Hoover St, Los Angeles, CA 90007', 'Coffee');


INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Insomnia Cookies', '929 W Jefferson Blvd #1620, Los Angeles, CA 90089', 'Other');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('La Michoacana Cold Delights', '2807 Vermont Ave, Los Angeles, CA 90007', 'Other');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('Baskin-Robbins', '1375 W Adams Blvd, Los Angeles, CA 90007', 'Other');
INSERT INTO Restaurant (name, address, cuisineType) VALUES ('CAVA', '3201 S Hoover St Suite 1840, Los Angeles, CA 90089', 'Other');



INSERT INTO Review (userID, username, restaurantID, textReview, timePosted) VALUES (1, 'Alice', 2, 'Stout Burgers & Beers', 'I love the burgers at Stout\'s! Would go again!', '2022-11-07');
INSERT INTO Review (userID, username, restaurantID, textReview, timePosted) VALUES (1, 'Alice', 3, 'Greenleaf Kitchen & Cocktails', 'Greenleaf was okay. The staff was quite rude to me!', '2022-11-04');
INSERT INTO Review (userID, username, restaurantID, textReview, timePosted) VALUES (2, 'Bob', 11, 'Monarca Pasta & Grill', 'The pasta here is amazing!', '2022-11-08');
INSERT INTO Review (userID, username, restaurantID, textReview, timePosted) VALUES (3, 'Charles', 17, 'La Catrina Restaurant', 'I\'m never eating here again. The food is absolutely horrible.', '2022-11-08');


SELECT * FROM User;
