create database QUANLYBANHANG ;
use QUANLYBANHANG ;

-- ************************* bài 1 ***************************
create table CUSTOMERS (
customer_id varchar(4) primary key not null ,
name varchar(100) not null unique ,
email varchar(100) not null ,
phone varchar(25) not null ,
address varchar(255) not null
);

create table ORDERS (
order_id varchar(4) primary key not null ,
customer_id varchar(4) not null ,
order_date date not null ,
total_amount double not null,
foreign key (customer_id) references CUSTOMERS(customer_id)
);

create table PRODUCTS (
product_id varchar(4) primary key not null ,
name varchar(255) not null ,
description text ,
price double not null ,
status bit(1) not null 
);

create table ORDERS_DETAILS (
order_id varchar(4) not null,
product_id varchar(4) not null ,
primary key (order_id , product_id),
quantity int(11) not null ,
price double not null,
foreign key (order_id) references ORDERS(order_id),
foreign key (product_id) references PRODUCTS(product_id)
);

-- ************************* bài 2 ***************************
insert into CUSTOMERS (customer_id , name , email , phone ,address)
values ("C001", "Nguyễn Trung Mạnh", "manhnt@gmail.com","984756322", "Cầu Giấy , Hà Nội"),
("C002", "Hồ Hải Nam", "namhh@gmail.com","984875926", "Ba Vì , Hà Nội"),
("C003", "Tô Ngọc Vũ", "vutn@gmail.com","904725784", "Mộc Châu , Sơn La"),
("C004", "Phạm Ngọc Anh", "anhpn@gmail.com","984635365", "Vinh , Nghệ An"),
("C005", "Trương minh Cường", "cuongtm@gmail.com","989735624", "Hai Bà Trưng , Hà Nội");

insert into PRODUCTS (product_id , name , description , price , status)
values ("P001" , "Iphone 13 ProMax", "Bản 512GB , xanh lá" , 22999999,1),
("P002" , "Dell Vostro V3510", "Core i5,RAM 8GB" , 14999999,1),
("P003" , "Macbook Pro M2", "8CPU 10GPU 8GB 256GB" , 28999999,1),
("P004" , "Apple Watch Ultra", "Titanium Alpine Loop Small" , 18999999,1),
("P005" , "Airpods 2 2022", "Spatial Audio" , 4090000,1);

insert into ORDERS (order_id,customer_id,total_amount,order_date)
values ("H001","C001",52999997,'2023-02-22'),
("H002","C001",80999997,'2023-03-11'),
("H003","C002",54359998,'2023-01-21'),
("H004","C003",102999995,'2023-03-14'),
("H005","C003",80999997,'2022-03-12'),
("H006","C004",110449994,'2023-02-01'),
("H007","C004",79999996,'2023-03-29'),
("H008","C005",29999998,'2023-02-14'),
("H009","C005",28999999,'2023-01-10'),
("H010","C005",149999994,'2023-04-01');

insert into ORDERS_DETAILS (order_id, product_id , quantity , price)
values ("H001","P002",14999999,1),
("H001","P004",18999999,2),
("H002","P001",22999999,1),
("H002","P003",28999999,2),
("H003","P004",18999999,2),
("H003","P005",4090000,4),
("H004","P002",14999999,3),
("H004","P003",28999999,2),
("H005","P001",22999999,1),
("H005","P003",28999999,2),
("H006","P005",4090000,5),
("H006","P002",14999999,6),
("H007","P004",18999999,6),
("H007","P001",22999999,1),
("H008","P002",14999999,2),
("H009","P003",28999999,1),
("H010","P003",28999999,2),
("H010","P001",22999999,4);

-- ************************* bài 3 ***************************
--  1. Lấy ra tất cả thông tin gồm: tên, email, số điện 
-- thoại và địa chỉ trong bảng Customers .
	select name , email , phone , address from customers ;
    
-- 2. Thống kê những khách hàng mua hàng trong tháng 3/2023 (thông tin bao gồm tên, số điện 
-- thoại và địa chỉ khách hàng). [4 điểm]
	select c.name , c.phone , c.address from customers c
    inner join orders o on c.customer_id = o.customer_id
    where o.order_date between '2023-03-01' and '2023-03-31' ;

-- 3. Thống kê doanh thua theo từng tháng của cửa hàng trong năm 2023 (thông tin bao gồm 
-- tháng và tổng doanh thu ). [4 điểm]
	select month(order_date) as month , sum(total_amount) as total_money from orders
    group by month 
    order by month;
    
-- 4. Thống kê những người dùng không mua hàng trong tháng 2/2023 (thông tin gồm tên khách 
-- hàng, địa chỉ , email và số điên thoại). [4 điểm]
	select c.name ,c.address , c.email , c.phone from customers c
    left join orders o on c.customer_id = o.customer_id
    and order_date between '2023-02-01' and '2023-02-28'
    where o.customer_id is null;
    
-- 5. Thống kê số lượng từng sản phẩm được bán ra trong tháng 3/2023 (thông tin bao gồm mã 
-- sản phẩm, tên sản phẩm và số lượng bán ra). [4 điểm]
-- 6. Thống kê tổng chi tiêu của từng khách hàng trong năm 2023 sắp xếp giảm dần theo mức chi 
-- tiêu (thông tin bao gồm mã khách hàng, tên khách hàng và mức chi tiêu). [5 điểm] 
-- 7. Thống kê những đơn hàng mà tổng số lượng sản phẩm mua từ 5 trở lên (thông tin bao gồm 
-- tên người mua, tổng tiền , ngày tạo hoá đơn, tổng số lượng sản phẩm) . [5 điểm] 

-- ************************* bài 4 ***************************
 -- 1. Tạo VIEW lấy các thông tin hoá đơn bao gồm : Tên khách 
-- hàng, số điện thoại, địa chỉ, tổng tiền và ngày tạo hoá đơn . [3 điểm] 
-- 2. Tạo VIEW hiển thị thông tin khách hàng gồm : tên khách hàng, địa chỉ, số điện thoại và tổng 
-- số đơn đã đặt. [3 điểm]
-- 3. Tạo VIEW hiển thị thông tin sản phẩm gồm: tên sản phẩm, mô tả, giá và tổng số lượng đã bán 
-- ra của mỗi sản phẩm. 
-- 4. Đánh Index cho trường `phone` và `email` của bảng Customer. [3 điểm]
-- 5. Tạo PROCEDURE lấy tất cả thông tin của 1 khách hàng dựa trên mã số khách hàng.[3 điểm] 
-- 6. Tạo PROCEDURE lấy thông tin của tất cả sản phẩm. [3 điểm] 
-- 7. Tạo PROCEDURE hiển thị danh sách hoá đơn dựa trên mã người dùng. [3 điểm] 
-- 8. Tạo PROCEDURE tạo mới một đơn hàng với các tham số là mã khách hàng, tổng tiền và 
-- ngày tạo hoá đơn, và hiển thị ra mã hoá đơn vừa tạo. [3 điểm] 
-- 9. Tạo PROCEDURE thống kê số lượng bán ra của mỗi sản phẩm trong khoảng thời gian cụ thể 
-- với 2 tham số là ngày bắt đầu và ngày kết thúc. [3 điểm] 
-- 10. Tạo PROCEDURE thống kê số lượng của mỗi sản phẩm được bán ra theo thứ tự giảm dần 
-- của tháng đó với tham số vào là tháng và năm cần thống kê. [3 điểm]