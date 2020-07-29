**Electricity Billing System**

Tech Stack Used: 
Java/Java Swing
MySQL

Aim: 
For an electricity consumer, to be able to pay/generate their electricity bill. 

Things kept in mind: 
Users will be able to create and login into their account and get their bills generated on the basis of their location and meter rent.
Users can only take a look at their bills. They cannot create their own bills and add meter readings, as this can lead to bluffing.
Admins will have their respective id/password, through which they can login and can upload bills of different customers based on their meterID.
Admins can also look at the details of various bills and customers.

Database Information:

Table 1: 
User having attributes name, phone, meter_no, state, email, username

Table 2:
Userlogin having attributes username, password

Table 3:
bill having attributes meter_no, month and bill

Table 4:
state_tax having attributes state and tax

Table 5:
login(admin) having attributes username, password

Table 6:
Meter_type having attributes type_name and rent

Table 5:
Meter having attributes meter_no and type_name


Steps to run the application:

import the databases into mysql database.
Connect - connect class with mysql using JDBC jar file.
Run flash class.
Preview of different classes are as follows:



![Screenshot (164)](https://user-images.githubusercontent.com/48882133/88774238-cf3bd980-d1a0-11ea-82b3-9380be95a6f7.png)

This is the opening screen.
After this user/admin is needed to be selected.

![Screenshot (165)](https://user-images.githubusercontent.com/48882133/88774427-1033ee00-d1a1-11ea-9330-fd5ec03180ca.png)


If admin is selected following screen will appear:


![Screenshot (166)](https://user-images.githubusercontent.com/48882133/88774513-2e015300-d1a1-11ea-89c8-2c6271bf6d10.png)


![Screenshot (179)](https://user-images.githubusercontent.com/48882133/88774540-36598e00-d1a1-11ea-94d8-b4950bc38f97.png)

If view users is selected :


![Screenshot (168)](https://user-images.githubusercontent.com/48882133/88774579-3eb1c900-d1a1-11ea-82ad-d3c6a31a512d.png)

If Generate a bill is selected:
Meter no. and units consumed is needed and then corresponding bills will be generated as shown below.

![Screenshot (170)](https://user-images.githubusercontent.com/48882133/88774837-905a5380-d1a1-11ea-92ff-5c0455973e4a.png)

![Screenshot (171)](https://user-images.githubusercontent.com/48882133/88774850-95b79e00-d1a1-11ea-80b5-b9fbf9aa7dc2.png)



If an admin wants to delete a user, he  just needs to enter the unique username to do so.


![Screenshot (169)](https://user-images.githubusercontent.com/48882133/88774934-ae27b880-d1a1-11ea-9996-12b420bb36d3.png)



If user is selected:

![Screenshot (166)](https://user-images.githubusercontent.com/48882133/88774978-bda70180-d1a1-11ea-9011-fd9bb2614e97.png)


They can see their profile details on login.

![Screenshot (177)](https://user-images.githubusercontent.com/48882133/88775010-ca2b5a00-d1a1-11ea-9b25-b291f7f23659.png)




If users click on get bill, they can take a look at the bills as updated by the admin.

![Screenshot (178)](https://user-images.githubusercontent.com/48882133/88775041-d6afb280-d1a1-11ea-8804-5a0c1ad107df.png)



