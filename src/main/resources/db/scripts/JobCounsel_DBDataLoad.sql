insert into Sector(name) values('Government Jobs');
insert into Sector(name) values('Public Sector Jobs');
insert into Sector(name) values('State Government Jobs');
insert into Sector(name) values('Private Sector(Non-IT) Jobs');
insert into Sector(name) values('Private Sector(IT) Jobs');


insert into States(statename,stateabbr) values('India','IN');

insert into States(statename,stateabbr) values('Andhra Pradesh','AP');
insert into States(statename,stateabbr) values('Arunachal Pradesh','AR');
insert into States(statename,stateabbr) values('Assam','AS');
insert into States(statename,stateabbr) values('Bihar','BR');
insert into States(statename,stateabbr) values('Chhattisgarh','CG');
insert into States(statename,stateabbr) values('Goa','GA');
insert into States(statename,stateabbr) values('Gujarat','GJ');
insert into States(statename,stateabbr) values('Haryana','HR');
insert into States(statename,stateabbr) values('Himachal Pradesh','HP');
insert into States(statename,stateabbr) values('Jammu and Kashmir','JK');

insert into States(statename,stateabbr) values('Jharkhand','JH');
insert into States(statename,stateabbr) values('Karnataka','KA');
insert into States(statename,stateabbr) values('Kerala','KL');
insert into States(statename,stateabbr) values('Madhya Pradesh','MP');
insert into States(statename,stateabbr) values('Maharashtra','MH');
insert into States(statename,stateabbr) values('Manipur','MN');
insert into States(statename,stateabbr) values('Meghalaya','ML');
insert into States(statename,stateabbr) values('Mizoram','MZ');
insert into States(statename,stateabbr) values('Nagaland','NL');
insert into States(statename,stateabbr) values('Orissa','OR');

insert into States(statename,stateabbr) values('Punjab','PB');
insert into States(statename,stateabbr) values('Rajasthan','RJ');
insert into States(statename,stateabbr) values('Sikkim','SK');
insert into States(statename,stateabbr) values('Tamil Nadu','TN');
insert into States(statename,stateabbr) values('Tripura','TR');
insert into States(statename,stateabbr) values('Uttarakhand','UK');
insert into States(statename,stateabbr) values('Uttar Pradesh','UP');
insert into States(statename,stateabbr) values('West Bengal','WB');
insert into States(statename,stateabbr) values('Tripura','TR');
insert into States(statename,stateabbr) values('Andaman and Nicobar Islands','AN');

insert into States(statename,stateabbr) values('Chandigarh','CH');
insert into States(statename,stateabbr) values('Dadra and Nagar Haveli','DH');
insert into States(statename,stateabbr) values('Daman and Diu','DD');
insert into States(statename,stateabbr) values('Delhi','DL');
insert into States(statename,stateabbr) values('Lakshadweep','LD');
insert into States(statename,stateabbr) values('Pondicherry','PY');


insert into Branch(sectorid,name) values(1,'Railway');
insert into Branch(sectorid,name) values(1,'SSC');
insert into Branch(sectorid,name) values(1,'Police');
insert into Branch(sectorid,name) values(1,'Army');
insert into Branch(sectorid,name) values(1,'Navy');
insert into Branch(sectorid,name) values(1,'Airforce');
insert into Branch(sectorid,name) values(1,'Medicine');
insert into Branch(sectorid,name) values(1,'Scientist');

insert into Branch(sectorid,name) values(2,'Bank');
insert into Branch(sectorid,name) values(3,'Bank');

insert into Branch(sectorid,name) values(1,'Technician');

insert into Organization(sectorid,orgurl,name) values(2,'https://www.sbi.co.in/web/about-us','State Bank Of India');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.rbi.org.in/Scripts/AboutusDisplay.aspx','Reserve Bank Of India');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.pnbindia.in/profile.html','Punjab National Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.bankofbaroda.in/history.htm','Bank Of Baroda');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.bankofindia.co.in/history3','Bank Of India');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.centralbankofindia.co.in/English/profile.aspx','Central Bank Of India');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.canarabank.com/About-Us.aspx','Canara Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.unionbankofindia.co.in/english/aboutus-profile.aspx','Union Bank Of India');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.iob.in/aboutus.aspx','Indian Overseas Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.psbindia.com/content/history1','Punjab And Sind Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.indianbank.in/departments/banks-profile/','Indian Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.ucobank.com/english/overview.aspx','UCO Bank');
insert into Organization(sectorid,orgurl,name) values(2,'https://www.bankofmaharashtra.in/about_us','Bank Of Maharashtra');

insert into Organization(sectorid,orgurl,name) values(1,'http://www.nii.res.in/aboutus/history','National Institute of Immunology');
insert into Organization(sectorid,orgurl,name) values(1,'http://www.vmmc-sjh.nic.in/forms/contentpage_hospital.aspx?lid=1214','VMMC Safdarjang Hospital');


insert into ReservationTypes(reservationtype) values('SC');
insert into ReservationTypes(reservationtype) values('ST');
insert into ReservationTypes(reservationtype) values('OBC(Non-Creamy)');
insert into ReservationTypes(reservationtype) values('OBC');
insert into ReservationTypes(reservationtype) values('EWS');


insert into Salary(lbound,hbound,currencytype,salarymode) values(30000,45000,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(20000,30000,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(27000,31000,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(50000,0,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(70000,0,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(75000,0,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(50000,0,'INR','Monthly');
insert into Salary(lbound,hbound,currencytype,salarymode) values(500000,0,'INR','Annually');
insert into Salary(lbound,hbound,currencytype,salarymode) values(1200000,0,'INR','Annually');
insert into Salary(lbound,hbound,currencytype,salarymode) values(2000000,0,'INR','Annually');
insert into Salary(lbound,hbound,currencytype,salarymode) values(1800000,0,'INR','Annually');

delete from Job;
insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(5,9,8,'Senior Manager', 'The applicant should either be a retired or serving officer not below the rank of General Manager.','Appointment of Internal Ombudsman'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-15',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',10,'CONTRACT','Bank, Above 50, CONTRACT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(5,9,10,'Senior Ombudsman Manager', 'The applicant should either be a retired or serving officer not below the rank of General Manager.','Appointment of Internal Ombudsman'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-25',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Above 50, CONTRACT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(5,9,1,'Clerk', 'The applicant should be less than 30 years of age.','Appointment of Clerk'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-17',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Below 35, PERMANENT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(5,9,6,'Probationary Officer', 'The applicant should be less than 30 years of age.','Appointment of Probationary Officers'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-30',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',25,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(1,9,10,'Senior Ombudsman Manager', 'The applicant should either be a retired or serving officer not below the rank of General Manager.','Appointment of Internal Ombudsman'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-25',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Above 50, CONTRACT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(1,9,1,'Clerk', 'The applicant should be less than 30 years of age.','Appointment of Clerk'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-18',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(2,9,10,'Senior Ombudsman Manager', 'The applicant should either be a retired or serving officer not below the rank of General Manager.','Appointment of Internal Ombudsman'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-25',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Above 50, CONTRACT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(2,9,1,'Clerk', 'The applicant should be less than 30 years of age.','Appointment of Clerk'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-18',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',50,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(1,9,6,'Probationary Officer', 'The applicant should be less than 30 years of age.','Appointment of Probationary Officers'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-11-30',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',25,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(1,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-11-24',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(2,9,6,'Probationary Officer', 'The applicant should be less than 30 years of age.','Appointment of Probationary Officers'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-11-30',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',25,'PERMANENT','Bank, Below 35, PERMANENT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(2,9,2,'Sub Staff II', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-24',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 30, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(3,9,6,'Probationary Officer', 'The applicant should be less than 30 years of age.','Appointment of Probationary Officers'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-30',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',25,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(3,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-24',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(4,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-15',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(6,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-24',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(6,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-18',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');


insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(7,9,8,'Senior Ombudsman Manager', 'The applicant should either be a retired or serving officer not below the rank of General Manager.','Appointment of Internal Ombudsman'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Internal Ombudsman Scheme 2018 of RBI. Age should not be above 70',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-25',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',10,'CONTRACT','Bank, Above 50, CONTRACT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(8,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-21',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(8,9,2,'Sub Staff', 'The applicant should be less than 30 years of age.','Appointment of Sub Staff'
,'Should have a minimum of 7 years in areas such as Banking, Regulation, Supervision, Payment etc. Should satisfy as per the criteria laid out by Sub Staff Schem 2018 of RBI. Age should not be above 30',
'https://www.bankofindia.co.in/pdf/Notice15719.pdf','https://www.bankofindia.co.in/pdf/Application15719.pdf','2020-12-04',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',15,'PERMANENT','Bank, Below 35, PERMANENT');


--Government

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(14,8,11,'Staff Scientist-III', '40 years for Staff Scientist-III.','Staff Scientist-III'
,'1st class M.Sc with 5 years experience or 1st class M.Tech/ MD/ MVSc/ M.Pharm/ M.Biotech with 4 years R  D experience (OR) Ph.D with 4 years postdoctoral experience in the relevant field.',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-24',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',2,'PERMANENT','Scientist, Below 40, Phd');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(14,8,10,'Staff Scientist-IIV', '50 years for Staff Scientist-III.','Staff Scientist-III'
,'1st class M.Sc with 5 years experience or 1st class M.Tech/ MD/ MVSc/ M.Pharm/ M.Biotech with 10 years R and D experience (OR) Ph.D with 4 years postdoctoral experience in the relevant field.',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-19',
'Short listing and personal Interview. Final selection will be on the basis of marks secured by the candidate in the interview in order of merit.',2,'PERMANENT','Scientist, Below 50, Phd');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(14,11,3,'Technician-I', '30 years for Technician-I','Technician-I'
,'M.Sc. Post Graduate or equivalent qualification with one year experience OR B.Sc. with five years experience.',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-28',
'Written Test (OMR Based).',6,'PERMANENT','Technician, Below 30, MSc');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(14,11,2,'Technician-II', '30 years for Technician-II','Technician-II'
,'M.Sc. Post Graduate or equivalent qualification with one year experience OR B.Sc. with five years experience.',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-15',
'Written Test (OMR Based).',3,'PERMANENT','Technician, Below 30, MSc');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(14,11,4,'Skilled Work Assistant', '25 years for Skilled Work Assistant','Skilled Work Assistant'
,'M.Sc. Post Graduate or equivalent qualification with one year experience OR B.Sc. with five years experience.',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-24',
'Written Test (OMR Based).',8,'PERMANENT','Technician, Below 25, MSc');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(15,7,8,'Junior Resident (Non PG) MBBS', 'MBBS','Junior Resident (Non PG) MBBS'
,'MBBS Degree from a Recognized University and must be registered with Delhi Medical Council (DMC).',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-24',
'The selection will be made through Written Examination.',426,'PERMANENT','Doctor,MBBS, Delhi');

insert into Job(orgid,branchid,salaryid,designation,qualification,description,eligibilitycriteria,jobdetailslnk,jobapplylnk,jobapplylastdate,selectionprocess,totalvancancies,jobtype,tags) 
values(15,7,8,'Junior Resident (Non PG) Dental Surgery and Maxillofacial Surgery', 'BDS','Junior Resident (Non PG) Dental Surgery and Maxillofacial Surgery'
,'BDS Degree from a Recognized University and must be registered with Delhi Medical Council (DMC).',
'http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','http://dbtindia.gov.in/sites/default/files/Faculty%20recruitment%20detailed%20advertisement-%20website.pdf','2020-12-24',
'The selection will be made through Written Examination.',16,'PERMANENT','Doctor,MBBS, Delhi');


update Job set joblocation ='Chennai' where id in (3,9,15,21,27);
update Job set joblocation ='Mumbai' where id in (4,10,16,22,28);
update Job set joblocation ='Bengaluru' where id in (5,11,17,23);
update Job set joblocation ='Kolkata' where id in (6,7,8,12,26);
update Job set joblocation ='Delhi' where id in (13,14,18,19,20);
update Job set joblocation ='Madurai' where id in (24,25,29,30);










