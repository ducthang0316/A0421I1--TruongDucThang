create database `my_database`;
use `my_database`;
create table student_management (
id int not null,
`name` varchar(45) null,
age int null,
`country` varchar(50) null,
primary key (id)
);
select * from student_management;