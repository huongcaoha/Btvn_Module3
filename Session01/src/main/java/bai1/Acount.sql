create table Acount(
                       id int auto_increment primary key ,
                       firstName varchar(100) not null ,
                       lastName varchar(100) not null ,
                       email varchar(255) not null ,
                       password varchar(255) not null ,
                       phone varchar(11) not null ,
                       dateOfBirth date not null ,
                       status bit not null
);