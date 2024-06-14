# ====================================================================== #
#																		 #
#						Car Dealership Database							 #
#					  ---------------------------						 #
#					      Target DBMS: MySQL							 #
# 												                         #
# ====================================================================== #

	DROP DATABASE IF EXISTS dealership_db;

	CREATE DATABASE IF NOT EXISTS dealership_db;
	USE dealership_db;

# ====================================================================== #
#					             Tables									 #
#                        	----------------                             #
#						 												 #
# ====================================================================== #

# ====================================================================== #
#						       Dealerships								 #
# ====================================================================== #

	CREATE TABLE dealerships(
		dealership_id int NOT NULL auto_increment,
		dealership_name varchar(50) NOT NULL,
		address varchar(50),
		phone_number varchar(12),
		PRIMARY KEY(dealership_id)
	);

# ====================================================================== #
#						         Vehicles							     #
# ====================================================================== #

	CREATE TABLE vehicles(
		vin int NOT NULL,
		year int NOT NULL,
		make varchar(50) NOT NULL,
		model varchar(50) NOT NULL,
		type varchar(30),
		color varchar(30) NOT NULL,
		odometer int NOT NULL,
		price decimal(10,2) NOT NULL,
		sold_or_leased varchar(6),
		PRIMARY KEY(vin)
	);

# ====================================================================== #
#						        Inventory								 #
# ====================================================================== #

	CREATE TABLE inventory(
		inventory_id int NOT NULL auto_increment,
		dealership_id int NOT NULL,
		vin int NOT NULL,
		PRIMARY KEY(inventory_id),
		FOREIGN KEY(dealership_id) REFERENCES dealerships(dealership_id),
		FOREIGN KEY(vin)REFERENCES vehicles(vin)
	);

# ====================================================================== #
#						     Sales Contracts						     #
# ====================================================================== #

	CREATE TABLE sales_contracts(
		contract_id int NOT NULL auto_increment,
		contract_date DATE,
		customer_name varchar(50) NOT NULL,
		customer_email varchar(80) NOT NULL,
		vin int NOT NULL,
		sales_tax_amount decimal(10,2),
		recording_fee decimal(8,2),
		processing_fee decimal(10,2),
		is_financing varchar(3),
		PRIMARY KEY(contract_id),
		FOREIGN KEY(vin) REFERENCES vehicles(vin)
	);

# ====================================================================== #
#						    Lease Contracts							     #
# ====================================================================== #

	CREATE TABLE lease_contracts(
		contract_id int NOT NULL auto_increment,
		contract_date DATE,
		customer_name varchar(50) NOT NULL,
		customer_email varchar(80) NOT NULL,
		vin int NOT NULL,
        lease_fee decimal(8,2),
		expected_ending_value decimal(10,2),
		PRIMARY KEY(contract_id),
		FOREIGN KEY(vin) REFERENCES vehicles(vin)
	);

# ====================================================================== #
#					        Populating Tables							 #
#                       ------------------------	                     #
#						 												 #
# ====================================================================== #

# ====================================================================== #
#						    Dealerships Data							 #
# ====================================================================== #

	INSERT INTO dealerships(dealership_name, address, phone_number)
		VALUE('Car Craze','104 Pine Road','345-172-0896'),
			('Auto Haven','8530 First Avenue','720-145-9638'),
			('Speedy Motors','567 Oak Avenue','987-654-3210'),
			('Mega Wheels','210 Elm Street','456-789-0123'),
			('Fastlane Motors','431 Cedar Lane','876-543-2109'),
			('City Auto Mall','753 Birch Road','234-567-8901'),
			('Golden Wheels','632 Pine Avenue','109-876-5432'),
			('High Gear Motors','978 Walnut Street','890-123-4567'),
			('Supreme Cars','654 Birch Road','234-567-8901'),
			('Precision Auto','876 Elm Avenue','345-678-9012');

# ====================================================================== #
#						    Vehicles Data								 #
# ====================================================================== #

	INSERT INTO vehicles(vin, year, make, model, type, color, odometer, price, sold_or_leased)
		VALUE(10112,1993,'Ford','Explorer','SUV','Red',525123,9900.00,'sold'),
			(37846,2012,'Honda','Civic','Sedan','Gray',103221,6895.00, NULL),
			(44875,2006,'Nissan','Altima','Sedan','Blue',137850,3995.00,'sold'),
			(27483,2018,'Toyota','Camry','Sedan','White',42123,7960.00, NULL),
			(56291,2015,'Chevrolet','Silverado','Truck','Black',87250,4990.00, NULL),
			(93742,2019,'Ford','F-150','Truck','Red',30210,2990.00,'sold'),
			(65837,2014,'Honda','Accord','Sedan','Silver',61500,4990.00,'leased'),
			(34980,2009,'Toyota','Corolla','Sedan','Blue',98755,5990.00, NULL),
			(82376,2016,'Nissan','Rogue','SUV','Gray',46000,6990.00, NULL),
			(48721,2011,'Ford','Mustang','Coupe','Red',75000,9980.00, NULL),
			(15689,2017,'Hyundai','Sonata','Sedan','Black',36000,1990.00, NULL),
			(72654,2013,'Chevrolet','Malibu','Sedan','White',80230,8990.00,'leased'),
			(36598,2010,'Honda','CR-V','SUV','Green',112450,990.00, NULL),
			(84239,2012,'Toyota','Sienna','Van','Silver',94000,3990.00, NULL),
			(20475,2008,'Nissan','Sentra','Sedan','Gray',128500,4990.00, NULL),
			(61937,2019,'Subaru','Outback','SUV','Blue',20500,5990.00,'sold'),
			(50328,2015,'Ford','Escape','SUV','Black',63500,7990.00, NULL),
			(10987,2007,'Chevrolet','Impala','Sedan','Red',144200,4490.00, NULL),
			(78432,2018,'Honda','Pilot','SUV','White',31200,9990.00,'sold'),
			(27654,2014,'Toyota','Tacoma','Truck','Silver',70500,3990.00, NULL),
			(62193,2010,'Ford','Focus','Hatchback','Blue',99800,5990.00, NULL),
			(43827,2016,'Nissan','Versa','Sedan','Gray',48000,7230.00, NULL),
			(89523,2005,'Honda','Odyssey','Van','Silver',169500,3790.00, NULL),
			(12345,2013,'Toyota','Rav4','SUV','Blue',78000,14990.00, NULL),
			(67890,2016,'Ford','Fusion','Sedan','Silver',55000,8990.00, NULL),
			(24680,2011,'Honda','Fit','Hatchback','Red',89000,7990.00, NULL),
			(13579,2017,'Chevrolet','Equinox','SUV','Black',42000,8990.00,'leased'),
			(98765,2014,'Nissan','Maxima','Sedan','White',69000,5990.00, NULL),
			(54321,2009,'Toyota','Highlander','SUV','Gray',11500,11690.00,'leased'),
			(55776,2017,'Nissan','Pathfinder','SUV','Silver',38001,2990.00, NULL),
			(77998,2014,'Toyota','Camry','Sedan','Blue',66001,7990.00,'leased'),
			(18224,2018,'Ford','F-150','Truck','Black',32001,9990.00,'sold'),
			(44851,2015,'Honda','CR-V','SUV','Silver',61001,7990.00, NULL),
			(77881,2012,'Chevrolet','Impala','Sedan','Black',88001,4990.00, NULL),
			(94010,2019,'Nissan','Sentra','Sedan','Gray',23001,11990.00,'sold'),
			(22336,2016,'Toyota','Corolla','Sedan','White',45001,7990.00, NULL),
			(66708,2013,'Ford','Edge','SUV','Red',74001,5990.00,'leased'),
			(88445,2010,'Honda','Fit','Hatchback','Blue',98001,3990.00, NULL),
			(33668,2008,'Chevrolet','Equinox','SUV','Silver',130001,990.00, NULL),
			(55778,2017,'Nissan','Altima','Sedan','Black',38001,7990.00, NULL),
			(77999,2014,'Toyota','Highlander','SUV','Gray',66001,6990.00, NULL),
			(11225,2018,'Ford','Escape','SUV','White',32001,10990.00,'sold'),
			(44558,2015,'Honda','Civic','Sedan','Red',61002,7990.00, NULL),
			(77882,2012,'Chevrolet','Cruze','Sedan','Gray',88002,6990.00, NULL),
			(99012,2019,'Nissan','Altima','Sedan','Black',23002,10990.00,'leased'),
			(22337,2016,'Toyota','Prius','Hatchback','Green',45002,7990.00, NULL),
			(66778,2013,'Ford','Escape','SUV','Red',74002,4990.00, NULL),
			(88446,2010,'Honda','Civic','Sedan','Gray',98002,2990.00, NULL),
			(33669,2008,'Chevrolet','Tahoe','SUV','White',130002,1990.00,'leased'),
			(55779,2017,'Nissan','Pathfinder','SUV','Silver',38002,10990.00, NULL),
			(77993,2014,'Toyota','Camry','Sedan','Blue',66002,15990.00, NULL),
			(18226,2018,'Ford','F-150','Truck','Black',32002,7990.00,'sold'),
			(44559,2015,'Honda','CR-V','SUV','Silver',61002,6990.00, NULL),
			(77883,2012,'Chevrolet','Impala','Sedan','Black',88002,4990.00,'leased'),
			(99013,2019,'Nissan','Sentra','Sedan','Gray',23002,10995.00,'sold'),
			(22338,2016,'Toyota','Corolla','Sedan','White',45002,8995.00, NULL),
			(66709,2013,'Ford','Edge','SUV','Red',74002,17995.00, NULL),
			(88447,2010,'Honda','Fit','Hatchback','Blue',98002,8995.00, NULL),
			(33670,2008,'Chevrolet','Equinox','SUV','Silver',130002,1995.00,'leased'),
			(77997,2014,'Toyota','Highlander','SUV','Gray',66002,6995.00, NULL);

# ====================================================================== #
#						    Inventory Data								 #
# ====================================================================== #

	INSERT INTO inventory(dealership_id, vin)
		VALUE(3, 10112),
			(8, 37846),
			(5, 44875),
			(7, 27483),
			(2, 56291),
			(1, 93742),
			(4, 65837),
			(2, 34980),
			(9, 82376),
			(8, 48721),
			(6, 15689),
			(5, 72654),
			(10, 36598),
			(6, 84239),
			(10, 20475),
			(1, 61937),
			(10, 50328),
			(3, 10987),
			(7, 78432),
			(4, 27654),
			(1, 62193),
			(5, 43827),
			(4, 89523),
			(7, 12345),
			(3, 67890),
			(9, 24680),
			(8, 13579),
			(2, 98765),
			(1, 54321),
			(7, 55776),
			(3, 77998),
			(8, 18224),
			(5, 44851),
			(7, 77881),
			(2, 94010),
			(1, 22336),
			(4, 66708),
			(2, 88445),
			(9, 33668),
			(8, 55778),
			(6, 77999),
			(5, 11225),
			(1, 44558),
			(4, 77882),
			(10, 99012),
			(6, 22337),
			(7, 66778),
			(4, 88446),
			(1, 33669),
			(7, 55779),
			(3, 77993),
			(2, 18226),
			(10, 44559),
			(8, 77883),
			(3, 99013),
			(9, 22338),
			(10, 66709),
			(7, 88447),
			(4, 33670),
			(10, 77997);

# ====================================================================== #
#						     Sales Contracts						     #
#						          Data									 #
# ====================================================================== #

	INSERT INTO sales_contracts(contract_date, customer_name, customer_email, vin, sales_tax_amount, recording_fee, processing_fee, is_financing)
		VALUE('2024-01-12', 'Mia Lee', 'mlee1145@fakemail.com',10112, 495.00, 100, 295, 'yes'),
			('2024-01-29', 'Leo Wong', 'wongle89@mail.com',44875, 199.75, 100, 495, 'no'),
			('2024-02-15', 'Ava Singh', 'ava.thesingher@mail.com',93742, 149.50, 100, 295, 'yes'),
			('2024-03-05', 'Max Chan', 'maximuschanimus@mail.com',18224, 499.50, 100, 295, 'no'),
			('2024-03-18', 'Zoe Smith', 'zoe202@fakemail.com', 61937, 299.50, 100, 295, 'yes'),
			('2024-04-01', 'Eliana Brown', 'eb2194@mail.com', 78432, 499.50, 100, 295, 'yes'),
			('2024-04-10', 'Lucas Johnson', 'l.johnsonwrites@fakemail.com', 94010, 599.50, 100, 295, 'no'),
			('2024-05-01', 'Finn Davis', 'finndavisons@mail.com', 11225, 549.5, 100, 295, 'yes'),
			('2024-05-15', 'Maya Taylor', 'maytayalor@mail.com', 18226, 399.50, 100, 495, 'yes'),
			('2024-05-21', 'Alex Miller', 'amilleratamill@fakemail.com', 99013, 549.75, 100, 495, 'yes');

# ====================================================================== #
#						     Lease Contracts						     #
#						          Data									 #
# ====================================================================== # 

	INSERT INTO lease_contracts(contract_date, customer_name, customer_email, vin, lease_fee, expected_ending_value)
		VALUE('2024-01-15', 'Owen Patel', 'owenpatelmails@email.com', 13579, 629.30, 4495.00),
			('2024-02-03', 'Ethan Santos', 'losethansantos@fakemail.com', 33669, 139.30, 995.00),
			('2024-03-21', 'Liam Stewart', 'notsirpatrickstewart@fakemail.com', 33670, 139.65, 997.50),
			('2024-04-05', 'Emma Rivera', 'erivers0839@mail.com', 54321, 818.30, 5845.00),
			('2024-04-29', 'Noah Khan', 'oahkhann@fakemail.com', 65837, 349.30, 2495.00),
			('2024-05-10', 'Harper Campbell', 'theharperoftheharpers@fakemail.com', 66708, 419.30, 2995.00),
			('2024-05-24', 'Amelia Cooper', 'ameliaoramelia@mail.com', 72654, 629.30, 4495.00),
			('2024-05-29', 'Carter Evans', 'carterwastaken@fakemail.com', 77883, 349.30, 2495.00),
			('2024-06-01', 'Emily Wright', 'yourwrightormywright@mail.com', 77998, 559.30, 3995.00),
			('2024-06-05', 'Mason Torres', 'notadoctorbutamason@mail.com', 99012, 769.30, 5495.00);
; 
