CREATE DATABASE IF NOT EXISTS incident_management;
USE incident_management;

CREATE USER IF NOT EXISTS 'admin'@'%' IDENTIFIED BY 'adminpass';
GRANT ALL PRIVILEGES ON incident_management.* TO 'admin'@'%';

CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'p@ssword';
GRANT SELECT, INSERT, UPDATE ON incident_management.* TO 'user'@'%';

FLUSH PRIVILEGES;


DROP TABLE IF EXISTS incidents;
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    username VARCHAR(100),
    password VARCHAR(255),
    phone VARCHAR(20)
);

CREATE TABLE incidents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date_time VARCHAR(50),
    origin_employee_id INT,
    destination_employee_id INT,
    details TEXT,
    type CHAR(1),
    FOREIGN KEY (origin_employee_id) REFERENCES employees(id),
    FOREIGN KEY (destination_employee_id) REFERENCES employees(id)
);

