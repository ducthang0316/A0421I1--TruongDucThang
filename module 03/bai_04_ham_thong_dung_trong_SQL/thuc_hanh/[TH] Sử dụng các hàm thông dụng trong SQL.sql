use b02_th_quan_ly_sv;

SELECT 
    Address, COUNT(StudentId) AS 'Số lượng học viên'
FROM
    Student
GROUP BY Address;

SELECT 
    s.studentID, s.studentName, AVG(mark)
FROM
    student s
        JOIN
    mark m ON s.studentID = m.studentID
GROUP BY s.studentID , s.studentName;

SELECT 
    s.studentID, s.studentName, AVG(mark)
FROM
    student s
        JOIN
    mark m ON s.studentID = m.studentID
GROUP BY s.studentID , s.studentName
HAVING AVG(mark) > 15;

SELECT 
    S.StudentId, S.StudentName, AVG(Mark)
FROM
    Student S
        JOIN
    Mark M ON S.StudentId = M.StudentId
GROUP BY S.StudentId , S.StudentName
HAVING AVG(Mark) >= ALL (SELECT 
        AVG(Mark)
    FROM
        Mark
    GROUP BY Mark.StudentId);

