create database session2_bai4 ;
create table users (
id int auto_increment primary  key ,
fullName varchar(100) not null ,
email varchar(255) not null ,
password varchar(255) not null ,
phone varchar(11) not null ,
permission bit  not null ,
status bit not null 
);

create table history(
id int auto_increment primary key ,
user_id int not null references users(id),
point int not null ,
examDate datetime not null 
);
create table axams (
id int auto_increment primary key,
name varchar(100) not null ,
duration int not null ,
status bit not null 
);
create table question (
id int auto_increment primary key ,
content varchar(255) not null ,
exam_id int not null references exams(id),
status bit not null
);
create table history_detail (
id int auto_increment primary key ,
history_id int not null references history(id),
question_id int not null references question(id) ,
result bit not null
);
