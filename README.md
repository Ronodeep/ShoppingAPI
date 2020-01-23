# ShoppingAPI
There is mysql db query under resources folder(./resources/extra/DB_DATA_ShoppingDB.sql). This script is used to load all the data in DB.
There is also a properties file (./resources/extra/dbconfig.properties). Please set all the db connectin details there.  
In my case I used AWS MySQL RDS as database from which data will be fetched.
If you also used AWS MySQL RDS, then make MYSQL/Aurora port (i.e mostly 3306) is accessible from out side world or from server where you going host. 
