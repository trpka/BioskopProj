INSERT INTO ADMINISTRATOR (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('vtrpka','sifra123','Vladimir','Trpka','Administrator',true,'30.05.1999.','vladimir@gmail.com','0666662536');

INSERT INTO MENADZER (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('srago','123menadzer','Stefan','Rago','Menadzer',true,'13.08.1999.','srago@gmail.com','069545223');
INSERT INTO MENADZER (user_name,password,name,surname,Role,active,Date,email,contact_tel) 
VALUES ('sef','jasamsef','Nemanja','Nemanjic','Menadzer',true,'01.01.1986.','nemanja@gmail.com','063124578');

INSERT INTO GLEDAOC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('crnovsbelo', 'Sinisa','Nikolic','belibeli@gmail.com','Gledaoc','belibeli',true,'08.03.1983.','0698875123');
INSERT INTO GLEDAOC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('sezameotvorise', 'Radoje','Jovanovic','rasa45@gmail.com','Gledaoc','rasa45',true,'11.11.1945.','0933331245');
INSERT INTO GLEDAOC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('aaa123aaa', 'Ljubisa','Milos','ljuba86@gmail.com','Gledaoc','ljuba86',true,'04.08.1986.','0617852236');
INSERT INTO GLEDAOC (password,name,surname,email,role,user_name,active,Date,contact_tel) 
VALUES ('jasamjovica', 'Jovica','NIkolic','jovica@gmail.com','Gledaoc','jovica86',true,'04.08.1986.','0617852236');


INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Dzoker', 'afkjsfjabsfbsab','Drama',1.5,8,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Losi momci zauvek', 'fafasfsafsafas','Akcija',1.5,7.3,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Zaraza', 'fsfsadfsadfasdfsa','Akcija',2,5.6,false);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Juzni vetar', 'fdsfdsafsdafasdf','Drama',2,7.7,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Turneja', 'fsfsadfsadfasdfsa','Akcija',2,0,false);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Tito i ja', 'fsfsadfsadfasdfsa','Muzika',2,0,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Bekstvo iz Sosenka', 'fsfsadfsadfasdfsa','Ljubavni film',2.2,8.3,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Taksi bluz', 'fsfsadfsadfasdfsa','Ljubavni film',1.5,0,false);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Dobar los zao', 'fsfsadfsadfasdfsa','Drama',4,0,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Taksista', 'fsfsadfsadfasdfsa','Akcija',1.5,6.5,true);
INSERT INTO FILM (naziv,opis,zanr,trajanje,ocena,odgledan) 
VALUES ('Psiho', 'fsfsadfsadfasdfsa','Klasik',2,8.6,true);


INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Cineplex', 'Bulevat','854422','cineplex@gmail.com',2);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Oktagon', 'Cara Dusana','215666','oktagon@gmail.com',2);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Arena', 'Mise Dimitrijevica','852222','arena@gmail.com',1);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Arena2', 'Kosovska','4861512','arena2@gmail.com',1);
INSERT INTO BIOSKOP (naziv,adresa,br_centrale,email,manager_id) 
VALUES ('Cineplex2', 'Maksima gorkog','5522326','cineplex2@gmail.com',1);

INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (300,'G/A-2',5);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (150,'AB-7',2);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (500,'M3',4);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (200,'B4',3);
INSERT INTO SALA (kapacitet,oznaka,bioskop_id) 
VALUES (700,'A4',1);

INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (1,22,'11.11.2020',350,'17:05',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (2,25,'17.06.2020',350,'20:45',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (3,42,'01.01.2010',200,'14:45',false);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (4,12,'14.09.2020',200,'21:05',false);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (5,96,'14.12.2020',300,'22:00',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (6,76,'05.05.2020',250,'17:00',true);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (7,78,'13.07.2020',300,'21:45',false);
INSERT INTO PROJEKCIJA (film_id,broj_rezervacija,dan,cena,vreme,rezervisan) 
VALUES (8,44,'19.03.2020',250,'16:35',true);

