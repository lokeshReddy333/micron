Product Management API
	Overview
		This project is a Spring Boot REST API for managing products.
		It provides basic CRUD operations to create, update, read and delete.
The application uses
	•	Spring Boot
	•	Spring Data JPA
	•	MySQL
	•	Maven
Features
	•	Create a new product
	•	Get all products
	•	Get product by ID
	•	Update product details by ID
	•	Delete a product
	•	Validation for product fields like name, price
Technologies Used
	•	Java 21
	•	Spring boot
	•	Spring Data JPA
	•	MySQL
	•	Maven
Product Entity
	The product table contains the following fields:

Field			Type			Description

Id			String			id (String/UUID, unique, automatically generated) Name			String			name(required)
Price			Double			required-must be greater than 0
Description		String			optional
Available		Boolean		default to true
createdAt		Date/Time		automatically set upon creation
updatedAt		Date/Time		automatically set upon update

API Endpoints
	Create Product
	
	Post/Products
	Request Body
		{
			"available": false,
        	"description": "yes",
        	"name": "Dilisha Reddy",
        	"price": 10000.0
		}
Get All Products
	
	GET /products
Get Product By ID
	
	GET /products/{id}
Update Product
	PUT /products/{id}
		{
			"available": false,
        	"description": "yes",
        	"name": "Jangam Dilisha Reddy",
        	"price": 10000.0
		}
Delete Product
	
	DELETE /products/{id}

Validation Rules
	•	Product name should not be null or empty
	•	Product price should be greater than 0
Database Configuration
	Update application.properties
	
	#data source
	spring.datasource.url=jdbc:mysql://localhost:3306/product
	spring.datasource.username=root
	spring.datasource.password=root@123456789
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.show-sql=true

Build and Run

Clone the repository:
	
	Git clone <repository-url>

Build the project

	Mvn clean install

Run the application

	Mvn spring-boot:run

Author
	Lokesh Jangam
