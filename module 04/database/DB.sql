use case_study_module_04;
SELECT * FROM attach_service;
SELECT * FROM customer_type;
SELECT * FROM division;
SELECT * FROM education_degree;
SELECT * FROM position;
SELECT * FROM rent_type;
SELECT * FROM service_type;
SELECT * FROM customer;

insert into customer values
(1, 'Ha Noi', '1999-01-02', 'hai@gmail.com' , 1, '12345678' , 'Nguyen Hong Hai' , '0984123123' , 2 ),
(2, 'Da Nang', '1993-03-04', 'huong@gmail.com' , 0, '12345678' , 'Nguyen Huong' , '0984123123' , 1 ),
(3, 'Hai Phong', '1995-04-05', 'hong@gmail.com' , 0, '12345678' , 'Nguyen Hong' , '0984123123' , 3 ),
(4, 'Hue', '1997-06-07', 'nam@gmail.com' , 1, '12345678' , 'Nguyen Nam' , '0984123123' , 5 ),
(5, 'Quang Nam', '1998-07-08', 'tuan@gmail.com' , 1, '12345678' , 'Nguyen Tuan' , '0984123123' , 4 );



INSERT INTO service
VALUES
(1 , 300, 5000000 , 'none' , 4 , 12 , 100 , 'thuê villa' , 'high' , 2 , 1),
(2 , 200, 3000000 , 'none' , 3 , 9 , 70 , 'thuê house' , 'high' , 3 , 2),
(3 , 100, 2000000 , 'none' , 2 , 5 , 30 , 'thuê room' , 'high' , 4 , 3);

select * from service;

select * from `user`;

INSERT INTO employee
VALUES
(1 , 'Đa Nang' , '1990-02-12', 'thanhnam@gmail.com', '12341234', 'Nguyen Thanh Nam', '0984769769' , 20000000, 'thanhnam' , 2 , 3 , 3 , 1),
(2 , 'Đa Nang' , '1991-11-12', 'vanhai@gmail.com', '12341234', 'Nguyen Van Hai', '0984769769' , 25000000, 'vanhai' , 1 , 4 , 4 , 2),
(3 , 'Quang Nam' , '1990-02-12', 'ngochanh@gmail.com', '12341234', 'Nguyen Ngoc Hanh', '0984769769' , 30000000, 'ngochanh' , 4 , 3 , 5 , 3),
(4 , 'Ha Noi' , '1990-02-12', 'thiha@gmail.com', '12341234', 'Ly Thi Ha', '0984769769' , 40000000, 'thiha' , 4 , 3 , 6 , 4),
(5 , 'Hue' , '1990-02-12', 'vanhoa@gmail.com', '12341234', 'Truong Van Hoa', '0984769769' , 10000000, 'vanhoa' , 3 , 2 , 2 , 5);

select * from employee;

insert into `role`
values
(3, 'ROLE_EMPLOYEE'),
(4, 'ROLE_DIRECTOR'),
(5, 'ROLE_MANAGER');

select * from ROLE;

insert into user_role
values 
(1 , 3 ),
(2 , 3 ),
(3 , 5 ),
(4 , 4 ),
(4 , 1 ),
(5 , 3 );

select * from user_role;

INSERT INTO contract
VALUES
(1, 600000, '2021-12-30', '2020-12-12', 5000000,  1, 1, 3 ),
(2,  700000, '2019-03-20', '2019-02-13' , 6000000, 2, 2, 2),
(3 , 800000, '2018-04-20', '2018-03-14', 7000000, 3, 3, 3),
(4 , 1000000, '2021-05-20' , '2021-04-15', 8000000, 4, 4, 1 ),
(5 , 1500000, '2021-06-22','2020-05-16',90000000, 5, 5, 1 );

select * from contract;

INSERT INTO contract_detail
VALUES
(1,1,2,1),
(2,2,1,2),
(3,3,3,3),
(4,2,4,4),
(5,1,5,5);

select * from contract_detail;
select * from customer where customer.name like '%hong%';

select * from customer join customer_type where customer.customer_type_id = customer_type.id and customer_type.id = 1;

select * from customer where customer.name = 'Hong' or customer.address = 'ha';

