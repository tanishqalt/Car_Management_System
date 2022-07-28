# Car Management System

Team Members: Tanishq Sharma, Dimple Diyalani


### Conditions

- [ ] Your web service must have at least 6 methods with atleast 3 methods that accepts a path parameter
- [ ] A UI to interact with web service
- [ ] The web service must use a database in some way. Minimum three tables required

### Basic Flow

User Functions

1. User can create an account (Register) - Method 1
2. User can login – Method 2
3. User can view all cars available (/GetAllCars) – Method 3
4. User can book a car from a particular time period – Method 4
5. User can visit my bookings – all the cars user have previously booked – Method 5
6. User can cancel a booking – Method 6



### Database Entities

1. User (Table 1)
	- [x] id
	- [x] firstName
	- [x] lastName
	- [x] email
	- [x] password
2. Booking (Table 2)
	- bookingID
	- userID - Foreign Key
	- carID - Foreign Key
	- startDate
	- endDate
	- cost
3. Car (Table 3)
	- [x] carID
	- [x] carName
	- [x] carColor
	- [x] costPerDay


### Understanding Relations

- A booking can only have one car. Hence: One-to-One relationship between Booking <> Car
- A booking can only have one user. Hence: One-to-One relationship between Booking <> User
- No relationship required between User and Car. 
	


## Database Scipts

1. To create a database:
	
	`create database car_management_system;`