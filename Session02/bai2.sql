create database QuanLyBanHang ;
create table products(
pId int auto_increment primary key ,
pName varchar(255) not null ,
pPrice double not null 
);

create table customers (
cId int auto_increment primary key ,
cName varchar(255) not null ,
cAge int not null
);

create table orders (
oId int auto_increment primary key ,
cId int not null references customers(cId),
oDate datetime default current_timestamp,
oTotalPrice double not null 
);

create table orderDetail (
oId  int not null  references  orders(oId),
pId int not null references products(pId),
odQuantity int not null
);