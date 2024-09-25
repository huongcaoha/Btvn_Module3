create database QUANLYBANHANG ;
use QUANLYBANHANG ;

-- ************************* bài 1 ***************************
create table CUSTOMERS (
customer_id varchar(4) primary key not null ,
name varchar(100) not null unique ,
email varchar(100) not null ,
phone varchar(25) not null ,
address varchar(255) not null
);

create table ORDERS (
order_id varchar(4) primary key not null ,
customer_id varchar(4) not null ,
order_date date not null ,
total_amount double not null,
foreign key (customer_id) references CUSTOMERS(customer_id)
);

create table PRODUCTS (
product_id varchar(4) primary key not null ,
name varchar(255) not null ,
description text ,
price double not null ,
status bit(1) not null 
);

create table ORDERS_DETAILS (
order_id varchar(4) not null,
product_id varchar(4) not null ,
primary key (order_id , product_id),
quantity int(11) not null ,
price double not null,
foreign key (order_id) references ORDERS(order_id),
foreign key (product_id) references PRODUCTS(product_id)
);

-- ************************* bài 2 ***************************
insert into CUSTOMERS (customer_id , name , email , phone ,address)
values ("C001", "Nguyễn Trung Mạnh", "manhnt@gmail.com","984756322", "Cầu Giấy , Hà Nội"),
("C002", "Hồ Hải Nam", "namhh@gmail.com","984875926", "Ba Vì , Hà Nội"),
("C003", "Tô Ngọc Vũ", "vutn@gmail.com","904725784", "Mộc Châu , Sơn La"),
("C004", "Phạm Ngọc Anh", "anhpn@gmail.com","984635365", "Vinh , Nghệ An"),
("C005", "Trương minh Cường", "cuongtm@gmail.com","989735624", "Hai Bà Trưng , Hà Nội");

insert into PRODUCTS (product_id , name , description , price , status)
values ("P001" , "Iphone 13 ProMax", "Bản 512GB , xanh lá" , 22999999,1),
("P002" , "Dell Vostro V3510", "Core i5,RAM 8GB" , 14999999,1),
("P003" , "Macbook Pro M2", "8CPU 10GPU 8GB 256GB" , 28999999,1),
("P004" , "Apple Watch Ultra", "Titanium Alpine Loop Small" , 18999999,1),
("P005" , "Airpods 2 2022", "Spatial Audio" , 4090000,1);
    