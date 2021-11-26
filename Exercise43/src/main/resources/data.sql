DROP TABLE IF EXISTS ENROLMENTS;
DROP TABLE IF EXISTS SESSIONS;
DROP TABLE IF EXISTS HOBBIES;
DROP TABLE IF EXISTS PERSONS;
DROP TABLE IF EXISTS COMPANIES;
DROP TABLE IF EXISTS COURSES;
 
CREATE TABLE COMPANIES
(CONO      INT  AUTO_INCREMENT  primary key,
 CONAME    CHAR(45) NOT NULL,
 COSTREET  VARCHAR(45) NOT NULL,
 COSTRNO   VARCHAR(10),
 COTOWN    CHAR(45) NOT NULL,
 COTOWNNO  CHAR(10),
 COCOUNTR  CHAR(4),
 COTEL     CHAR(16),
 COVAT     CHAR(11),
 COBANKNO  CHAR(14)
);

CREATE TABLE PERSONS
(PNO         INT  AUTO_INCREMENT  primary key,
 PLNAME      CHAR(40) NOT NULL,
 PFNAME      VARCHAR(15),
 PBIRTHDATE  DATE,
 PEMAIL      VARCHAR(50),
 PPASS       VARCHAR(40),
 PLANG       CHAR(3),
 PA_CONO     INT ,
 CONSTRAINT FK_COMPANY FOREIGN KEY (PA_CONO) REFERENCES COMPANIES
);

CREATE TABLE COURSES
(CID       INT AUTO_INCREMENT primary key,
 CSTITLE   CHAR(45) NOT NULL,
 CLTITLE   VARCHAR(60),
 CDUR      INT   NOT NULL,
 CAPRICE   NUMERIC(9,2) NOT NULL
);

CREATE TABLE SESSIONS
(SNO       INT AUTO_INCREMENT  primary key,
 SDATE     DATE NOT NULL,
 SINS_PNO  INT,
 SLOC_CONO INT,
 SKIND     CHAR(1) NOT NULL,
 SINCOMES  NUMERIC(9,2) NOT NULL,
 SCANCEL   CHAR(1),
 S_CID     INT,
  CONSTRAINT FK_INSTRUCTOR FOREIGN KEY (SINS_PNO) REFERENCES PERSONS,
  CONSTRAINT FK_LOCATION FOREIGN KEY (SLOC_CONO) REFERENCES COMPANIES,
  CONSTRAINT FK_COURSE FOREIGN KEY (S_CID) REFERENCES COURSES
);

CREATE TABLE ENROLMENTS
(E_SNO   INT NOT NULL,
 ENO     INT NOT NULL,
 E_PNO   INT,
 EPAY    NUMERIC(9,2) NOT NULL,
 E_CONO  INT,
 ECANCEL CHAR(1),
 CONSTRAINT FK_SESSION FOREIGN KEY (E_SNO) REFERENCES SESSIONS ON DELETE CASCADE,
 CONSTRAINT FK_PERSON FOREIGN KEY (E_PNO) REFERENCES PERSONS,
 CONSTRAINT FK_EMPCOMPANY FOREIGN KEY (E_CONO) REFERENCES COMPANIES
);

CREATE TABLE HOBBIES(
    H_PNO INT NOT NULL,
    H_HNO INT NOT NULL,
    H_HOBBY VARCHAR(45),
    CONSTRAINT FK_PERSONHOBBY FOREIGN KEY (H_PNO) REFERENCES PERSONS ON DELETE CASCADE
);


INSERT INTO COMPANIES VALUES (1, 'LOC COMPUTER CORP.', 'RING', '189', 'BRUSSEL', '1020 ', 'B' , '02/6784523 ', '345-786-890', NULL);
INSERT INTO COMPANIES VALUES (2, 'DATAWISHES N.V.', 'AVENUE LAMBERT', '45 B6', 'BRUSSEL', '1060', 'B', '02/3421632 ', '403-146-747', '210-0040988-09');
INSERT INTO COMPANIES VALUES (3, 'ABIS N.V.', 'DIESTSEVEST', '32', 'LEUVEN', '3000', 'B', '016/245610', '423-345-567', '739-0000673-02');
INSERT INTO COMPANIES VALUES (4, 'ESCON', 'ANTONIUSLAAN', '2', 'GENT', '8200', 'B', '091/456213', '120-450-002', '009-4568791-45');
INSERT INTO COMPANIES VALUES (5, 'COVERDAT', 'WARMTESTRAAT', '67', 'NAARDEN', '1411 AR ', 'NL', '08879-3844', NULL, '003-780034-54');
INSERT INTO COMPANIES VALUES (6, 'ASC COMPANY', 'KAAI 345', '67 b5', 'ANTWERPEN', '2030', 'B', '03/3451298', '567-345-453', '009-0000345-45');
INSERT INTO COMPANIES VALUES (9, 'TECHNISOFT B.V.', 'ZWARTEWEG', '112', 'ROTTERDAM', '1420-WK', 'NL', '02977-22456', NULL, NULL);
INSERT INTO COMPANIES VALUES (10, 'BET MECHANICS NV.', 'INDUSTRIEPARK', '678', 'MECHELEN', '1240', 'B' , '015/348778 ', '009-568-562', '021-0000456-78');
INSERT INTO COMPANIES VALUES (11, 'CandC INTERNATIONAL', 'GOSWELL ROAD', '521', 'LONDON', 'EC1N7JQ', 'GB', '01 278 2377', NULL, NULL);
INSERT INTO COMPANIES VALUES (12, 'BROWN AG', 'HELGA FELD', '3', 'MUNICH', '8906', 'D', '7-6566', NULL, NULL);
INSERT INTO COMPANIES VALUES (13, 'FLYGT', 'HOOGSTRAAT', '67 ', 'TERNAT', '1200', 'B', '02/7800056', '900-120-324', '021-456098-45');
INSERT INTO COMPANIES VALUES (15, 'DIRECT SOFT Ltd.', 'CORPORATION STREET', '14', 'BIRMINGHAM', 'B2 4RN', 'GB' , '021 643 5072', NULL, NULL);
INSERT INTO COMPANIES VALUES (17, 'POUDRE BELGE', 'RUE D''EAU', '67', 'NAMUR', '7200', 'B', '042/563409', '900-678-232', '009-4560004-56');
INSERT INTO COMPANIES VALUES (20, 'OLIVER', 'GASTSTRAAT', '243', 'HASSELT', '3500', 'B', '011/459123', '451-546-789', '458-1285006-45');
INSERT INTO COMPANIES VALUES (21, 'PROCESS', 'DESGUINLEI', '109 B56', 'ANTWERPEN', '2030', 'B', '03/3456723', '789-456-234', '410-4567894-67');
INSERT INTO COMPANIES VALUES (22, 'BELGISCHE BANK', 'HOOFDSTRAAT', '675', 'ANTWERPEN', '2000', 'B', '03/3451078', '567-231-430', '554-4620439-45');
INSERT INTO COMPANIES VALUES (25, 'DIEMEN', 'HEERBAAN', '250', 'AMSTERDAM', '1014 BA', 'NL', '01720-45665', NULL, NULL);
INSERT INTO COMPANIES VALUES (32, 'BERENDSEN CP', 'EXSELSIORLAAN', '67 B45', 'BRUSSEL', '1220', 'B', '02/4568791', '125-002-021', '009-4587661-12');
INSERT INTO COMPANIES VALUES (41, 'RALBERG', 'SCHIPHOLWEG', '34', 'LEIDEN', '6574 HK', 'NL', '071-218112', NULL, NULL);
INSERT INTO COMPANIES VALUES (42, 'EDUCA Ltd.', 'WORSHIP STREET', '74', 'LONDON', 'EC2A 2EN', 'GB', '01 377 4645', NULL, NULL);
INSERT INTO COMPANIES VALUES (43, 'COMPUTRAIN', 'SCHIEDAMSE VEST', '99A', 'ROTTERDAM', '3012', 'NL', '010-4134409', NULL, NULL);
INSERT INTO COMPANIES VALUES (46, 'ASSUR', 'GRASMARKT', '67', 'GENT', '8000', 'B', '091/450065', '021-102-212', '079-4580056-45');
INSERT INTO COMPANIES VALUES (52, 'BANC', 'AVENUE LOUISE', '78 B4', 'BRUSSEL ', '1000', 'B', '02/4561236 ', '002-456-442', '079-0007549-05');
INSERT INTO COMPANIES VALUES (104, 'ASCO', 'DEEP LANE', '1A ', 'OXFORD', 'RG211RY', 'GB', '0256 469460', NULL, '000-111111-54');


INSERT INTO PERSONS VALUES (1, 'SMITHS', 'JAN', '1979-12-22','jan.smiths@abis.be','js123','NL',3);
INSERT INTO PERSONS VALUES (2, 'TAVERNIER', 'PETER', '1968-04-15','peter.tavernier@abis.be','pt456','FR', 3);
INSERT INTO PERSONS VALUES (3, 'DE KEYSER', 'ANN', '1982-02-02','ann.dekeyser@abis.be','adk789','NL', 3);
INSERT INTO PERSONS VALUES (5, 'NIEHOF', 'RUUD ', '1971-01-18','ruud.niehof@computrain.nl','rn123','NL', 43);
INSERT INTO PERSONS VALUES (6, 'VAN HEIJKOOP', 'GERT ', '1993-05-19','gert.vanheijkoop@computrain.nl','gvh456','NL', 43);
INSERT INTO PERSONS VALUES (7, 'DE GROOT', 'ATY','1965-11-05','aty.degroot@computrain.nl','adg789','NL', 43);
INSERT INTO PERSONS VALUES (8, 'PEREZ', 'MARIA', '1975-10-30','maria.perez@datawishes.be','mp123','FR', 2);
INSERT INTO PERSONS VALUES (9, 'LIVIER', 'FRANCOIS', '1967-08-08','francois.livier@datawishes.be','fl456','FR', 2);
INSERT INTO PERSONS VALUES (10, 'LUTZ', 'CHRISTINE', '1974-06-18','christine.lutz@datawishes.be','cl789','DE',2);
INSERT INTO PERSONS VALUES (11, 'LOOSE', 'KOEN', '1984-01-08','koen.loose@gmail.com','kl123','NL', NULL);
INSERT INTO PERSONS VALUES (12, 'BENOIT', 'PHILIP', '1999-07-11','philip.benoit@loc.com','pb456','FR', 1);
INSERT INTO PERSONS VALUES (13, 'BENOIT', 'DIRK', '1973-07-27','dirk.benoit@loc.com','db789','NL', 1);
INSERT INTO PERSONS VALUES (14, 'DETROIT', 'DANNY', '1969-10-04','danny.detroit@berendsen.be','dd123','NL', 32);
INSERT INTO PERSONS VALUES (15, 'SPENCER', 'THEODORE', '1987-03-24','theodore.spencer@direct.uk','ts456','EN', 15);
INSERT INTO PERSONS VALUES (17, 'SCHUMACHER', 'RAF', '1975-06-30','raf.schumacher@brown.de','rs456','DE', 12);
INSERT INTO PERSONS VALUES (18, 'GELADE', 'BENNY','1970-09-08','benny.gelade@banc.be','bg789','NL', 52);
INSERT INTO PERSONS VALUES (19, 'COPPIETERS', 'CARLA', '1983-04-11','carla.coppieters@banc.be','cc123','NL', 52);
INSERT INTO PERSONS VALUES (20, 'DE WINDT', 'BART', '1997-02-13','bart.dewindt@banc.be','bdw123','NL', 52);
INSERT INTO PERSONS VALUES (21, 'DE SCHRIJVER', 'ERIK', '1982-05-03','erik.deschrijver@process.be','eds456','NL', 21);
INSERT INTO PERSONS VALUES (22, 'HENDERSON', 'DAVID', '1989-12-22','david.henderson@belgischebank.be','dh789','EN', 22);
INSERT INTO PERSONS VALUES (23, 'DELANGHE', 'GUIDO', '1964-02-28','guido.delanghe@belgischebank.be','gd123','NL', 22);
INSERT INTO PERSONS VALUES (24, 'VAN DE BROECK', 'LARS', '1991-10-17','lars.vandebroeck@coverdat.nl','lvdb456','NL', 5);
INSERT INTO PERSONS VALUES (25, 'MEURIS', 'FRITS', '1981-11-22','frits.meuris@coverdat.nl','fm789','NL', 5);
INSERT INTO PERSONS VALUES (26, 'HEBBELYNCK', 'HENK', '1966-07-08','henk.hebbelynck@coverdat.nl','hh123','NL', 5);
INSERT INTO PERSONS VALUES (28, 'TYTGAT', 'ALEX', '1985-08-07','alex.tytgat@assur.be','at456','NL',46);
INSERT INTO PERSONS VALUES (29, 'DEVISSER', 'JULES', '1995-03-13','jules.devisser@assur.be','jd789','NL', 46);
INSERT INTO PERSONS VALUES (32, 'BUENK', 'GERT-JAN ', '1973-09-01','gertjan.buenk@technisoft.nl','gjb123','NL', 9);
INSERT INTO PERSONS VALUES (33, 'PIELAGE', 'ROB', '1986-09-19','rob.pielage@diemen.nl','rp456','NL', 25);
INSERT INTO PERSONS VALUES (34, 'DE BRUYN', 'PATRICK', '1971-05-05','patrick.debruyn@asc.be','pdb789','NL', 6);
INSERT INTO PERSONS VALUES (35, 'DE SMET', 'JOREN', '1995-07-16','joren.desmet@flygt.be','jds123','NL', 13);
INSERT INTO PERSONS VALUES (36, 'ADAMSON', 'BRUCE', '1989-09-06','bruce.adamson@candc.uk','ba456','EN', 11);
INSERT INTO PERSONS VALUES (43, 'DEHEM', 'JEAN', '1979-04-21','jean.dehem@poudre.be','jd789','FR', 17);
INSERT INTO PERSONS VALUES (47, 'GOYENS', 'FIONA', '1987-09-28','fiona.goyens@berendsen.be','fg123','FR', 32);
INSERT INTO PERSONS VALUES (48, 'GERRIES', 'GLORIA', '1967-12-01','gloria.gerries@berendsen.be','fg456','FR', 32);
INSERT INTO PERSONS VALUES (49, 'DE CORTE', 'EDMOND', '1969-10-03','edmond.decorte@berendsen.be','edc789','NL', 32);
INSERT INTO PERSONS VALUES (50, 'DE WILDE', 'PIERRE', '1965-11-10','pierre.dewilde@berendsen.be','pdw789','FR', 32);
INSERT INTO PERSONS VALUES (56, 'PARKER', 'LEWIS', '1996-03-20','lewis.parker@educa.uk','lp123','EN', 42);
INSERT INTO PERSONS VALUES (66, 'MOORS', 'SYLVAIN', '1966-08-31','sylvain.moors@escon.be','smo456','NL', 4);
INSERT INTO PERSONS VALUES (87, 'DEWULF', 'NICOLAS', '1966-08-31','nicolas.dewulf@betmechanics.be','ndw789','NL', 10);
INSERT INTO PERSONS VALUES (92, 'OLIVER', 'PAUL', '1978-02-09','paul.oliver@oliver.be','po789','NL', 20);
INSERT INTO PERSONS VALUES (104, 'NICHOLLS', 'DOUG', '1985-10-19','doug.nicholls@asco.uk','dn123','EN', 104);
INSERT INTO PERSONS VALUES (132, 'BUNE', 'JAN', '1983-11-20','jan.bune@ralberg.nl','jb456','NL', 41);
INSERT INTO PERSONS VALUES (133, 'KOOPS', 'BERT', '1968-06-25','bert.koops@ralberg.nl','bk789','NL', 41);
INSERT INTO PERSONS VALUES (134, 'MAK', 'LOUIS', '1986-12-12','louis.mak@ralberg.nl','lm123','NL',41);
INSERT INTO PERSONS VALUES (135, 'DOE', 'JOHN', '1956-08-12','john.doe@gmail.com','jd456','EN', NULL);


INSERT INTO COURSES VALUES (7800, 'IMSADFII', 'Development of conversational transactions using IMSADFII', 5, 550.00);
INSERT INTO COURSES VALUES (7801, 'IMSADFIIADV', 'IMSADFII Advanced Topics', 3, 550.00);
INSERT INTO COURSES VALUES (7810, 'ADFPLUS', 'ADFPLUS preprocessors and utilities', 2, 550.00);
INSERT INTO COURSES VALUES (7820, 'IMSDB', 'IMS/DB application programming ', 5, 550.00);
INSERT INTO COURSES VALUES (7830, 'IMSDC', 'IMS/DC application programming ', 3, 550.00);
INSERT INTO COURSES VALUES (7840, 'IMSDBIMPL', 'Implementation of physical IMS data bases', 3, 550.00);
INSERT INTO COURSES VALUES (7850, 'DB2BAS', 'DB2, an overview', 5, 550.00);
INSERT INTO COURSES VALUES (7890, 'ISPF', 'ISPF dialog management services', 3, 550.00);
INSERT INTO COURSES VALUES (7900, 'SQLWS', 'Workshop SQL', 3, 550.00);
INSERT INTO COURSES VALUES (8001, 'SYSDEV', 'System development : management and methodology', 2, 550.00);
INSERT INTO COURSES VALUES (8002, 'PROJMAN', 'Projectmanagement', 4, 550.00);
INSERT INTO COURSES VALUES (8003, 'SYSANALYSIS', 'System analysis', 5, 550.00);
INSERT INTO COURSES VALUES (8004, 'SYSDESIGN', 'System design', 5, 550.00);
INSERT INTO COURSES VALUES (8005, 'STRUCPROG', 'Structured Programming', 5, 550.00);
INSERT INTO COURSES VALUES (8006, 'TECHWRITE', 'Writing, evaluation and correction of technical manuals', 1, 475.00);
INSERT INTO COURSES VALUES (8031, 'SAS1', 'SAS fundamentals course', 3, 550.00);
INSERT INTO COURSES VALUES (8032, 'SASADV', 'Advanced SAS course', 2, 550.00);
INSERT INTO COURSES VALUES (8041, 'CAPPLAN', 'Capacity planning : technics and strategies', 4, 550.00);
INSERT INTO COURSES VALUES (8043, 'PCLAN', 'Seminar : PC LAN', 1, 500.00);
INSERT INTO COURSES VALUES (8051, 'PCDOS', 'Workshop PC-DOS', 2, 375.00);
INSERT INTO COURSES VALUES (8052, 'DBASEPROG', 'DbaseIII (Plus) programming', 3, 375.00);
INSERT INTO COURSES VALUES (8053, 'CAD', 'CAD on PC', 1, 375.00);
INSERT INTO COURSES VALUES (8055, 'LOTUSPROG', 'LOTUS 123 (versie 2) programming', 3, 375.00);
INSERT INTO COURSES VALUES (8056, 'AUTOCAD', 'Training Autocad', 3, 500.00);


INSERT INTO SESSIONS VALUES (1, '2017-01-12', 1, 3, 'p', 4730.00, NULL, 7850);
INSERT INTO SESSIONS VALUES (2, '2017-01-12', 2, 3, 'p', 2250.00, NULL, 7830);
INSERT INTO SESSIONS VALUES (3, '2017-01-12', 3, 3, 'c', 4950.00, 'c', 7820);
INSERT INTO SESSIONS VALUES (4, '2017-03-15', 2, 3, 'p', 9000.00, NULL, 7830);
INSERT INTO SESSIONS VALUES (5, '2017-04-23', 2, 3, 'c', 6000.00, NULL, 7890);
INSERT INTO SESSIONS VALUES (6, '2017-04-14', 36, 3, 'p', 5615.00, 'C', 7820);
INSERT INTO SESSIONS VALUES (7, '2017-04-21', 3, 5, 'p', 3350.00, NULL, 7900);
INSERT INTO SESSIONS VALUES (8, '2018-01-15', 3, 22, 'c', 13900.00, NULL, 7900);
INSERT INTO SESSIONS VALUES (9, '2018-03-17', 26, 10, 'p', 2250.00, 'C', 7820);
INSERT INTO SESSIONS VALUES (10,'2018-05-11', 3, 3, 'c', 0.00, 'C', 7850);
INSERT INTO SESSIONS VALUES (11,'2018-06-14', 1, 3, 'c', 4000.00, NULL, 8043);
INSERT INTO SESSIONS VALUES (12,'2018-06-13', 3, 5, 'p', 5600.00, NULL, 7800);
INSERT INTO SESSIONS VALUES (13,'2018-05-11', 3, 3, 'c', 6250.00, NULL, 8001);
INSERT INTO SESSIONS VALUES (14,'2018-05-11', 2, 3, 'c', 5000.00, NULL, 7900);
INSERT INTO SESSIONS VALUES (15,'2018-05-11', 36, 3, 'p', 4500.00, NULL, 7840);
INSERT INTO SESSIONS VALUES (16,'2019-01-10', 36, 3, 'p', 10150.00, NULL, 7900);
INSERT INTO SESSIONS VALUES (17,'2019-01-10', 36, 10,'p', 0.00, NULL, 7900);

INSERT INTO ENROLMENTS VALUES (1, 1, 25, 385.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (1, 2, 18, 500.00, 52, 'C');
INSERT INTO ENROLMENTS VALUES (1, 3, 24, 385.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (1, 4, 104, 495.00, 104, NULL);
INSERT INTO ENROLMENTS VALUES (1, 5, 132, 550.00, 3, NULL);
INSERT INTO ENROLMENTS VALUES (2, 1, 15, 385.00, 15, NULL);
INSERT INTO ENROLMENTS VALUES (2, 2, 22, 385.00, 22, NULL);
INSERT INTO ENROLMENTS VALUES (2, 3, 23, 385.00, 22, NULL);
INSERT INTO ENROLMENTS VALUES (3, 1, 25, 385.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (4, 1, 17, 550.00, 12, 'C');
INSERT INTO ENROLMENTS VALUES (4, 2, 6, 550.00, 43, NULL);
INSERT INTO ENROLMENTS VALUES (4, 3, 7, 550.00, 43, NULL);
INSERT INTO ENROLMENTS VALUES (4, 4, 5, 550.00, 43, NULL);
INSERT INTO ENROLMENTS VALUES (6, 1, 3, 0.00, 3, NULL);
INSERT INTO ENROLMENTS VALUES (6, 2, 9, 440.00, 2, 'C');
INSERT INTO ENROLMENTS VALUES (6, 3, 10, 440.00, 2, NULL);
INSERT INTO ENROLMENTS VALUES (6, 4, 34, 550.00, 6, NULL);
INSERT INTO ENROLMENTS VALUES (6, 5, 35, 550.00, 13, NULL);
INSERT INTO ENROLMENTS VALUES (6, 6, 47, 550.00, 43, NULL);
INSERT INTO ENROLMENTS VALUES (6, 7, 48, 550.00, 32, NULL);
INSERT INTO ENROLMENTS VALUES (6, 8, 28, 495.00, 46, NULL);
INSERT INTO ENROLMENTS VALUES (7, 1, 25, 330.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (7, 2, 18, 375.00, 52, NULL);
INSERT INTO ENROLMENTS VALUES (7, 3, 24, 375.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (7, 4, 104, 495.00, 104, NULL);
INSERT INTO ENROLMENTS VALUES (7, 5, 132, 440.00, 41, NULL);
INSERT INTO ENROLMENTS VALUES (8, 1, 3, 0.00, 3, NULL);
INSERT INTO ENROLMENTS VALUES (8, 2, 9, 440.00, 2, NULL);
INSERT INTO ENROLMENTS VALUES (8, 3, 10, 440.00, 2, NULL);
INSERT INTO ENROLMENTS VALUES (8, 4, 34, 550.00, 6, NULL);
INSERT INTO ENROLMENTS VALUES (8, 5, 35, 550.00, 13, NULL);
INSERT INTO ENROLMENTS VALUES (8, 6, 36, 550.00, 11, 'C');
INSERT INTO ENROLMENTS VALUES (8, 7, 48, 495.00, 32, 'C');
INSERT INTO ENROLMENTS VALUES (8, 9, 49, 495.00, 32, NULL);
INSERT INTO ENROLMENTS VALUES (8, 10, 50, 495.00, 32, NULL);
INSERT INTO ENROLMENTS VALUES (8, 11, 24, 550.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (8, 12, 25, 550.00, 5, NULL);
INSERT INTO ENROLMENTS VALUES (9, 1, 25, 499.95, 52, NULL);

INSERT INTO HOBBIES VALUES(1,1,'READING');
INSERT INTO HOBBIES VALUES(1,2,'FITNESS');
INSERT INTO HOBBIES VALUES(3,1,'YOGA');
INSERT INTO HOBBIES VALUES(3,2,'GAMING');
INSERT INTO HOBBIES VALUES(3,3,'READING');

commit;
	 