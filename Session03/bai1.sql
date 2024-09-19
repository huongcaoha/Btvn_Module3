create database session03_bai1 ;
-- bai 1
 create table size (
 id int auto_increment primary key ,
 name varchar(100) not null ,
 status bit default  1
 );
 
 insert into size (name)
 values ("X"),
("M"),
("L"),
("XL"),
("XXL");
 
 create table color (
 id int auto_increment primary key ,
 name varchar(100) not null,
 status bit default  1
 );
 
 insert into color (name)
 values ("Red"),
  ("Blue"),
   ("Green");
 
 create table product (
 id int auto_increment primary key ,
 name varchar(100) not null ,
 created datetime default current_timestamp
 );
 
 insert into product (name)
 values ("Quần dài"),
 ("Áo dài"),
 ("Mũ phớt");
 
 create table product_detail (
 id int auto_increment  primary key ,
 product_id int not null,
 color_id int not null,
 size_id int not null,
 price double not null check (price > 0) ,
 stock int not null check (stock >= 0 ),
 status bit default  1,
 foreign key (product_id) references product(id),
 foreign key (color_id) references color(id),
 foreign key  (size_id) references size(id)
 );
 
 insert into product_detail(product_id,color_id,size_id,price,stock,status)
 values (1,1,1,1200,5,1),
 (2,1,1,1500,2,1),
 (1,2,3,500,3,1),
 (1,2,3,1600,3,1),
 (3,1,4,1200,5,1),
 (3,3,5,1200,6,1),
 (2,3,5,2000,10,0);
 
 -- hiển thị thông tin chi tiết sản phẩm có price > 1200
 select * from product_detail
 where price > 1200 ;
 
 -- hiển thị tất cả thông tin các màu 
 select * from color ;
 
 -- hiên thị tất cả thông tin các size
 select * from size ;
 
 -- hiển thị tất cả các sản phẩm chi tiết có mã là 1
 select * from product_detail
 where id = 1 ;
 