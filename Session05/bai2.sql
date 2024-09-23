create database sesssion05_bai2;
use sesssion05_bai2 ;
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
insert into product(name,created,price,stock,status)
values ("Quần cộc",'2022-03-12',1200,5,1),
("Áo cộc",'2023-03-15',1500,8,1),
("Mũ nón sơn",'1999-03-08',1600,10,1);

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

-- Tạo store procedure hiển thị tất cả thông tin account mà đã tạo ra 5 đơn hàng trở lên
DELIMITER //
	create procedure get_account_has_5_order()
    begin
		select account.* , count(bill.id) as total_order from account
        inner join bill on account.id = bill.acc_id
        group by account.id
        having total_order >= 1 ;
    end;
//
DELIMITER ;

-- Tạo store procedure hiển thị tất cả sản phẩm chưa được bán
DELIMITER //
	create procedure get_product_notYetSold()
    begin
    select product.name , sum(bill_detail.quantity) as total_sell from product
    left join bill_detail on product.id = bill_detail.product_id
    group by product.name
    having total_sell is null ;
    end;
//
DELIMITER ;

-- Tạo store procedure hiển thị top 2 sản phẩm được bán nhiều nhất
DELIMITER //
	create procedure get_best_seller()
    begin
    select product.name , sum(bill_detail.quantity) as total_sell from product
    left join bill_detail on product.id = bill_detail.product_id
    group by product.name
    order by total_sell desc
    limit 2 ;
    end;
//
DELIMITER ;

-- Tạo store procedure thêm tài khoản
DELIMITER //
	create procedure add_account(Username varchar(50),Password varchar(150) , Address varchar(255))
    begin
   insert into account(username, password,address,status)
   values(Username,Password,Address,1);
    end;
//
DELIMITER ;

call add_account("huongcaoha","123456789","Hoai Duc");

-- Tạo store procedure truyền vào bill_id và sẽ hiển thị tất cả bill_detail của bill_id đó
DELIMITER //
	create procedure get_billDetail(idBill int)
    begin
    select * from bill_detail
    inner join bill on bill_detail.bill_id = bill.id
    where bill_detail.bill_id = idBill ;
    end;
// 
DELIMITER ;

call get_billDetail(1);

-- Tạo ra store procedure thêm mới bill và trả về bill_id vừa mới tạo
DELIMITER //
	create procedure addBill_returnId(IN billType int,IN AccId int ,IN createdDate datetime ,IN authDate datetime , OUT idBill int)
    begin
    insert into bill (bill_type,acc_id,created,auth_date)
    values (billType,AccId,createdDate,authDate);
	set idBill = (last_insert_id());
    end ;
//
DELIMITER ;

-- Tạo store procedure hiển thị tất cả sản phẩm đã được bán trên 5 sản phẩm
DELIMITER //
	create procedure ProductSold5Times()
    begin
    select product.* , sum(bill_detail.quantity) as quantity from bill_detail
    inner join product on bill_detail.product_id = product.id
    group by bill_detail.product_id
    having quantity > 5;
    end;
//
DELIMITER ;