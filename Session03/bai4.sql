create database session03_bai4 ;

create table class (
classId int auto_increment primary key ,
className varchar(100) not null unique ,
startDate datetime not null ,
status bit(1) not null
);

insert into class (className,startDate,status)
values ("HN-JV231103",'2023-11-03',1),
("HN-JV231229",'2023-12-29',1),
("HN-JV230615",'2023-06-15',1);

create table student (
studentId int auto_increment primary key ,
studentName varchar(100) not null ,
address varchar(255) not null ,
phone varchar(11) not null ,
classId int not null ,
status bit(1) not null,
foreign key (classId) references class(classId)
);

insert into student (studentName,address,phone,classId,status)
values ("Hồ Da Hùng","Hà Nội","0987654321",1,1),
("Phan Văn Giang","Đà Nẵng","0967811255",1,1),
("Dương Mỹ Huyền","Hà Nội","0385546614",2,1);


insert into student (studentName,address,phone,classId,status)
values ("Hoàng Minh Hiếu","Nghệ An","09644255633",2,1),
("Nguyễn Vịnh","Hà Nội","0975123552",3,1),
("Nam Cao","Hà Tĩnh","0919191919",1,1),
("Nguyễn Du","Nghệ An","0353535353",3,1);
create table subject(
subjectId int auto_increment primary key ,
subjectName varchar(100) not null unique,
credit int not null ,
status bit(1) not null
);

insert into subject (subjectName,credit,status)
values ("Toán",3,1),
("Văn",3,1),
("Anh",2,1);

create table mark (
markId int auto_increment primary key ,
studentId int not null ,
subjectId int not null ,
mark double not null,
examTime datetime not null  
);

insert into mark (studentId,subjectId,mark,examTime)
values (1,1,7,'2024-05-12'),
(1,1,7,'2024-03-15'),
(2,2,8,'2024-05-15'),
(2,3,9,'2024-03-08'),
(3,3,10,'2024-02-11');

-- Hiển thị tất cả lớp học được sắp xếp theo tên giảm dần
select * from class
order by className desc ;

-- Hiển thị tất cả học sinh có address ở “Hà Nội”
select * from student
where address = "Hà Nội" ;

-- Hiển thị tất cả học sinh thuộc lớp HN-JV231103
select * from student
inner join class on student.classId = class.classId
where className = "HN-JV231103" ;

-- Hiển thị tát cả các môn học có credit trên 2
select * from subject
where credit > 2 ;

-- Hiển thị tất cả học sinh có phone bắt đầu bằng số 09
select * from student
where phone like '09%';