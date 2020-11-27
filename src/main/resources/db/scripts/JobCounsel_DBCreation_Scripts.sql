DROP TABLE IF EXISTS Reservation;
DROP TABLE IF EXISTS UserProfile;
DROP TABLE IF EXISTS Job;
DROP TABLE IF EXISTS Branch;
DROP TABLE IF EXISTS Organization;
DROP TABLE IF EXISTS ReservationTypes;
DROP TABLE IF EXISTS Sector;
DROP TABLE IF EXISTS Salary;

create table Sector(id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(200) NOT NULL,
stamp_created timestamp default now());

create table Branch(id INT PRIMARY KEY AUTO_INCREMENT,
name varchar(200) NOT NULL,
sectorid INT(11) NOT NULL,
stamp_created timestamp default now(),
FOREIGN KEY (sectorid) REFERENCES Sector(id));

create table Salary(id INT(11) PRIMARY KEY AUTO_INCREMENT,
lbound INT,
hbound INT,
currencytype VARCHAR(3) default 'INR',
salarymode VARCHAR(50),
stamp_created timestamp default now()
);

create table ReservationTypes(id INT(11) PRIMARY KEY AUTO_INCREMENT,
reservationtype VARCHAR(200),
stamp_created timestamp default now()
); 

create table Organization(id INT(11) PRIMARY KEY AUTO_INCREMENT,
sectorid INT(11) NOT NULL,
name VARCHAR(200) NOT NULL,
orgurl VARCHAR(500) NOT NULL,
stamp_created timestamp default now(),
stamp_updated timestamp default now() on update now(),
FOREIGN KEY (sectorid) REFERENCES Sector(id)
);

create table Job(id INT(11) PRIMARY KEY AUTO_INCREMENT,
orgid INT(11) NOT NULL,
branchid INT(11) NOT NULL,
salaryid INT(11) NOT NULL,
designation varchar(300),
qualification VARCHAR(500),
description VARCHAR(2500),
eligibilitycriteria VARCHAR(5000),
joblocation VARCHAR(500),
jobdetailslnk VARCHAR(500),
jobapplylnk VARCHAR(500),
jobapplylastdate Date,
selectionprocess VARCHAR(2000),
totalvancancies MEDIUMINT,
jobtype VARCHAR(50),
tags VARCHAR(1000),
stamp_created timestamp default now(),
stamp_updated timestamp default now() on update now(),
FOREIGN KEY (orgid) REFERENCES Organization(id),
FOREIGN KEY (branchid) REFERENCES Branch(id),
FOREIGN KEY (salaryid) REFERENCES Salary(id)
);

create table Reservation(id INT(11) PRIMARY KEY AUTO_INCREMENT,
reservationtypeid INT(11),
jobid INT(11),
applicationfee INT(11),
jobvacancies INT(11),
FOREIGN KEY (reservationtypeid) REFERENCES ReservationTypes(id),
FOREIGN KEY (jobid) REFERENCES Job(id)
);

create table UserProfile(id INT(11) PRIMARY KEY AUTO_INCREMENT,
mobileno VARCHAR(15),
emailid VARCHAR(100),
qualification VARCHAR(200)
);

