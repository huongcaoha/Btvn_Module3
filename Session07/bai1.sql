create database session06_bai1 ;
use session06_bai1 ;

create table users (
id int auto_increment primary key ,
name varchar(50) not null unique ,
address varchar(255) not null ,
phone varchar(11) not null ,
dateOfBirth date ,
status bit(1) not null 
);

create table products (
id int auto_increment primary key ,
name varchar(100) not null ,
price double not null check (price > 0),
stock int not null ,
status bit not null
);

create table shopping_cart (
id int auto_increment primary key ,
user_id int not null ,
product_id int not null ,
quantity int not null ,
amount double not null 
);

-- Tạo Trigger khi thay đổi giá của sản phẩm thì amount (tổng giá) cũng sẽ phải cập nhật lại
DELIMITER //
	create trigger after_change_price
    after update on products
    for each row
    begin 
    if new.price <> old.price then
     update shopping_cart
     set amount = quantity * new.price 
     where product_id = new.id;
     end if ;
    end ;
//
DELIMITER ;

-- Tạo trigger khi xóa product thì những dữ liệu ở bảng shopping_cart có chứa product bị xóa thì cũng phải xóa theo
DELIMITER //
	create trigger delete_product
    after delete on products
    for each row
    begin
    delete from shopping_cart
    where product_id = old.id ;
    end ;
//
DELIMITER ;

-- Khi thêm một sản phẩm vào shopping_cart với số lượng n thì bên product cũng sẽ phải trừ đi số lượng n
DELIMITER //
		create trigger update_stock_product
        after update on shopping_cart 
        for each row 
        begin
         update products
        set stock = stock - new.quantity ;
        end ;
//
DELIMITER ;
