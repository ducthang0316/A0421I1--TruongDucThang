use case_study;
 
select * from nhan_vien;

select * from khach_hang;

select * from hop_dong;

select * from hop_dong_chi_tiet;

SELECT 
    * , CHAR_LENGTH(ho_ten) AS so_ki_tu
FROM
    nhan_vien
WHERE
    (ho_ten LIKE 'h%' OR ho_ten LIKE 't%'
        OR ho_ten LIKE 'k%')
        AND CHAR_LENGTH(ho_ten) <= 15;
 
 -- task 3  
SELECT 
    *, ROUND ( DATEDIFF (CURDATE(), ngay_sinh) / 365, 0) AS tuoi
FROM
    khach_hang
WHERE
    (dia_chi = 'da nang'
        OR dia_chi = 'quang tri')
        AND (ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) BETWEEN 18 AND 50);
 
 -- task 4
SELECT 
    *,
    COUNT(hop_dong.id_khach_hang) AS 'so_lan_dat'
FROM
    khach_hang
        JOIN
    hop_dong ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
WHERE
    khach_hang.id_loai_khach = 1
ORDER BY (so_lan_dat);
 
 -- task 5 
SELECT 
    khach_hang.id_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.id_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    hop_dong_chi_tiet.so_luong,
    dich_vu_di_kem.gia,
    dich_vu.chi_phi_thue,
    dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia 'tong_tien'
FROM
    khach_hang
        JOIN
    loai_khach ON khach_hang.id_loai_khach = loai_khach.id_loai_khach
        JOIN
    hop_dong ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
        JOIN
    dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem;
 
 -- task 6 
SELECT 
    dich_vu.id_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    dich_vu.ten_dich_vu
FROM
    dich_vu
WHERE
    NOT EXISTS( SELECT 
            dich_vu.id_dich_vu
        FROM
            hop_dong
        WHERE
            dich_vu.id_dich_vu = hop_dong.id_dich_vu
                AND (hop_dong.ngay_lam_hop_dong > '2019-01-01'
                AND hop_dong.ngay_lam_hop_dong < '2019-04-01'));
                
 
 -- task 7 
SELECT 
    dich_vu.id_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.so_nguoi_toi_da,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        JOIN
    loai_dich_vu ON loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
WHERE
    EXISTS( SELECT 
            hop_dong.id_dich_vu
        FROM
            hop_dong
        WHERE
            hop_dong.id_dich_vu = dich_vu.id_dich_vu
                AND (hop_dong.ngay_lam_hop_dong > '2018-01-01'
                AND hop_dong.ngay_lam_hop_dong < '2018-12-31'));
 
 -- task8
SELECT 
    khach_hang.ho_ten
FROM
    khach_hang
GROUP BY khach_hang.ho_ten;
SELECT 
    khach_hang.ho_ten
FROM
    khach_hang
ORDER BY khach_hang.ho_ten;
SELECT DISTINCT
    khach_hang.ho_ten
FROM
    khach_hang;	
    
    
-- task 9
SELECT 
    MONTH(hop_dong.ngay_lam_hop_dong),
    YEAR(hop_dong.ngay_lam_hop_dong),
    SUM(tong_tien) 'revenue_per_month'
FROM
    hop_dong
WHERE
    YEAR(hop_dong.ngay_lam_hop_dong) = '2019'
GROUP BY MONTH(hop_dong.ngay_lam_hop_dong) , YEAR(hop_dong.ngay_lam_hop_dong);

-- task 10
SELECT 
    hop_dong.id_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    hop_dong.tien_dat_coc,
    hop_dong_chi_tiet.so_luong 'so_luong_dich_vu_di_kem'
FROM
    hop_dong
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong;

-- task 11
SELECT 
	khach_hang.id_khach_hang, 
    loai_khach.ten_loai_khach,
    dich_vu_di_kem.ten_dich_vu_di_kem
FROM
    hop_dong
        JOIN
    khach_hang ON hop_dong.id_khach_hang = khach_hang.id_khach_hang
        JOIN
    loai_khach ON loai_khach.id_loai_khach = khach_hang.id_loai_khach
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
    WHERE
    loai_khach.id_loai_khach = 1
        AND (khach_hang.dia_chi = 'quang ngai'
        OR khach_hang.dia_chi = 'vinh');
        
-- task 12
SELECT 
    hop_dong.id_hop_dong,
    nhan_vien.ho_ten 'ho ten nhan vien',
    khach_hang.ho_ten 'ho ten khach hang',
    khach_hang.sdt 'so dth khach hang',
    dich_vu.ten_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    hop_dong_chi_tiet.so_luong,
    hop_dong.tien_dat_coc,
    hop_dong.ngay_lam_hop_dong
FROM
    hop_dong
        JOIN
    nhan_vien ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
        JOIN
    khach_hang ON khach_hang.id_khach_hang = hop_dong.id_khach_hang
        JOIN
    dich_vu ON hop_dong.id_dich_vu = dich_vu.id_dich_vu
        JOIN
    hop_dong_chi_tiet ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
        JOIN
    dich_vu_di_kem ON dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
WHERE
    hop_dong.ngay_lam_hop_dong < '2019-12-31'
        AND hop_dong.ngay_lam_hop_dong > '2019-09-30';

-- task 13
SELECT 
    dich_vu_di_kem.id_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    hop_dong_chi_tiet.so_luong,
    SUM(hop_dong_chi_tiet.so_luong) 'so_lan_duoc_dung'
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
GROUP BY dich_vu_di_kem.id_dich_vu_di_kem;

-- task 14
SELECT 
    hop_dong.id_hop_dong,
    hop_dong.id_dich_vu,
    loai_dich_vu.ten_loai_dich_vu,
    hop_dong_chi_tiet.id_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    hop_dong_chi_tiet.so_luong
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
        JOIN
    dich_vu ON dich_vu.id_dich_vu = hop_dong.id_dich_vu
        JOIN
    loai_dich_vu ON dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu;
-- task 15
SELECT 
    nhan_vien.id_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.sdt,
    nhan_vien.dia_chi,
    COUNT(hop_dong.id_hop_dong) 'so_luong_hop_dong',
    hop_dong.ngay_lam_hop_dong
FROM
    nhan_vien
        JOIN
    trinh_do ON nhan_vien.id_trinh_do = trinh_do.id_trinh_do
        JOIN
    bo_phan ON bo_phan.id_bo_phan = nhan_vien.id_bo_phan
        JOIN
    hop_dong ON hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
GROUP BY nhan_vien.id_nhan_vien
 HAVING COUNT(hop_dong.id_hop_dong) > 3
 AND hop_dong.ngay_lam_hop_dong > '2018-01-01'
AND hop_dong.ngay_lam_hop_dong < '2019-01-01';
-- task 16
DELETE
FROM
    nhan_vien
WHERE
    NOT EXISTS( SELECT 
            *, COUNT(hop_dong.id_hop_dong)
        FROM
            hop_dong
        WHERE
            nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
        GROUP BY nhan_vien.id_nhan_vien
        HAVING COUNT(hop_dong.id_hop_dong) > 0
            AND (hop_dong.ngay_lam_hop_dong < '2019-12-31'
            AND hop_dong.ngay_lam_hop_dong > '2017-01-01'));
-- task 17
