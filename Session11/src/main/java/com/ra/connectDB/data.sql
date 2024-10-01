create database ngay1thang10nam2024 ;
use ngay1thang10nam2024;

create table products (
    id int auto_increment primary key ,
    name varchar(100) not null ,
    price double not null check ( price > 0 ),
    producer varchar(100) not null ,
    description text ,
    status bit(1) default 1
);

DELIMITER //
    create procedure proc_update_product(IN _name varchar(100),_price double , _producer varchar(100) , _description text , _status bit , _id int)
    begin
        update products set name = _name , price = _price , producer = _producer , description = _description , status = _status
        where id = _id ;
    end //
//
DELIMITER ;

DELIMITER //
    create procedure proc_delete_product(IN _id int)
    begin
        delete from products where  id = _id ;
    end //
//
DELIMITER ;
