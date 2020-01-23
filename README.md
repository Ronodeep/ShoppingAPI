# ShoppingAPI
There is mysql db query under resources folder(./resources/extra/DB_DATA_ShoppingDB.sql). This script is used to load all the data in DB.
There is also a properties file (./resources/extra/dbconfig.properties). Please set all the db connectin details there.  
In my case I used AWS MySQL RDS as database from which data will be fetched.
If you also used AWS MySQL RDS, then make MYSQL/Aurora port (i.e mostly 3306) is accessible from out side world or from server where you going host.

Some urls example are below: 
1. Access all customers details
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/customers
2. Access a customer’s details
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/customers/C005/
3.	Access all orders of a customer
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/customers/C005/orders
4.	Access a customer’s carts
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/customers/C005/carts
5.	Access a products’s details by productId
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/products/P0001
8.	Access a products’s details by partial name match
http://ec2-35-175-247-170.compute-1.amazonaws.com:8080/ShoppingAPI/webapi/products?prdPartialName=Core
