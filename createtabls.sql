/*	Created in Dbeaver for P1 project to structure tables
 
 *
 */

CREATE TABLE customer(
		username varchar(25), fname varchar(20), lname varchar(20),
		password varchar(32), balance int(4,2), is_admn BIT
);

CREATE TABLE credit_card(
		cc_niumber varchar(16), cc_name varchar(20), ccv int(3), 
		exp_date varchar(15), zip int(5), c_limit int(5,2),
		customer_username varchar(25)
);

CREATE TABLE menu(
		item_name varchar(50), cost int(5,2), protein varchar(20),
		is_substitutable BIT
);

CREATE TABLE Aorder(
		id int(4), menu_item varchar(50), comment text(50), is_favorite BIT,
		order_date varchar(15), customer_username varchar(25)
);

/* 		Functions in SQL to initialize records in the tables

*/

INSERT INTO customer(
		username, fname, lname, password, balance, is_admn)
VALUES

INSERT INTO credit_card(
		cc_niumber, cc_name, ccv, exp_date, zip, c_limit, customer_username);

VALUES

INSERT INTO menu(
		item_name , cost, protein, is_substitutable);
VALUES

INSERT INTO Aorder(
		id, menu_item, comment, is_favorite, order_date, customer_username);
VALUES

/*	Functions to change tables with Where or without Where.

*/
UPDATE customer
SET
WHERE		;

UPDATE credit_card
SET
WHERE		;

UPDATE menu
SET
WHERE		;

UPDATE Aorder
SET
WHERE		;