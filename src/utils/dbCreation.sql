/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 16.0 		*/
/*  Created On : 14-dic.-2022 3:01:42 a. m. 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Sequences for Autonumber Columns */

 

 

 

 

 

/* Drop Tables */

DROP TABLE IF EXISTS Accounts CASCADE
;

DROP TABLE IF EXISTS Products CASCADE
;

DROP TABLE IF EXISTS Purchases CASCADE
;

DROP TABLE IF EXISTS Users CASCADE
;

/* Create Tables */

CREATE TABLE Accounts
(
	id serial NOT NULL,
	user_id varchar(50) NOT NULL,
	points integer NULL,
	b_discount boolean NULL,
	b_extra_points boolean NULL,
	b_free_delivery boolean NULL
)
;

CREATE TABLE Products
(
	id serial NOT NULL,
	purchase_id serial NOT NULL,
	name varchar(50) NOT NULL,
	price integer NOT NULL,
	quantity integer NULL,
	image_path varchar(100) NULL,
	color varchar(50) NULL,
	brand varchar(50) NULL
)
;

CREATE TABLE Purchases
(
	id serial NOT NULL,
	account_id serial NOT NULL,
	total_price integer NULL,
	payment_method varchar(50) NULL
)
;

CREATE TABLE Users
(
	identification varchar(50) NOT NULL,
	email varchar(50) NULL,
	password varchar(50) NULL,
	name varchar(25) NULL,
	last_name varchar(25) NULL,
	birth_day varchar(50) NULL,
	address varchar(50) NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Accounts ADD CONSTRAINT PK_Account
	PRIMARY KEY (id)
;

ALTER TABLE Products ADD CONSTRAINT PK_Product
	PRIMARY KEY (id)
;

ALTER TABLE Purchases ADD CONSTRAINT PK_Purchase
	PRIMARY KEY (id)
;

ALTER TABLE Users ADD CONSTRAINT PK_User
	PRIMARY KEY (identification)
;

ALTER TABLE Users 
  ADD CONSTRAINT UK_email UNIQUE (email)
;

/* Create Foreign Key Constraints */

ALTER TABLE Accounts ADD CONSTRAINT FK_Account_User
	FOREIGN KEY (user_id) REFERENCES Users (identification) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Products ADD CONSTRAINT FK_Product_Purchase
	FOREIGN KEY (purchase_id) REFERENCES Purchases (id) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Purchases ADD CONSTRAINT FK_Purchase_Account
	FOREIGN KEY (account_id) REFERENCES Accounts (id) ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

 

 

 

 

 
