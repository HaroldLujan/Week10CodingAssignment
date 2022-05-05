CREATE DATABASE IF NOT EXISTS beers;

 USE beers;
 
 DROP TABLE IF EXISTS beers;
 
 CREATE TABLE beers(
 beer_id INT (5) NOT NULL AUTO_INCREMENT,
 brewery_name VARCHAR (50) NOT NULL,
 beer_name VARCHAR (50) NOT NULL,
 beer_style VARCHAR (50) NOT NULL,
 PRIMARY KEY(beer_id)
 );

 