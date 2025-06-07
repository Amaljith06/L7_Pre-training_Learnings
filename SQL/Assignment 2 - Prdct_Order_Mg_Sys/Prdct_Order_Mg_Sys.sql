CREATE DATABASE store;

-- Part 1: Queries to create tables

CREATE TABLE customers (
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
	customer_name VARCHAR(100),
	email VARCHAR(100),
	city VARCHAR(50),	
	signup_date DATE
)AUTO_INCREMENT=1; 

CREATE TABLE orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
	customer_id INT,
	order_date DATE,
	total_amount DECIMAL(10,2),
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
)AUTO_INCREMENT=101;

CREATE TABLE products (
	product_id INT PRIMARY KEY AUTO_INCREMENT,
	product_name VARCHAR(100),
	category VARCHAR(50),
	product_price DECIMAL(10,2)
)AUTO_INCREMENT=501;

CREATE TABLE orderdetails (
	order_detail_id INT PRIMARY KEY AUTO_INCREMENT,
	order_id INT,
	product_id INT,
	quantity INT,
	price DECIMAL(10,2),
	FOREIGN KEY (order_id) REFERENCES orders(order_id),
	FOREIGN KEY (product_id) REFERENCES products(product_id)
)AUTO_INCREMENT=1001;

-- Inserting Values to Tables

INSERT INTO customers (customer_name, email, city, signup_date) VALUES
('Aarav Mehta', 'aarav.mehta@gmail.com', 'Mumbai', '2024-01-05'),
('Priya Sharma', 'priya.sharma@gmail.com', 'Delhi', '2024-02-20'),
('Rahul Nair', 'rahul.nair@gmail.com', 'Bangalore', '2023-12-18'),
('Sneha Iyer', 'sneha.iyer@gmail.com', 'Mumbai', '2024-03-10');

INSERT INTO products (product_name, category, product_price) VALUES
('Smartphone', 'Electronics', 15000.00),
('Bluetooth Speaker', 'Electronics', 3500.00),
('Notebook', 'Stationery', 50.00),
('Steel Water Bottle', 'Home & Kitchen', 499.00);

INSERT INTO orders (customer_id, order_date, total_amount) VALUES
(1, '2024-04-01', 18500.00), 
(2, '2024-04-05', 549.00),    
(3, '2024-04-10', 150.00),    
(4, '2024-04-12', 3549.00);   

INSERT INTO orderdetails (order_id, product_id, quantity, price) VALUES
(101, 501, 1, 15000.00),   
(101, 502, 1, 3500.00),    
(102, 504, 1, 499.00),     
(103, 503, 3, 150.00),     
(104, 502, 1, 3500.00),    
(104, 503, 1, 49.00);          

-- Part 2: Queries

-- Basic Queries

SELECT * FROM customers;

SELECT * FROM orders
WHERE order_date>= CURDATE()-INTERVAL 30 DAY;

SELECT product_name, product_price
FROM products;

SELECT category,COUNT(product_id)
FROM products
GROUP BY category;

-- Filtering and Conditions

SELECT * FROM customers
WHERE city ='Mumbai';

SELECT * FROM orders
WHERE total_amount>5000;

SELECT * FROM customers
WHERE signup_date> '2024-01-01';

-- Joins

SELECT orders.order_id,customers.customer_name
FROM orders
JOIN customers
ON customers.customer_id = orders.customer_id;

SELECT orderdetails.order_id,products.product_name
FROM orderdetails
JOIN products
ON orderdetails.product_id=products.product_id;

SELECT customers.name
FROM customers
LEFT JOIN orders
ON customers.customer_id=orders.customer_id
WHERE orders.order_id IS NULL;

-- Aggregation and Grouping

SELECT SUM(total_amount)
FROM orders
GROUP BY customer_id;

SELECT product_id,SUM(quantity)
FROM orderdetails
GROUP BY product_id
ORDER BY SUM(quantity) DESC
LIMIT 1;

SELECT customer_id, AVG(total_amount)
FROM orders
GROUP BY customer_id;

SELECT products.category,SUM(orderdetails.price)
FROM orderdetails
JOIN products
ON orderdetails.product_id=products.product_id
GROUP BY products.category;

-- Subqueries

SELECT customer_id FROM orders 
GROUP BY customer_id
HAVING SUM(total_amount) >
(SELECT AVG(total)
FROM
(SELECT SUM(total_amount) AS total
FROM orders
GROUP BY customer_id) AS avg_money_spent);

SELECT product_id
FROM products
WHERE product_id NOT IN
(SELECT DISTINCT product_id
FROM orderdetails); 

SELECT customer_id,MAX(orderdate)
FROM orders
GROUP BY customer_id;

-- Advanced Queries

SELECT customer_id, SUM(total_amount),RANK() OVER (ORDER BY SUM(total_amount) DESC) AS ranking
FROM orders
GROUP BY customer_id;

SELECT customer_id,COUNT(*)
FROM orders
GROUP BY customer_id
ORDER BY COUNT(*) DESC
LIMIT 3;

SELECT orderdetails.product_id, COUNT(DISTINCT(orders.customer_id))
FROM orders
JOIN orderdetails
ON orderdetails.order_id=orders.order_id
GROUP BY orderdetails.product_id;
