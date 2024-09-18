create database session02 ;
-- bai 1
 create table size (
 id int auto_increment primary key ,
 name varchar(100) not null ,
 status bit not null
 );
 
 create table color (
 id int auto_increment primary key ,
 name varchar(100) not null,
 status bit not null
 );
 
 create table product (
 id int auto_increment primary key ,
 name varchar(100) not null ,
 created datetime default current_timestamp
 );
 
 create table product_detail (
 id int auto_increment  primary key ,
 product_id int references product(id),
 color_id int references color(id),
 size_id int references size(id),
 price double not null ,
 stock int not null ,
 status bit not null
 );