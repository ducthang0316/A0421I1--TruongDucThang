create database bai_5_bt;
use bai_5_bt;
create table Song (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`name` varchar(255),
singer varchar(255),
`type` varchar(255),
link varchar(255)
);

insert into Song values
(1, "Stay", "Justin Bieber", "Pop", "https://www.nhaccuatui.com/bai-hat/stay-the-kid-laroi-ft-justin-bieber.F06BBF73KTkY.html"),
(2, "Easy On Me ", "Adele", "Acoustic", "https://www.nhaccuatui.com/bai-hat/easy-on-me-adele.JoWDf4auKbJn.html"),
(3, "Unstopable", "Sia", "EDM", "https://www.nhaccuatui.com/bai-hat/unstoppable-sia.PuY2t9ytBq8Q.html"),
(4, "Double Take", "Dhruv", "Pop", "https://www.nhaccuatui.com/bai-hat/double-take-dhruv.3SMhVpuWLL71.html"),
(5, "Dusk Till Dawn", "Zayn, Sia Bieber", "Pop", "https://www.nhaccuatui.com/bai-hat/dusk-till-dawn-zayn-ft-sia.XkUJCRQPdOGn.html");

select * from Song where id = 2;
