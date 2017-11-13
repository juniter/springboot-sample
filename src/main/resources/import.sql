-- create database and use it
DROP database IF EXISTS sample;
CREATE DATABASE sample;

USE sample;

-- check table
DROP TABLE
IF EXISTS city;

DROP TABLE
IF EXISTS hotel;

-- create table
CREATE TABLE city (
	id INT PRIMARY KEY auto_increment,
	NAME VARCHAR,
	state VARCHAR,
	country VARCHAR
);

CREATE TABLE hotel (
	city INT,
	NAME VARCHAR,
	address VARCHAR,
	-- zip 邮编
	zip VARCHAR
);

INSERT INTO city (NAME, state, country)
VALUES
	('San Francisco', 'CA', 'US'),
	('北京市', 'BeiJing', 'CN');

INSERT INTO hotel (city, NAME, address, zip)
VALUES
	(
		1,
		'Conrad Treasury Place',
		'William & George Streets',
		'4001'
	),
	(
		2,
		'Chengdu',
		'China & SiChuan Province',
		'637200'
	)