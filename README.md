# Car Management System

Team Members: Tanishq Sharma, Dimple Diyalani


### Conditions

- [ ] Your web service must have at least 6 methods with atleast 3 methods that accepts a path parameter
- [ ] A UI to interact with web service
- [ ] The web service must use a database in some way. Minimum three tables required

### Basic Flow

User Functions

1. CRUD 1 – User can create an account (Register)
2. CRUD 2 – User can login
3. CRUD 3 – User can view all cars available (/GetAllCars)
4. CRUD 4 – User can book a car from a particular time period
5. CRUD 5 – User can visit my bookings – all the cars user have previously booked
6. CRUD 6 – User can cancel a booking
7. CRUD 7 – Retrieve Single Car
8. CRUD 8 – Retrieve Single Booking



### Database Entities

1. User (Table 1)
	- [x] id
	- [x] firstName / String
	- [x] lastName / String
	- [x] email / String
	- [x] password / String
2. Booking (Table 2)
	- [x] bookingID
	- [x] userID - Foreign Key / One to One
	- [x] carID - Foreign Key / One to One
	- [x] startDate / String
	- [x] endDate / String
	- [x] cost / Double
3. Car (Table 3)
	- [x] carID 
	- [x] carName / String
	- [x] carColor / String
	- [x] costPerDay / Double


### Understanding Relations

- A booking can only have one car. Hence: One-to-One relationship between Booking <> Car
- A booking can only have one user. Hence: One-to-One relationship between Booking <> User
- No relationship required between User and Car. 
	


## Database Scipts

1. To create a database:
	
	`create database car_management_system;`
	
	
2. To create the table

```
CREATE TABLE `car_management_system`.`bookings` (
  `bookingID` INT NOT NULL,
  `startDate` VARCHAR(45) NULL,
  `endDate` VARCHAR(45) NULL,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`bookingID`));
  
  
  CREATE TABLE `car_management_system`.`cars` (
  `carID` INT NOT NULL,
  `carName` VARCHAR(45) NULL,
  `carColor` VARCHAR(45) NULL,
  `costPerDay` DOUBLE NULL,
  PRIMARY KEY (`carID`));
  
  
  CREATE TABLE `car_management_system`.`users` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  
Test Data In Cars Table
INSERT INTO `car_management_system`.`cars` (`carID`, `car_name`, `car_color`, `cost_per_day`) VALUES ('1', 'CADILLAC Blackwing', 'Black', '200');
INSERT INTO `car_management_system`.`cars` (`carID`, `car_name`, `car_color`, `cost_per_day`) VALUES ('2', 'Porsche Boxster', 'Red', '400');
INSERT INTO `car_management_system`.`cars` (`carID`, `car_name`, `car_color`, `cost_per_day`) VALUES ('3', 'Subaru BRZ GR86', 'White', '250');
INSERT INTO `car_management_system`.`cars` (`carID`, `car_name`, `car_color`, `cost_per_day`) VALUES ('4', 'Honda Accord', 'Red', '300');
INSERT INTO `car_management_system`.`cars` (`carID`, `car_name`, `car_color`, `cost_per_day`) VALUES ('5', 'Kia Telluride', 'Grey', '320');
  
  
 ```