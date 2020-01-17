/*
Basic command for DB load with command
*/
show databases;
use shoppingdb;
show tables;

--Creation of products table
CREATE TABLE products (
    productid VARCHAR(10) PRIMARY KEY NOT NULL,
    category VARCHAR(20) NOT NULL,
    productname VARCHAR(128) NOT NULL,
    price FLOAT NOT NULL,
    ratings FLOAT NOT NULL
);
describe products;
--drop table products;
--alter table products Modify category varchar(20)not null;

--Insertion into products
Insert into products() values('P0001','Electronics','Sony Bravia 80 cm (32 Inches) Full HD LED Smart TV',27999,4);
Insert into products() values('P0002','Electronics','HP 15 Intel Core i5 (8GB DDR4/1TB HDD/Win 10/MS Office/Integrated Graphics/2.04 kg), Full HD Laptop','41990','5');
Insert into products() values('P0003','Electronics','Dell Inspiron 3567 Intel Core i3 7th Gen 15.6-inch FHD Laptop ','29990','4');
Insert into products() values('P1001','Clothing',"Vaamsi Women's A-Line Kurta",'500','3');
Insert into products() values('P1002','Clothing','U.S. Polo Assn. Men Orange Polo T-shirt','1500','4');
Insert into products() values('P1003','Clothing','Jack & Jones Yellow Printed T-shirt','800','4');
Insert into products() values('P2001','Sports','Endless 27.5T 21-Speed Carbon Steel Mountain Bike','10490','5');
Insert into products() values('P2002','Sports','Yonex GR 303 Badminton Racquet','429','6');

--Fetching prodcut details
SELECT 
    *
FROM
    products;
    
--Creatin of customers 
CREATE TABLE customers (
    customerid VARCHAR(10) PRIMARY KEY NOT NULL,
    name VARCHAR(25) NOT NULL,
    email VARCHAR(30) NOT NULL CHECK (email LIKE '%@%.%'),
    city VARCHAR(30) NOT NULL
);
describe customers;

--Alter table customers Modify city varchar(30) not null; 

--Insertion of data in customers
Insert into customers() values('C001','Harry Potter','harry@gmail.com','South Carolina');
Insert into customers() values('C002','Ram Naik','ram@gmail.com','Las Vegas');
Insert into customers() values('C003','Tony Mathew','tonym@gmail.com','Washington');
Insert into customers() values('C004','Rickey Watson','wrickey@gmail.com','Washington');
Insert into customers() values('C005','Richa Gil','richag@gmail.com','Las Vegas');

--Fetching customers details
SELECT 
    *
FROM
    customers;

--Creation of carts table
CREATE TABLE carts (
    cartid VARCHAR(10) PRIMARY KEY NOT NULL,
    customerid VARCHAR(25) NOT NULL,
    productList VARCHAR(60) NOT NULL,
    CONSTRAINT FK_customerid FOREIGN KEY (customerid)
        REFERENCES customers (customerid)
);
describe carts;

--Insertion of values in carts
Insert into carts() values('CR001','C001','P0001,P2001');
Insert into carts() values('CR002','C001','P0003,P2002');
Insert into carts() values('CR003','C003','P0002,P2001,P2002');

--Fetching of details of the carts;
SELECT 
    *
FROM
    carts;

--Creation of Orders 
CREATE TABLE orders (
    ordernumber VARCHAR(10) PRIMARY KEY NOT NULL,
    orderdate DATE NOT NULL,
    customername VARCHAR(25) NOT NULL,
    productsOrdered VARCHAR(60) NOT NULL
);
desc orders;

--alter table orders drop ordernumber;
--alter table orders add ordernumber varchar(10) primary key not null first;

--Insertion of data into Orders
Insert into orders() values('124719220',STR_TO_DATE('21-08-2019', '%d-%m-%Y'),'Ram Naik','P0001,P2001');
Insert into orders() values('119215410',STR_TO_DATE('14-08-2019', '%d-%m-%Y'),'Richa Gil','P0003,P2002,P2001');
Insert into orders() values('119215340',STR_TO_DATE('13-08-2019', '%d-%m-%Y'),'Ram Naik','P0002,P2001,P2002');
Insert into orders() values('116410240',STR_TO_DATE('01-08-2019', '%d-%m-%Y'),'Richa Gil','P0002,P2001');
Insert into orders() values('96357758',STR_TO_DATE('01-08-2019', '%d-%m-%Y'),'Rickey Watson','P0003,P2002');
Insert into orders() values('80472941',STR_TO_DATE('15-08-2019', '%d-%m-%Y'),'Rickey Watson','P0001,P2002,P2001');

--Fetching of Orders
SELECT 
    *
FROM
    orders;

commit;