create database session04_bai1 ;

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

-- Hiển thị số lượng sinh viên theo từng địa chỉ nơi ở.
select address , count(address) as numberStudent from student
group by address ;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subject.subjectName ,max(mark) as mark from mark
left join subject on mark.subjectId = subject.subjectId
group by subject.subjectName;

-- Tính điểm trung bình các môn học của từng học sinh.
select student.studentName , avg(mark) from mark
left join student on mark.studentId = student.studentId
group by student.studentName ;

-- Hiển thị những bạn học viên có điểm trung bình các môn học nhỏ hơn bằng 70.
select student.studentName , avg(mark) as avgMark from mark
left join student on mark.studentId = student.studentId
group by student.studentName 
having avgMark <= 7.0;

-- Hiển thị thông tin học viên có điểm trung bình các môn lớn nhất.
select student.studentName , avg(mark) as avgMark from mark
left join student on mark.studentId = student.studentId
group by student.studentName 
order by avgMark desc 
limit 1 ;

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select student.studentName , avg(mark) as avgMark from mark
left join student on mark.studentId = student.studentId
group by student.studentName 
order by avgMark desc ;
