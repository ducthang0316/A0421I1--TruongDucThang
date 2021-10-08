create database demo;
use demo;
create table products (
id int auto_increment primary key,
pCode varchar(5),
pName varchar(50),
pPrice int,
pAmount int,
pDescpt varchar(250),
pStatus varchar(100)
);

insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0001', 'quat', 10, 100, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0002', 'may tinh', 20, 200, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0003', 'tivi', 30, 300, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0004', 'ban', 40, 400, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0005', 'ghe', 50, 500, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0006', 'bep', 60, 600, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0007', 'tu lanh', 70, 700, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0008', 'noi com', 80, 800, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0009', 'may lanh', 90, 900, "new", "available");
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values ('p0010', 'may hut bui', 100, 1000, "new", "available");

select * from products where pCode = 'p0005';
select * from products where pName = 'ban' and pPrice = 400;

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
create unique index pCode_index
on products(pCode);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
create index composite_index 
on products(pName, pPrice);
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
explain select * from products where pCode = 'p0005';
explain select * from products where pName = 'ban' and pPrice = 400;

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view pView as
select pCode, pName, pPrice, pStatus
from products;

select * from pView;

-- Tiến hành sửa đổi view
update pView 
set pStatus = "sold out"
where pCode = "p0001";

delete from pView 
where pStatus = "sold out";

select * from pView;

-- Tiến hành xoá view
drop view pView;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
 create procedure allrecords ()
 begin
 select * from products;
 end//
DELIMITER ;

call allrecords ();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure add_product(
in newpCode varchar(5),
in newpName varchar(50),
in newpPrice int,
in newpAmount int,
in newpDescpt varchar(250),
in newpStatus varchar(100)
)
begin
insert  into products (pCode, pName, pPrice, pAmount, pDescpt, pStatus) values (newpCode, newpName, newpPrice, newpAmount, newpDescpt, newpStatus);
end //
DELIMITER ;

call add_product("p0012", "loa", 120, 50, "new", "available");

-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER // 
create procedure edit_product(
in input_id int,
in new_pStatus varchar(100)
)
begin
update products
set pStatus = new_pStatus 
where id = input_id;
end //
DELIMITER ;

call edit_product (4, "sold out");

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER // 
create procedure delete_product(
in input_id int
)
begin
delete from products
where id = input_id;
end //
DELIMITER ;

call delete_product(4);



