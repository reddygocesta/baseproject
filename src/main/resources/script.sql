create database contactrepository;
use contactrepository;

create table authority (
id int NOT NULL AUTO_INCREMENT,
name varchar(50),
primary key(id));

create table users (
id int NOT NULL AUTO_INCREMENT,,
first_name varchar(50),
family_name varchar(50),
e_mail varchar(50),
phone varchar(50),
language char(2),
id_picture int,
login varchar(50) NOT NULL UNIQUE,
password varchar(50),
burth_date Date,
enabled boolean,
primary key(id));

create table users_authority (
id int NOT NULL AUTO_INCREMENT,,
id_user BIGINT,
id_authority BIGINT,
primary key(id));

create table token (
series varchar(50) primary key,
value varchar(50),
date timestamp,
ip_address varchar(50),
user_agent varchar(200),
user_login varchar(50));

