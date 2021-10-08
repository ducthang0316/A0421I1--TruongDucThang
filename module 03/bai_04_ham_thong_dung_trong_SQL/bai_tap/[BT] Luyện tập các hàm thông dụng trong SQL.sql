use b02_th_quan_ly_sv;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject s 
where s.Credit = (select max(Credit) from subject) ;

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select s.SubName, s.Credit, m.Mark from subject s 
join mark m on s.SubId = m.SubId
where m.Mark = (select max(Mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.StudentId, s.StudentName, avg(Mark) as diem_tb from student s
join mark m on s.StudentId = m.StudentId
group by s.StudentId, s.StudentName
order by avg(Mark) desc;
