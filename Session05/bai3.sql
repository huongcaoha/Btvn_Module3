create database session05_bai3 ;
use session05_bai3 ;
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

-- Tạo store procedure lấy ra tất cả lớp học có số lượng học sinh lớn hơn 5
DELIMITER //
	create procedure getClassGt5Student()
    begin
		select class.classId ,class.className , count(student.classId) quantity from class
        inner join student on class.classId = student.classId
        group by student.classId
        having quantity > 5 ;
    end;
//
DELIMITER ;

-- Tạo store procedure hiển thị ra danh sách môn học có điểm thi là 10
DELIMITER //
	select * from subject
    inner join mark on subject.subjectId = mark.subjectId
    where mark.mark = 10 ;
//
DELIMITER ;

-- Tạo store procedure hiển thị thông tin các lớp học có học sinh đạt điểm 10
DELIMITER //
	create procedure getClassHaveStudentMark10()
    begin
    select class.className , student.studentName , mark.mark from mark
    inner join student on mark.studentId = student.studentId
    inner join class on student.classId = class.classId
    where mark.mark = 10 ;
    end ;
//
DELIMITER ;

-- Tạo store procedure thêm mới student và trả ra id vừa mới thêm
DELIMITER //
		create procedure addStudentAndGetId(IN StudentName varchar(255), IN Address varchar(255), IN Phone varchar(11) ,IN ClassId int , IN Status int , OUT id int)
        begin
        insert into student (studentName,address,phone,classId,status)
		values (StudentName,Address,Phone,ClassId,Status);
        set id = (last_insert_id());
        end ;
//
DELIMITER ;

call addStudentAndGetId("Nguyễn Công Hưởng","Hoài Đức","0367508795",1,1,@id);
select @id ;

-- Tạo store procedure hiển thị subject chưa được ai thi
DELIMITER //
		create procedure subjectNotTested()
        begin
        select * from subject
        left join mark on subject.subjectId = mark.subjectId
        where mark.mark is null ;
        end ;
//
DELIMITER ;