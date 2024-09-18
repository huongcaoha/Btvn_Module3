create database session2_bai6;
create table users (
id int auto_increment primary key ,
fullName varchar(100) not null ,
email varchar(255) not null ,
password varchar(255) not null ,
phone varchar(11) not null ,
permission bit not null ,
status bit not null  
);

create table address (
id int auto_increment primary key ,
user_id int not null references users(id),
recelveAddress varchar(100) not null ,
recelveName varchar(100) not null,
recelvePhone varchar(11) not null ,
isDefault bit not null
);

create table catalog (
id int auto_increment primary key ,
name varchar(100) not null ,
status bit not null
);

create table product (
id int auto_increment primary key ,
name varchar(100) not null ,
price double not null check (price > 0),
stock int not null check (stock >= 0),
catalog_id int not null references catalog(id),
status bit not null
);

create table wishlist (
user_id int not null references user(id),
product_id int not null references product(id)
);

create table shopping_cart(
id int auto_increment primary key ,
user_id int not null references user(id),
product_id int not null references product(id),
quantity int not null check (quantity > 0) 
);

create table orders (
id int auto_increment primary key ,
orderAt datetime default current_timestamp ,
totals double not null check(totals > 0),
user_id int not null references user(id),
status bit not  null
);

create table order_detail (
id int auto_increment primary key ,
order_id int not null references orders(id),
product_id int not null references product(id),
quantity int not null check (quantity > 0),
unit_price double not null
);
