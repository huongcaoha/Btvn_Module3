create database session02;

create table category (
id int auto_increment primary key ,
name varchar(100) not null unique ,
status bit default 1
);

insert into category (name)
values ("cate 1"),("cate 2"),("cate 3"),("cate 4"),("cate 5");

create table product (
id  int auto_increment primary key ,
name varchar(100) not null unique ,
price float check (price > 0),
sale_price float check (sale_price > 0) ,
image varchar(255) default "image",
category_id int not null ,
foreign key (category_id) references category(id)
);

insert into product(name,price , sale_price ,category_id)
values ("product 1" , 15000 , 3000 , 1),
("product 2" , 20000 , 4000 , 2),
("product 3" , 25000 , 5000 , 3),
("product 4" , 30000 , 6000 , 4),
("product 5" , 35000 , 7000 , 5);

create table account(
id int auto_increment  primary key ,
email varchar(100) not null unique ,
password varchar(100) not null ,
fullName varchar(100) 
);

insert into account (email , password , fullName)
values ("huongcaoha","123456789", "huong cao ha"),
("huongcaoha123","123456789", "huong cao ha 123"),
("huongcaoha1994","123456789", "huong cao ha 1994"),
("huongcaoha94","123456789", "huong cao ha 94"),
("huongcaoha789","123456789", "huong cao ha 789");

create table orders (
id int auto_increment primary key ,
id_account int not null ,
ship_address varchar(255) not null ,
phone varchar(11) not null ,
status tinyint default 0 ,
create_at datetime default (now()),
foreign key (id_account) references account(id)
);

insert into orders (id_account , ship_address , phone )
values (1,"Hoai Duc" ,  "0367508795"),
(2,"Dong My" ,  "0388795605"),
(3,"Ha Noi" ,  "0979671992"),
(4,"Thai Binh" ,  "0123456789"),
(5,"Tuyen Quang" ,  "0333333333");

create table order_detail (
id_order int not null ,
id_product int not null ,
quantity int not null check (quantity > 0) ,
price float not null check (price > 0),
foreign key (id_order) references orders(id),
foreign key (id_product) references product(id)
);

insert into order_detail (id_order , id_product , quantity ,price)
values (1,6,1,10000),
(2,7,2,20000),
(3,8,3,30000),
(4,9,4,40000),
(5,10,5,50000);

-- 2 ) update name product id = 6

update product 
set name = "sản phẩm hot trend 2024"
where id = 6 ;

-- 3 ) update price product id = 6 discount 10%

update product
set price = price * 0.9
where id = 6 ;

-- 4 ) xóa sản phẩm có id = 1 
delete from product
where id = 1 ;

-- 5 ) Lấy id,name,price,sale_price,image của tất cả sản phẩm trong bảng product 
select product.id , product.name , product.price , product.image from product ;

-- 6 )  Lấy ra danh sách sản phẩm có giá > 100
select * from product
where price > 100 ;

--  Lấy về danh sách sản phẩm, id,name,price, tên danh mục
select product.id , product.name , product.price ,category.name as categoryName
from product
inner join category on product.category_id = category.id;

-- Lấy về danh sách danh mục, id danh mục,tên danh mục, số lượng sản phẩm (count) 
select category.id,category.name,count(product.category_id) 
from category
inner join product on category.id = product.category_id
group by product.category_id;
 
-- Lấy về danh sách đơn hàng , id đơn hàng, tên khách hàng, địa chỉ ship phone,status 
 
 select orders.id ,account.fullName ,orders.ship_address ,orders.phone ,orders.status
 from orders
 inner join account on orders.id_account = account.id ;
