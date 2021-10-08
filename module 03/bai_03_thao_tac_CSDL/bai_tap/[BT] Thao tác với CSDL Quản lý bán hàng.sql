use b02_bt_quan_ly_ban_hang;
insert into Customer(cName, cAge ) values ( 'Minh Quan', 10 );
insert into Customer(cName, cAge ) values ( 'Ngoc Oanh', 20 );
insert into Customer(cName, cAge ) values ( 'Hong Ha', 50 );

insert into `Order` ( cID, oDate, oTotalPrice) values ( 1, '2006-03-21', Null);
insert into `Order` (cID, oDate, oTotalPrice) values ( 2, '2006-03-23', Null);
insert into `Order` (cID, oDate, oTotalPrice) values ( 1, '2006-03-16', Null);

insert into Product ( pName, pPrice) values ('May Giat', 3);
insert into Product ( pName, pPrice) values ('Tu Lanh', 5);
insert into Product ( pName, pPrice) values ('Dieu Hoa', 7);
insert into Product ( pName, pPrice) values ('Quat', 1);
insert into Product ( pName, pPrice) values ('Bep Dien', 2);

insert into orderdetail (oID, pID, odQTY) values (1, 1, 3);
insert into orderdetail (oID, pID, odQTY) values (1, 3, 7);
insert into orderdetail (oID, pID, odQTY) values (1, 4, 2);
insert into orderdetail (oID, pID, odQTY) values (2, 1, 1);
insert into orderdetail (oID, pID, odQTY) values (3, 1, 8);
insert into orderdetail (oID, pID, odQTY) values (2, 5, 4);
insert into orderdetail (oID, pID, odQTY) values (2, 3, 3);


-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice  from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select cName, pName from orderdetail odd 
join product p on p.pID = odd.pID
join `order` o on o.oID = odd.oID
join customer c on c.cID = o.cID
order by c.cName;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select cName from customer c 
where c.cID not in (select `order`.cID from `order`);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.

-- thêm cột giá tiền(detail_price) ở bẳng orderdetail tính giá tiền của từng đơn hàng 
alter table orderdetail 
add detail_price int; 
select * from orderdetail;

-- update cot detail_price
update orderdetail odd
join product p on p.pID = odd.pID
set odd.detail_price = odd.odQTY * p.pPrice;

update `order` o 
join orderdetail odd  on o.oID = odd.oID
set o.oTotalPrice = (select sum(odd.detail_price) from orderdetail odd where o.oID = odd.oID );

select * from `order` o



