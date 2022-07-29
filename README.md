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