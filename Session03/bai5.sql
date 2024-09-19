create database sesssion03_bai5;

create table account(
id int auto_increment primary key,
username varchar(100) not null unique,
password varchar(255) not null ,
address varchar(255) not null,
status bit(1) not null
);

insert into account (username ,password ,address ,status)
values ("Hùng","123456","Nghệ An",1),
("Cường","654321","Hà Nội",1),
("Bách","135790","Hà Nội",1);

create table bill (
id int auto_increment primary key,
bill_type bit not null ,
acc_id int not null ,
created datetime not null ,
auth_date datetime not null,
foreign key (acc_id) references account(id)
);

insert into bill (bill_type,acc_id,created,auth_date)
values (0,1,'2022-02-11','2022-03-12'),
(0,1,'2023-10-05','2023-10-10'),
(1,3,'2022-02-01','2022-02-10'),
(1,2,'2024-05-15','2024-05-20');

create table product(
id int auto_increment primary key ,
name varchar(255) not null ,
created datetime not null ,
price double not null check (price > 0),
stock int not null ,
status bit(1) not null
);

insert into product(name,created,price,stock,status)
values ("Quần dài",'2022-03-12',1200,5,1),
("Áo dài",'2023-03-15',1500,8,1),
("Mũ cối",'1999-03-08',1600,10,1);

create table bill_detail(
id int auto_increment primary key,
bill_id int not null ,
product_id int not null ,
quantity int not null check (quantity > 0),
price double not null check (price > 0),
foreign key (bill_id) references bill(id),
foreign key (product_id) references product(id)
);

insert into bill_detail (bill_id,product_id,quantity,price)
values (1,1,3,1200),
(1,2,4,1500),
(2,1,1,1200),
(3,2,4,1500),
(4,3,7,1600);

-- Hiển thị tất cả account và sắp xếp theo user_name theo chiều giảm dần
select * from account
order by username desc ;

-- Hiển thị tất cả bill từ ngày 11/2/2023 đến 15/5/2023
select * from bill
where created between '2023-02-11' and '2023-05-15';

-- Hiển thị tất cả bill_detail theo bill_id
select * from bill_detail
order by bill_id;

-- Hiển thị tất cả product theo tên và sắp xếp theo chiều giảm dần
select * from product 
order by name desc ;
-- Hiển thị tất cả product có số lượng lớn hơn 10
select * from product
where stock > 10 ;

-- Hiển thị tất cả product còn hoạt động (dựa vào product_status)
select * from product
where status = 1 ;
