create database exam_db_1;
use exam_db_1;
CREATE TABLE product (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(55),
    price DOUBLE,
    quantity INT,
    color VARCHAR(55),
    `description` VARCHAR(250),
    id_category INT,
    FOREIGN KEY (id_category)
        REFERENCES category (id_category)
);

create table category (
id_category INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name_category varchar(55)
);

insert into category values
( 1, 'phone'),
( 2, 'tablet'),
( 3, 'TV');

insert into product values
(1, 'iphone 11' , 799 , 12 , 'purple, yellow, green', 'new', 1),
(2, 'iphone 11 pro' , 1100 , 14 , 'purple, yellow','new', 1),
(3, 'iphone x' , 700 , 16 , 'purple, blue , green', 'new', 1),
(4, 'Smart tv' , 1300 , 18 , 'black', 'new', 3 ),
(5, 'galaxy tab e' , 100 , 20 , 'yellow, green', 'new', 2);

DELIMITER $$
create procedure edit_product_by_id( in 
	up_id INT,
	up_name varchar(45),
	up_price double,
	up_quantity int,
	up_color varchar(45),
    up_description varchar(250),
	up_id_category varchar(45))
    begin
    update product
    set id = up_id,
    `name` = up_name,
    price = up_price,
    quantity = up_quantity,
    color = up_color,
    `description` = up_description,
    id_category = up_id_category
    where id = up_id;
    end $$
    DELIMITER ;
    
    select * from product;
