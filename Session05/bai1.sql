create database session05_bai1 ;

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

-- Tạo view hiển thị tất cả customer
create view viewCustomer as
select * from customers ;

-- Tạo view hiển thị tất cả order có oTotalPrice trên 150000
create view orderPriceGt150000 as
select * from orders 
where oTotalPrice > 150000 ;

-- Đánh index cho bảng customer ở cột cName
create index index_customer_name on customers(cName);

-- Đánh index cho bảng product ở cột pName
create index index_product_name on products(pName);

-- Tạo store procedure hiển thị ra đơn hàng có tổng tiền bé nhất
DELIMITER //
create procedure get_order_smallest()
	begin
    select * from orders
    order by oTotalPrice
    limit 1 ;
    end;
// 
DELIMITER ;

call get_order_smallest();

-- Tạo store procedure hiển thị người dùng nào mua sản phẩm “May Giat” ít nhất
DELIMITER //
	create procedure get_customer_buy_least()
    begin
    select customers.cName, orders.oId ,products.pName, sum(orderdetail.odQuantity) as quantity from orders
    inner join customers on orders.cId = customers.cId
    inner join orderdetail on orders.oId = orderdetail.oId
    inner join products on orderdetail.pId = products.pId
    where products.pName = 'May Giat'
    group by orders.oId 
    order by quantity
    limit 1 ;
    end ;
//
DELIMITER ;