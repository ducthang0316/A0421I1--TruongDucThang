create database b02_bt_chuyen_doi_ERD;
use b02_bt_chuyen_doi_ERD;
CREATE TABLE Phieu_Xuat (
    so_PX INT AUTO_INCREMENT PRIMARY KEY,
    ngay_Xuat DATETIME
);

CREATE TABLE Phieu_Nhap (
    so_PN INT AUTO_INCREMENT PRIMARY KEY,
    ngay_Nhap DATETIME
);

CREATE TABLE Vat_Tu (
    ma_VTU VARCHAR(5) PRIMARY KEY,
    ten_VTU VARCHAR(50)
);

CREATE TABLE sdt_NCC_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sdt VARCHAR(10)
);

CREATE TABLE Nha_CC (
    ma_NCC VARCHAR(5) PRIMARY KEY,
    ten_NCC VARCHAR(100),
    dia_Chi VARCHAR(100),
    sdt_type_id INT,
    FOREIGN KEY (sdt_type_id)
        REFERENCES sdt_NCC_type (id)
);

CREATE TABLE Don_DH (
    so_DH INT AUTO_INCREMENT PRIMARY KEY,
    ngay_DH DATETIME,
    ma_NCC VARCHAR(5),
    FOREIGN KEY (ma_NCC)
        REFERENCES Nha_CC (ma_NCC)
);

CREATE TABLE xuat_detail (
    DG_xuat INT,
    SL_xuat INT,
    so_PX INT,
    ma_VTU VARCHAR(5),
    CONSTRAINT pk_pXuat_vTU PRIMARY KEY (so_PX , ma_VTU),
    FOREIGN KEY (so_PX)
        REFERENCES Phieu_Xuat (so_PX),
    FOREIGN KEY (ma_VTU)
        REFERENCES Vat_Tu (ma_VTU)
);

CREATE TABLE nhap_detail (
    DG_nhap INT,
    SL_nhap INT,
    so_PN INT,
    ma_VTU VARCHAR(5),
    CONSTRAINT pk_vTU_pNhap PRIMARY KEY (ma_VTU , so_PN),
    FOREIGN KEY (ma_VTU)
        REFERENCES Vat_Tu (ma_VTU),
    FOREIGN KEY (so_PN)
        REFERENCES Phieu_Nhap (so_PN)
);