CREATE DATABASE case_study_2;
USE case_study_2;
CREATE TABLE position (
    position_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    position_name VARCHAR(45)
);
CREATE TABLE education_degree (
    education_degree_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ducation_degree_name VARCHAR(45)
);
CREATE TABLE division (
    division_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    division_name VARCHAR(45)
);
CREATE TABLE employee (
    employee_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(45),
    position_id INT,
    education_degree_id INT,
    division_id INT,
    employee_birthday DATE,
    employee_id_card VARCHAR(45),
    employee_salary double,
    employee_phone VARCHAR(45),
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    username varchar(255),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id), 
    FOREIGN KEY (position_id)
        REFERENCES position (position_id),
        FOREIGN KEY (username)
        REFERENCES `user` (username)
);

CREATE TABLE `user` (
	username varchar(255) NOT NULL PRIMARY KEY,
    `password` varchar(255)
);
CREATE TABLE `role` (
	role_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    role_name varchar(255)
);

create table user_role(
role_id int,
username varchar(255),
foreign key (role_id) references `role` (role_id),
foreign key (username) references `user` (username)
);
CREATE TABLE customer_type (
    customer_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_type_name VARCHAR(45)
);
CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_type_id INT,
    customer_name VARCHAR(45),
    customer_birthday DATE,
    customer_gender bit(1),
    customer_id_card VARCHAR(45),
    customer_phone VARCHAR(45),
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);
CREATE TABLE rent_type (
    rent_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rent_type_name VARCHAR(45),
    rent_type_cost double
);
CREATE TABLE service_type (
    service_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    service_type_name VARCHAR(45)
);
CREATE TABLE service (
    service_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(45),
    service_area INT,
    service_max_people int,
    service_cost double,
    rent_type_id INT,
    service_type_id INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area double,
    number_of_floor int,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id),
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
);

CREATE TABLE attach_service (
    attach_service_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    attach_service_name VARCHAR(45),
    attach_service_cost double,
    attach_service_unit INT,
    attach_service_status VARCHAR(45)
);

CREATE TABLE contract (
    contract_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    customer_id INT,
    service_id INT,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposit double,
    contract_total_money double,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
);

CREATE TABLE contract_detail (
    contract_detail_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    contract_id INT,
    attach_service_id INT,
    quantity INT,
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id),
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id)
);


INSERT INTO position VALUES (1,'Le tan'),(2,'Phuc vu'),(3,'Chuyen vien'),(4,'Giam sat'),(5,'Quan li'),(6,'Giam doc');
INSERT INTO education_degree VALUES (1,'Trung cap'),(2,'Cao dang'), (3,'Dai hoc'),(4,'Sau dai hoc');
INSERT INTO division VALUES (1,'Sale-Marketing'), (2,'Hanh chinh'),(3,'Phuc vu'),(4,'Quan ly');
INSERT INTO customer_type VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Silver'),(5,'Member');
INSERT INTO rent_type VALUES(1,'năm',90000000),(2,'tháng',1200000),(3,'ngày',2000000),(4,'giờ',200000);
INSERT INTO service_type VALUES(1,'Villa'),(2,'House'),(3,'Room');

INSERT INTO attach_service
VALUES
(1,'massage',500000,1,'available'),
(2,'karaoke',400000,1,'available'),
(3,'thức ăn',300000,1,'available'),
(4,'nước uống',200000,1,'available'),
(5,'thuê xe di chuyển tham quan resort',100000,1,'available');

INSERT INTO customer
VALUES
(1,1,'Nguyen Thi Hong','1999-01-02', 0 , '12341234','0984769769','nguyenhong@gmail.com','Quang Tri'),
(2,2,'Dang Van Tuan','1998-02-03',1 , '12341234','0984769769','dangtuan@gmail.com','Quang Binh'),
(3,3,'Le Duc Khoa','1997-03-04',1 , '12341234','0984769769','lekhoa@gmail.com','Hai Duong'),
(4,4,'Tran Quoc Loc','1996-04-05',1 , '12341234','0984769769','tranloc@gmail.com','Đa Nang'),
(5,5,'Le Trung Hau','1995-05-06',1 , '12341234','0984769769','lehau@gmail.com','Ha Noi'),
(6,1,'Dang Cong Thanh','1994-08-05',1 , '12341234','0984769769','mail@gmail.com','Quang Tri'),
(7,2,'Nguyen My Huong','1993-09-04',0 , '12341234','0984769769','mail@gmail.com','Đa Nang'),
(8,3,'Pham Duc Huy','1992-10-03',1 , '12341234','0984769769','mail@gmail.com','HCM'),
(9,4,'Ngo Duc Lam','1991-11-02',1 , '12341234','0984769769','mail@gmail.com','Quang Nam'),
(10,5,'Le Gia Han','1990-12-01',0 , '12341234','0984769769','mail@gmail.com','Ha Noi');

select * from customer;


INSERT INTO service
VALUES
(1,'thuê villa', 300, 12,5000000, 1, 1,'high' , 'none', 100, 5),
(2,'thuê house', 200, 7,4000000, 2, 2,'high', 'none', 70, 3),
(3,'thuê room', 100, 4,3000000, 3, 3,'high', 'none', 30, 2);

select * from service;

INSERT INTO employee
VALUES
(1,'Nguyen Thanh Nam',5,2,1,'1990-02-12','12341234',50000000,'0984769769','nam@gmail.com','Đa Nang','thanhnam'),
(2,'Nguyen Van Hai',2,1,2,'1991-11-12',12341234,5000000,0984769769,'hai@gmail.com','Đa Nang', 'vanhai'),
(3,'Nguyen Ngoc Hanh',6,2,3,'1992-12-13',12341234,5000000,0984769769,'hanh@gmail.com','Quang Nam', 'ngochanh'),
(4,'Ly Thi Ha',2,3,4,'1993-01-12',12341234,10000000,0984769769,'ha@gmail.com','Đa Nang', 'thiha'),
(5,'Truong Van Hoa',3,3,1,'1994-02-09',12341234,10000000,0984769769,'hoa@gmail.com','HCM','vanhoa'),
(6,'Trinh Van Khanh',1,1,2,'1995-02-17',12341234,20000000,0984769769,'khanh@gmail.com','Ha Noi', 'vankhanh'),
(7,'Le Hong Ngoc',2,2,1,'1996-03-12',12341234,20000000,0984769769,'ngoc@gmail.com','Hai Phong', 'hongngoc'),
(8,'Ly Duc Thinh',4,4,3,'1997-04-12',12341234,50000000,0984769769,'thinh@gmail.com','Đa Nang', 'ducthinh'),
(9,'Hoang Duc Man',6,3,1,'1998-05-18',12341234,30000000,0984769769,'man@gmail.com','Đa Nang', 'ducman'),
(10,'Vo My Hang',4,4,1,'1999-06-12',12341234,40000000,0984769769,'hang@gmail.com','Quang Nam', 'myhang');

select * from employee;

insert into `user` 
values
('thanhnam', '12345'),
('vanhai', '12345'),
('ngochanh', '12345'),
('thiha', '12345'),
('vanhoa', '12345'),
('vankhanh', '12345'),
('hongngoc', '12345'),
('ducthinh', '12345'),
('ducman', '12345'),
('myhang', '12345');

insert into `role`
values
(1, 'supervising'),
(2, 'operating'),
(3, 'managing'),
(4, 'supporting'),
(5, 'searching');

insert into user_role
values 
(5 , 'thanhnam'),
(4 , 'vanhai'),
(3 , 'ngochanh'),
(2 , 'thiha'),
(1 , 'vanhoa'),
(2 , 'vankhanh'),
(3 , 'hongngoc'),
(4 , 'ducthinh'),
(5 , 'ducman'),
(1 , 'myhang');

INSERT INTO contract
VALUES
(1,  1, 1, 3,'2020-12-12', '2021-12-30', 600000, 5000000),
(2,  2, 2, 2,'2019-02-13','2019-03-20', 700000, 6000000),
(3 , 3, 3, 3, '2018-03-14','2018-04-20', 800000, 7000000),
(4 , 4, 4, 1, '2021-04-15','2021-05-20', 1000000, 8000000),
(5 , 5, 5, 1, '2020-05-16','2021-06-22', 1500000, 90000000);

INSERT INTO contract_detail
VALUES
(1,1,2,2),
(2,2,1,3),
(3,3,3,1),
(4,4,2,2),
(5,5,1,3);

DELIMITER $$
create procedure edit_customer_by_id( in 
	up_id INT,
    up_type_id INT,
    up_name VARCHAR(45),
    up_birthday DATE,
    up_gender bit(1),
    up_id_card VARCHAR(45),
    up_phone VARCHAR(45),
    up_email VARCHAR(45),
    up_address VARCHAR(45))
    begin
    update customer
    set customer_type_id = up_type_id,
    customer_name = up_name,
    customer_birthday = up_birthday,
    customer_gender = up_gender,
    customer_id_card = up_id_card,
    customer_phone = up_phone,
    customer_email = up_email,
    customer_address = up_address
    where customer_id = up_id;
    end $$
    DELIMITER ;
    
    select * from customer where customer_id = 1;
    
    select * from customer where customer_name like "%%" and customer_address like "%%" and customer_type_id like "%%";


