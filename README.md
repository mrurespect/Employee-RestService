# Employee Management System

## Overview
The **Employee Management System** is a Spring Boot-based application that provides a RESTful API for managing employee information. It incorporates Spring Security for authentication and authorization, ensuring secure access to various endpoints based on user roles. The project follows a clean and modular architecture, making it easily extensible and maintainable.

## Key Features

### Security Configuration
Implements Spring Security to control access to API endpoints based on user roles (EMPLOYEE, MANAGER, ADMIN). Provides options for user details management, including in-memory and JDBC configurations.
![image](https://github.com/mrurespect/Employee-RestService/assets/121578147/388a691f-e32e-48ee-80f8-0443f4282343)

### RESTful API Controller
Utilizes a RESTful API controller (`EmployeeRestController`) to perform CRUD operations on employee data. The controller supports the following endpoints:

- **Retrieve All Employees:**
  - **Endpoint:** `GET /api/employees`
  - **Description:** Retrieves a list of all employees.

- **Retrieve Employee by ID:**
  - **Endpoint:** `GET /api/employees/{employeeId}`
  - **Description:** Retrieves a specific employee by their ID.

- **Add New Employee:**
  - **Endpoint:** `POST /api/employees`
  - **Description:** Adds a new employee to the system.

- **Update Employee:**
  - **Endpoint:** `PUT /api/employees`
  - **Description:** Updates an existing employee's information.

- **Delete Employee by ID:**
  - **Endpoint:** `DELETE /api/employees/{employeeId}`
  - **Description:** Deletes a specific employee by their ID.

### Service Layer
Employs a service layer (`EmployeeService`) to handle business logic related to employee data. The service interacts with a data source (e.g., a database) for CRUD operations.

### Exception Handling
Implements exception handling, including a custom `EmployeeNotFoundException` for scenarios where an employee is not found.

### Data Persistence
Utilizes Spring Data JPA for easy and efficient data persistence, allowing interaction with a MySQL database. The data model includes an `Employee` entity with relevant attributes.

### Build and Dependency Management
Configured using Maven, ensuring easy project build and management. Dependencies include Spring Boot Starter modules for web, data JPA, security, and MySQL Connector.

