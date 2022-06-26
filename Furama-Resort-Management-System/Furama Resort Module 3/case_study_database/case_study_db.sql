CREATE DATABASE case_study;
USE case_study;
CREATE TABLE vi_tri (
    id_vi_tri INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_vi_tri VARCHAR(45)
);
CREATE TABLE trinh_do (
    id_trinh_do INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    trinh_do VARCHAR(45)
);
CREATE TABLE bo_phan (
    id_bo_phan INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_bo_phan VARCHAR(45)
);
CREATE TABLE nhan_vien (
    id_nhan_vien INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ho_ten VARCHAR(45),
    id_vi_tri INT,
    id_trinh_do INT,
    id_bo_phan INT,
    ngay_sinh DATE,
    so_cmnd VARCHAR(45),
    luong VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);
CREATE TABLE loai_khach (
    id_loai_khach INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_loai_khach VARCHAR(45)
);
CREATE TABLE khach_hang (
    id_khach_hang INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_loai_khach INT,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_cmtnd VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);
CREATE TABLE kieu_thue (
    id_kieu_thue INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_kieu_thue VARCHAR(45),
    gia INT
);
CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_loai_dich_vu VARCHAR(45)
);
CREATE TABLE dich_vu (
    id_dich_vu INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da VARCHAR(45),
    chi_phi_thue VARCHAR(45),
    id_kieu_thue INT,
    id_loai_dich_vu INT,
    trang_thai VARCHAR(45),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
);
CREATE TABLE hop_dong (
    id_hop_dong INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_nhan_vien INT,
    id_khach_hang INT,
    id_dich_vu INT,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
    FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)
);
CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ten_dich_vu_di_kem VARCHAR(45),
    gia INT,
    don_vi INT,
    trang_thai_kha_dung VARCHAR(45)
);
CREATE TABLE hop_dong_chi_tiet (
    id_hop_dong_chi_tiet INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    so_luong INT,
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem)
);

INSERT INTO vi_tri VALUES (1,'Le tan'),(2,'Phuc vu'),(3,'Chuyen vien'),(4,'Giam sat'),(5,'Quan li'),(6,'Giam doc');
INSERT INTO trinh_do VALUES (1,'Trung cap'),(2,'Cao dang'), (3,'Dai hoc'),(4,'Sau dai hoc');
INSERT INTO bo_phan VALUES (1,'Sale-Marketing'), (2,'Hanh chinh'),(3,'Phuc vu'),(4,'Quan ly');
INSERT INTO loai_khach VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Silver'),(5,'Member');
INSERT INTO kieu_thue VALUES(1,'năm',90000000),(2,'tháng',1200000),(3,'ngày',2000000),(4,'giờ',200000);
INSERT INTO loai_dich_vu VALUES(1,'Villa'),(2,'House'),(3,'Room');

INSERT INTO dich_vu_di_kem
VALUES
(1,'massage',500000,1,'available'),
(2,'karaoke',400000,1,'available'),
(3,'thức ăn',300000,1,'available'),
(4,'nước uống',200000,1,'available'),
(5,'thuê xe di chuyển tham quan resort',100000,1,'available');

INSERT INTO khach_hang
VALUES
(1,1,'Nguyen Thi Hong','1999-01-02','12341234','0984769769','nguyenhong@gmail.com','Quang Tri'),
(2,2,'Dang Van Tuan','1998-02-03','12341234','0984769769','dangtuan@gmail.com','Quang Binh'),
(3,3,'Le Duc Khoa','1997-03-04','12341234','0984769769','lekhoa@gmail.com','Hai Duong'),
(4,4,'Tran Quoc Loc','1996-04-05','12341234','0984769769','tranloc@gmail.com','Đa Nang'),
(5,5,'Le Trung Hau','1995-05-06','12341234','0984769769','lehau@gmail.com','Ha Noi'),
(6,1,'Dang Cong Thanh','1994-08-05','12341234','0984769769','mail@gmail.com','Quang Tri'),
(7,2,'Nguyen My Huong','1993-09-04','12341234','0984769769','mail@gmail.com','Đa Nang'),
(8,3,'Pham Duc Huy','1992-10-03','12341234','0984769769','mail@gmail.com','HCM'),
(9,4,'Ngo Duc Lam','1991-11-02','12341234','0984769769','mail@gmail.com','Quang Nam'),
(10,5,'Le Gia Han','1990-12-01','12341234','0984769769','mail@gmail.com','Ha Noi');


INSERT INTO dich_vu
VALUES
(1,'thuê villa',300,3,'12',5000000, 1, 1,'available'),
(2,'thuê house',200,2,'9',4000000, 2, 2,'available'),
(3,'thuê room',100,1,'3',3000000, 3, 3,'available');

INSERT INTO nhan_vien
VALUES
(1,'Nguyen Thanh Nam',5,2,1,'1990-02-12',12341234,50000000,0984769769,'mail@gmail.com','Đà Nẵng'),
(2,'Nguyen Van Hai',2,1,2,'1991-11-12',12341234,5000000,0984769769,'mail@gmail.com','Đà Nẵng'),
(3,'Nguyen Ngoc Hanh',6,2,3,'1992-12-13',12341234,5000000,0984769769,'mail@gmail.com','Quảng Nam'),
(4,'Ly Thi Ha',2,3,4,'1993-01-12',12341234,10000000,0984769769,'mail@gmail.com','Đà Nẵng'),
(5,'Truong Van Hoa',3,3,1,'1994-02-09',12341234,10000000,0984769769,'mail@gmail.com','HCM'),
(6,'Trinh Van Khanh',1,1,2,'1995-02-17',12341234,20000000,0984769769,'mail@gmail.com','Hà Nội'),
(7,'Le Hong Ngoc',2,2,1,'1996-03-12',12341234,20000000,0984769769,'mail@gmail.com','Hai Phòng'),
(8,'Ly Duc Thinh',4,4,3,'1997-04-12',12341234,50000000,0984769769,'mail@gmail.com','Đà Nẵng'),
(9,'Hoang Duc Man',6,3,1,'1998-05-18',12341234,30000000,0984769769,'mail@gmail.com','Đà Nẵng'),
(10,'Vo My Hang',4,4,1,'1999-06-12',12341234,40000000,0984769769,'mail@gmail.com','Quảng Nam');

INSERT INTO hop_dong
VALUES
(1, 1, 1, 1, '2020-12-12', '2021-12-30', 3000000, 5000000),
(2, 3, 2, 2, '2019-02-13','2019-03-20', 400000, 6000000),
(3, 1, 3, 3, '2018-03-14','2018-04-20', 500000, 7000000),
(4, 3, 4, 1, '2021-04-15','2021-05-20', 500000, 8000000),
(5, 1, 5, 3, '2020-05-16','2021-06-22', 6000000, 90000000);

INSERT INTO hop_dong_chi_tiet
VALUES
(1,1,2,2),
(2,2,1,3),
(3,3,3,1),
(4,4,2,2),
(5,5,1,3);




