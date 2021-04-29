DROP DATABASE IF EXISTS WeatherAsia;
CREATE DATABASE IF NOT EXISTS WeatherAsia;
USE WeatherAsia;
CREATE TABLE IF NOT EXISTS `User`
(
	FacebookID 		VARCHAR(100) NOT NULL PRIMARY KEY,
    `Name`			VARCHAR(100),
    `Email`			VARCHAR(100) NOT NULL UNIQUE KEY,
    `Address` 		NVARCHAR(255)    
);

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
    PRIMARY KEY(FacebookID,CityID),
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

SELECT * FROM country;

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

select * from city;
INSERT INTO 
	`City`	(CityName, CountryID, LabelName)
VALUES		
			("Hà Nội", 1, "Ha noi"),
			("Hải Phòng", 1, "Hai Phong"),
			("Hồ Chí Minh", 1, "Ho Chi Minh"),
            ("Huế", 1, "Hue"),
            ("Đà Nẵng", 1, "Da Nang"),
            ("Bắc Giang", 1, "Bac Giang"),
            ("Bandar Seri Begawan", 2, "Bandar Seri Begawan"),
            ("Seria",2,"Seria"),
            ("Temburong",2,"Temburong"),
            ("Panaga",2,"Panaga"),
            ("Tutong",2,"Tutong"),
            ("Kuala Belait",2,"Kuala Belait"),
            ("Phnum Penh",3,"Phnum Penh"),
            ("Siem Reap",3,"Siem Reap"),
            ("Battambang",3,"Battambang"),
            ("Sihanoukville",3,"Sihanoukville"),
            ("Kampot",3,"Kampot"),
            ("Vientiane",4,"Vientiane"),
            ("Pakxe",4,"Pakxe"),
            ("Xam Nua",4,"Xam Nua"),
            ("Phonsavan",4,"Phonsavan"),
            ("Thakhek",4,"Thakhek"),
            ("Jakarta",5,"Jakarta"),
            ("Surabaya",5,"Surabaya"),
            ("Bandung",5,"Bandung"),
            ("Manado",5,"Manado"),
            ("Padang",5,"Padang"),
            ("Medan",5,"Medan"),
            ("Kuala Lumpur",6,"Kuala Lumpur"),
            ("Kajang",6,"Kajang"),
            ("Klang",6,"Klang"),
            ("Subang Jaya",6,"Subang Jaya"),
            ("Petaling Jaya",6,"Petaling Jaya"),
            ("Kuantan",6,"Kuantan"),
            ("NayPyiTaw",7,"NayPyiTaw"),
            ("Yangon",7,"Yangon"),
            ("Mandalay",7,"Mandalay"),
            ("Bagan",7,"Bagan"),
            ("Mrauk-U",7,"Mrauk-U"),
            ("Pathein",7,"Pathein"),
            ("Manila",8,"Manila"),
            ("Quezon",8,"Quezon"),
            ("Caloocan",8,"Caloocan"),
            ("Davao",8,"Davao"),
            ("Cebu",8,"Cebu"),
            ("Zamboanga",8,"Zamboanga"),
            ("BangKok",9,"BangKok"),
            ("Nonthaburi",9,"Nonthaburi"),
            ("Chiang Mai",9,"Chiang Mai"),
            ("Udon Thani",9,"Udon Thani"),
            ("Khon Kaen",9,"Khon Kaen"),
            ("Phitsanulok",9,"Phitsanulok"),
            ("Singapore",10,"Singapore"),
            ("Jurong Town",10,"Jurong Town"),
            ("Choa Chu Kang",10,"Choa Chu Kang"),
            ("Yishun",10,"Yishun"),
            ("Pungol",10,"Pungol"),
            ("Tampines",10,"Tampines")
            