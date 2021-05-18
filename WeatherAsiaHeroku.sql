DROP DATABASE IF EXISTS heroku_b127bd7a389e7b4;
CREATE DATABASE IF NOT EXISTS heroku_b127bd7a389e7b4;
USE heroku_b127bd7a389e7b4;
CREATE TABLE IF NOT EXISTS `User`
(
	FacebookID 		VARCHAR(100) NOT NULL PRIMARY KEY,
    `Name`			NVARCHAR(100),
    `Email`			VARCHAR(100) NOT NULL UNIQUE KEY,
    `Address` 		NVARCHAR(255)    
);
ALTER TABLE  `User` ADD createDate DATETIME default NOW();

CREATE TABLE IF NOT EXISTS `Admin`
(
	Email 			VARCHAR(100) PRIMARY KEY,
    `Password`		VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `Country`
(
	ID				INT AUTO_INCREMENT PRIMARY KEY,
    CountryName		NVARCHAR(255) NOT NULL,
    CapitalName		NVARCHAR(255) NOT NULL,
    FlagImage		VARCHAR(800),
    `Description`		VARCHAR(100),
    LabelName		VARCHAR(255) NOT NULL
    
);

CREATE TABLE IF NOT EXISTS	`City`
(
	ID				INT AUTO_INCREMENT PRIMARY KEY,
    CityName		NVARCHAR(255) NOT NULL,
    CountryID		INT NOT NULL,
    `Description`	VARCHAR(100),
    LabelName		VARCHAR(255) NOT NULL,
	FOREIGN KEY (CountryID)  REFERENCES Country(ID)
);

CREATE TABLE IF NOT EXISTS `FavouriteCity`
(
	FacebookID	VARCHAR(100) NOT NULL,
    CityID		INT NOT NULL,
    primary key(FacebookID,CityID),
    FOREIGN KEY (FacebookID) REFERENCES `User`(FacebookID),
	FOREIGN KEY (CityID) REFERENCES `City`(ID)
);


/* ============================================INSERT DATA===============================================*/
INSERT INTO `Admin`
VALUES ("nchinh407@gmail.com",			"0a696ecb97bc9eba6ae5f99660efbfd6214e805ff3b2e808bdf1b9391f84f857"),
		("khanhdinh141@gmail.com",		"0a696ecb97bc9eba6ae5f99660efbfd6214e805ff3b2e808bdf1b9391f84f857"),
        ("khuatbatien2000@gmail.com",	"0a696ecb97bc9eba6ae5f99660efbfd6214e805ff3b2e808bdf1b9391f84f857");
        
        /*
INSERT `Admin`
VALUES ("admin",sha2("@dmin123456",256));

SELECT * FROM `Admin` WHERE `Password` = sha2("@dmin123456",256);
SELECT * FROM `Admin`;
*/



INSERT INTO 
		`Country`(CountryName,		CapitalName,		FlagImage,			LabelName)
VALUES 	
		("Việt Nam","Hà Nội","https://product.hstatic.net/200000122283/product/c-e1-bb-9d-vi-e1-bb-87t-nam_2c0683597d2d419fac401f51ccbae779_grande.jpg","Viet Nam"),	
        ("Brunei","Bandar Seri Begawan","https://ar.thpanorama.com/img/images_2/bandera-de-bruni-historia-y-significado.png","Brunei"),
        ("Campuchia","Phnom Penh","https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_Cambodia.svg/235px-Flag_of_Cambodia.svg.png","Campuchia"),
		("Laos","Vientiane","https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Flag_of_Laos.svg/225px-Flag_of_Laos.svg.png","Laos"),
		("Indonesia","Jakarta","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/225px-Flag_of_Indonesia.svg.png","Indonesia"),
		("Malaysia","Kuala Lumpur","https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Flag_of_Malaysia.svg/1200px-Flag_of_Malaysia.svg.png","Malaysia"),
		("Myanma","Naypyidaw","https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Flag_of_Myanmar.svg/225px-Flag_of_Myanmar.svg.png","Myanma"),
		("Philipines","Manila","https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Flag_of_the_Philippines.svg/300px-Flag_of_the_Philippines.svg.png","Philipines"),
		("Thái Lan","BangKok","https://sites.google.com/site/inmaycotoquoc/_/rsrc/1510655830040/tin-tuc/y-nghia-hinh-anh-tren-co-to-quoc-cua-cac-nuoc-dhong-nam-a/th%C3%A1i%20lan.png?height=266&width=400","Thai Lan"),
		("Singapore","Singapore","http://congtyxuatkhaulaodongsingapore.com/wp-content/uploads/2018/08/co-singapore-e1533113108841.jpg","Singapore"),
		("Đông Timor","Dili","https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Flag_of_East_Timor.svg/300px-Flag_of_East_Timor.svg.png","Đong Timor");


INSERT INTO 
	`City`	(CityName, CountryID, LabelName)
VALUES		
			("Hà Nội", 5, "Ha noi"),
			("Hải Phòng", 5, "Hai Phong"),
			("Hồ Chí Minh", 5, "Ho Chi Minh"),
            ("Huế", 5, "Hue"),
            ("Đà Nẵng", 5, "Da Nang"),
            ("Bắc Giang", 5, "Bac Giang"),
            ("Bandar Seri Begawan", 15, "Bandar Seri Begawan"),
            ("Seria",15,"Seria"),
            ("Temburong",15,"Temburong"),
            ("Panaga",15,"Panaga"),
            ("Tutong",15,"Tutong"),
            ("Kuala Belait",15,"Kuala Belait"),
            ("Phnum Penh",25,"Phnum Penh"),
            ("Siem Reap",25,"Siem Reap"),
            ("Battambang",25,"Battambang"),
            ("Sihanoukville",25,"Sihanoukville"),
            ("Kampot",25,"Kampot"),
            ("Vientiane",35,"Vientiane"),
            ("Pakxe",35,"Pakxe"),
            ("Xam Nua",35,"Xam Nua"),
            ("Phonsavan",35,"Phonsavan"),
            ("Thakhek",35,"Thakhek"),
            ("Jakarta",45,"Jakarta"),
            ("Surabaya",45,"Surabaya"),
            ("Bandung",45,"Bandung"),
            ("Manado",45,"Manado"),
            ("Padang",45,"Padang"),
            ("Medan",45,"Medan"),
            ("Kuala Lumpur",55,"Kuala Lumpur"),
            ("Kajang",55,"Kajang"),
            ("Klang",55,"Klang"),
            ("Subang Jaya",55,"Subang Jaya"),
            ("Petaling Jaya",55,"Petaling Jaya"),
            ("Kuantan",55,"Kuantan"),
            ("NayPyiTaw",65,"NayPyiTaw"),
            ("Yangon",65,"Yangon"),
            ("Mandalay",65,"Mandalay"),
            ("Bagan",65,"Bagan"),
            ("Mrauk-U",65,"Mrauk-U"),
            ("Pathein",65,"Pathein"),
            ("Manila",75,"Manila"),
            ("Quezon",75,"Quezon"),
            ("Caloocan",75,"Caloocan"),
            ("Davao",75,"Davao"),
            ("Cebu",75,"Cebu"),
            ("Zamboanga",75,"Zamboanga"),
            ("BangKok",85,"BangKok"),
            ("Nonthaburi",85,"Nonthaburi"),
            ("Chiang Mai",85,"Chiang Mai"),
            ("Udon Thani",85,"Udon Thani"),
            ("Khon Kaen",85,"Khon Kaen"),
            ("Phitsanulok",85,"Phitsanulok"),
            ("Singapore",95,"Singapore"),
            ("Jurong Town",95,"Jurong Town"),
            ("Choa Chu Kang",95,"Choa Chu Kang"),
            ("Yishun",95,"Yishun"),
            ("Pungol",95,"Pungol"),
            ("Tampines",95,"Tampines");

INSERT INTO `User`
VALUES ("ABC123456",	"NguyenChinh",    "cuanuong@gmail.com",      "Hà Nội"),
		("ABC12345678911",	"HaLan",    "cuanuong11@gmail.com",      "Hà Nội");