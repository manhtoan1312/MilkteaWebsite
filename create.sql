Drop DATABASE  if EXISTS doan_trasua;
CREATE DATABASE doan_trasua;
USE doan_trasua;

DROP TABLE IF EXISTS Custom_milk_tea_order;
Drop TABLE IF EXISTS custom_milk_tea_add_on;
DROP TABLE IF EXISTS Add_on;
DROP TABLE IF EXISTS Custom_milk_tea;
DROP TABLE IF EXISTS Milk_tea;
Drop TABLE IF EXISTS Milk_tea_category;
DROP TABLE IF EXISTS Ordering;
DROP TABLE IF EXISTS Staff_work_day;
DROP TABLE IF EXISTS Work_day;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS Salary;
DROP TABLE IF EXISTS Report;
DROP TABLE IF EXISTS Blog;
DROP TABLE IF EXISTS Contact;
DROP TABLE IF EXISTS Account;

CREATE TABLE Account
(
	acc_id CHAR(10),
	email CHAR(50) UNIQUE,
	password CHAR(70) NOT NULL,
	created_at TIMESTAMP,
	one_time_password VARCHAR(255),
	otp_requested_time TIMESTAMP,
	role CHAR(40) NOT NULL,
	name VARCHAR(50),
	phone	CHAR(11),
	address VARCHAR(50),
	enabled boolean,
	CONSTRAINT AccountKey PRIMARY KEY(acc_id)
);

CREATE TABLE Blog
(
	blog_id CHAR(10),
	created_at TIMESTAMP NOT NULL,
	title VARCHAR(255),
	content VARCHAR(1500),
	image_url CHAR(255),
	acc_id CHAR(10) NOT NULL,
	enabled boolean,
	CONSTRAINT BlogKey PRIMARY KEY(blog_id)
);

CREATE TABLE Contact 
(
	contact_id CHAR(10),
	type VARCHAR(20) NOT NULL,
	content VARCHAR(255) NOT NULL,
	acc_id CHAR(10) NOT NULL,
	enabled boolean,
	CONSTRAINT ContactKey PRIMARY KEY(contact_id)
);

CREATE TABLE Report
(
	report_id CHAR(10),
	sender_name VARCHAR(40) NOT NULL,
	sender_email CHAR(50),
	sender_phone_no CHAR(30),
	message VARCHAR(255) NOT NULL,
	has_read boolean,
	send_date TIMESTAMP NOT NULL,
	acc_id CHAR(10),
	enabled boolean,
	CONSTRAINT ReportKey PRIMARY KEY(report_id)
);

CREATE TABLE Salary
(
	salary_id CHAR(10),
	role CHAR(40),
	vnd_per_hour int,
	on_time boolean,
	enabled boolean,
	CONSTRAINT SalaryKey PRIMARY KEY(salary_id)
);

CREATE TABLE Work_day 
(
	work_day DATE,
	is_holiday Boolean,
	enabled boolean,
	CONSTRAINT work_day_key PRIMARY KEY (work_day)
);

CREATE TABLE Staff 
(
	id_number CHAR(12),
	name VARCHAR(50) NOT NULL,
	phone CHAR(11) unique,
	address VARCHAR(255),
	email CHAR(50) unique,
	staff_role VARCHAR(30) NOT NULL,
	day_of_birth DATE,
	start_date DATE NOT NULL,
	salary_id CHAR(10) NOT NULL,
	salary_ot_id CHAR(10) NOT NULL,
	manager_id CHAR(12),
	manager_acc_id CHAR(10) unique,
	deliver_acc_id CHAR(10),
	enabled boolean,
	CONSTRAINT staff_key PRIMARY KEY (id_number)
);

CREATE TABLE Staff_work_day
(
	staff_id CHAR(12),
	work_day DATE,
	hours FLOAT,
	CONSTRAINT staff_work_day_key PRIMARY KEY(staff_id, work_day)
);

CREATE TABLE Ingredient 
(
	ingredient_id CHAR(10),
  name NVARCHAR(255), 
	manufactoring_date DATE,
	expired_date DATE,
	cost int,
	quantity int,
	last_update TIMESTAMP,
	note VARCHAR(255),
	manager_id CHAR(10),
	enabled boolean,
	CONSTRAINT ingredient_key PRIMARY KEY (ingredient_id)
);

CREATE TABLE Ordering
(
	order_id CHAR(10),
	receiver_name VARCHAR(30),
	address VARCHAR(255),
	phone CHAR(11),
	payment_method CHAR(20),
	order_date TIMESTAMP,
	order_total_price int,
	note VARCHAR(255),
	customer_name VARCHAR(50),
	order_state VARCHAR(40),
	shipper_id CHAR(10),
	staff_manager_id CHAR(10),
	customer_id CHAR(10),
	enabled boolean,
	CONSTRAINT order_key PRIMARY KEY (order_id)
);

CREATE TABLE Milk_tea
(
	milk_tea_id CHAR(10),
	name VARCHAR(40) NOT NULL,
	price INT not NULL,
	cost INT not NULL,
	image_url NVARCHAR(1000),
	milk_tea_category_id CHAR(10),
	enabled boolean,
	CONSTRAINT milk_tea_key PRIMARY KEY (milk_tea_id) 
);

CREATE TABLE Custom_milk_tea
(
	custom_milk_tea_id CHAR(10),
	milktea_id CHAR(10),
	ice_amount INT,
	sugar_amount INT,
	size CHAR(2),
	total_cost int,
	total_price int,
	quantity int,
	order_id CHAR(10),
	enabled boolean,
	CONSTRAINT custom_milk_tea_key PRIMARY KEY (custom_milk_tea_id)
);

CREATE TABLE Milk_tea_category
(
	milk_tea_category_id CHAR(10),
	category_name NVARCHAR(255),
	description NVARCHAR(1500),
	enabled boolean,
	CONSTRAINT milk_tea_category_key PRIMARY KEY (milk_tea_category_id) 
);

CREATE TABLE Add_on
(
	add_on_id CHAR(10),
	name NVARCHAR(40),
	price int,
  cost int,
	enabled boolean,
	CONSTRAINT add_on_ket PRIMARY KEY (add_on_id)
);

CREATE TABLE custom_milk_tea_add_on
(
	add_on_id CHAR(10),
	custom_milk_tea_id CHAR(10),
	CONSTRAINT custom_milk_tea_add_on_key PRIMARY KEY (add_on_id, custom_milk_tea_id)
);

-- Các quan hệ
ALTER TABLE Blog ADD FOREIGN KEY (acc_id) REFERENCES Account(acc_id);
ALTER TABLE Contact ADD FOREIGN KEY (acc_id) REFERENCES Account(acc_id);
ALTER TABLE Report ADD FOREIGN KEY (acc_id) REFERENCES Account(acc_id);
ALTER TABLE Staff ADD FOREIGN KEY (salary_id) REFERENCES Salary(salary_id);
ALTER TABLE Staff ADD FOREIGN KEY (salary_ot_id) REFERENCES Salary(salary_id);
ALTER TABLE Staff ADD FOREIGN KEY (manager_id) REFERENCES Staff(id_number);
ALTER TABLE Staff ADD FOREIGN KEY (manager_acc_id) REFERENCES Account(acc_id);
ALTER TABLE Staff ADD FOREIGN KEY (deliver_acc_id) REFERENCES Account(acc_id);
ALTER TABLE Staff_work_day ADD FOREIGN KEY (staff_id) REFERENCES Staff(id_number);
ALTER TABLE Staff_work_day ADD FOREIGN KEY (work_day) REFERENCES Work_day(work_day);
ALTER TABLE Ingredient ADD FOREIGN KEY (manager_id) REFERENCES Account(acc_id);
ALTER TABLE Ordering ADD FOREIGN KEY (shipper_id) REFERENCES Account(acc_id);
ALTER TABLE Ordering ADD FOREIGN KEY (staff_manager_id) REFERENCES Account(acc_id);
ALTER TABLE Ordering ADD FOREIGN KEY (customer_id) REFERENCES Account(acc_id);
ALTER TABLE Custom_milk_tea ADD FOREIGN KEY (milktea_id) REFERENCES Milk_tea(milk_tea_id);
ALTER TABLE Custom_milk_tea ADD FOREIGN KEY (order_id) REFERENCES ordering(order_id);
-- ALTER TABLE Custom_milk_tea_order ADD FOREIGN KEY (order_id) REFERENCES Ordering(order_id);
-- ALTER TABLE Custom_milk_tea_order ADD FOREIGN KEY (custom_milk_tea_id) REFERENCES Custom_milk_tea(custom_milk_tea_id);
ALTER TABLE Milk_tea ADD FOREIGN KEY (milk_tea_category_id) REFERENCES Milk_tea_category(milk_tea_category_id);
ALTER TABLE custom_milk_tea_add_on ADD FOREIGN KEY (add_on_id) REFERENCES Add_on(add_on_id);
ALTER TABLE custom_milk_tea_add_on ADD FOREIGN KEY (custom_milk_tea_id) REFERENCES Custom_milk_tea(custom_milk_tea_id);



