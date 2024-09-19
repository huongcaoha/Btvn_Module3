create database session03_bai2 ;

create table products(
pId int auto_increment primary key ,
pName varchar(255) not null ,
pPrice double not null 
);

insert into products (pId,pName,pPrice)
values (1,"May Giat" , 300),
(2,"Tu Lanh" , 500),
(3,"Dieu Hoa" , 700),
(4,"Quat",100),
(5,"Bep Dien",200),
(6,"Hut Mui",500);

create table customers (
cId int auto_increment primary key ,
cName varchar(255) not null ,
cAge int not null
);

insert into customers(cName,cAge)
values ("Minh Quan",10),
("Ngoc Oanh",20),
("Hong Ha",50);

insert into customers(cName,cAge)
values ("Cong Huong",30);

create table orders (
oId int auto_increment primary key ,
cId int not null,
oDate datetime not null,
oTotalPrice double not null ,
foreign key (cId) references customers(cId)
);

insert into orders (oId,cId,oDate,oTotalPrice)
values (1,1,'2006-3-21',150000),
(2,2,'2006-3-23',200000),
(3,1,'2006-3-16',170000);

insert into orders (oId,cId,oDate,oTotalPrice)
values (4,4,'2006-3-29',0);

create table orderDetail (
oId  int not null,
pId int not null,
odQuantity int not null,
foreign key (oId)  references  orders(oId),
foreign key (pId) references products(pId)
);

insert into orderDetail(oId,pId,odQuantity)
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

insert into orderDetail(oId,pId,odQuantity)
values (4,1,0);

-- Hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oId , oDate , oTotalPrice from orders ;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT customers.cName, COUNT(orderDetail.odQuantity) AS count 
FROM customers
LEFT JOIN orders ON customers.cId = orders.cId
LEFT JOIN orderDetail ON orders.oId = orderDetail.oId
GROUP BY customers.cName
HAVING count = 0;

select customers.cName from customers
left join orders on customers.cId = orders.cId
where orders.cId is null ;



-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng
-- xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY * pPrice)
Select orders.oId , orders.oDate , (products.pPrice * orderdetail.odQuantity) as totalMoney from orders
inner join orderDetail on orders.oId = orderdetail.oId
inner join products on orderdetail.pId = products.pId;
