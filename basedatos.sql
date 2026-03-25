-- SQL script to create inventory management database and tables

CREATE DATABASE IF NOT EXISTS InventoryDB;
USE InventoryDB;

CREATE TABLE IF NOT EXISTS Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Description TEXT,
    Price DECIMAL(10, 2) NOT NULL,
    Quantity INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Suppliers (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    ContactEmail VARCHAR(100),
    ContactPhone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    ProductID INT,
    Quantity INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
