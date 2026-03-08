# University Management System

Backend REST API for managing academic operations in a university.

This project simulates a real-world backend system used to manage students, professors, departments, courses, enrollments and academic evaluations.

The system is designed following **clean backend architecture practices** using **Spring Boot, Spring Security and PostgreSQL**.

This project is part of my backend portfolio to demonstrate **production-style backend development skills with Java and Spring Boot**.

---

# Features

* JWT Authentication
* Role-based authorization
* Student management
* Professor management
* Department management
* Course management
* Enrollment system
* Academic evaluations
* Business rule validation
* Clean layered architecture
* DTO-based API design
* Swagger API documentation
* Dockerized database

---

# Tech Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* MapStruct
* Jakarta Validation
* SpringDoc OpenAPI (Swagger)

## Frontend

* React
* Axios
* React Router

## Infrastructure

* Docker
* Docker Compose

---

# System Architecture

The backend follows a **layered architecture inspired by Clean Architecture principles**.

```
controller
service
repository
entity
dto
mapper
security
config
exception
```

### Controller

Handles HTTP requests and responses.

Responsibilities:

* Receive API requests
* Validate input
* Return DTO responses
* Call the service layer

---

### Service

Contains all business logic.

Responsibilities:

* Business rules
* System orchestration
* Validation beyond simple DTO validation

---

### Repository

Handles database access using **Spring Data JPA**.

Responsibilities:

* Database queries
* Persistence operations

---

### DTO

DTOs are used to avoid exposing JPA entities directly.

Responsibilities:

* Request validation
* API response structure

---

### Mapper

Responsible for converting between **Entities and DTOs**.

---

# Authentication & Security

Authentication is implemented using **JWT (JSON Web Tokens)**.

Users authenticate using **email and password**.

Security components implemented:

* `SecurityConfig`
* `JwtService`
* `CustomUserDetailsService`
* `AuthController`

After authentication the API returns a **JWT token** that must be included in requests to protected endpoints.

---

# API Documentation

Swagger documentation is automatically generated.

Available at:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows:

* Exploring endpoints
* Testing requests
* Viewing request/response models

---

# Domain Model

The system models the academic structure of a university.

---

## User

Authentication entity.

Fields:

```
id
email
password
name
lastname
role
enabled
createdAt
```

Roles:

```
ROLE_ADMIN
ROLE_PROFESSOR
ROLE_STUDENT
```

---

## Student

Represents a university student.

Relationships:

```
Student → User
Student → Enrollment
```

---

## Professor

Represents a university professor.

Relationships:

```
Professor → User
Professor → Department
Professor → Course
```

---

## Department

Represents an academic department.

Relationships:

```
Department → Professor
Department → Course
```

---

## Course

Represents a course offered by the university.

Relationships:

```
Course → Department
Course → Professor
Course → Enrollment
```

---

## Enrollment

Represents the enrollment of a student in a course.

Constraints:

* A student cannot enroll twice in the same course
* Course capacity cannot be exceeded

Status values:

```
ENROLLED
CANCELLED
COMPLETED
```

---

## Evaluation

Represents a student's grade in a course.

Rules:

* Grade must be between **0 and 10**

---

# Business Rules

The system enforces several business rules:

* Prevent duplicate enrollments
* Validate course capacity
* Restrict evaluation to the course professor
* Validate grade range
* Protect endpoints using role-based authorization

All business rules are implemented in the **Service layer**.

---

# Running the Project

## Requirements

* Java 21
* Maven
* Docker

---

## Start MySQL

Run the database container:

```
docker-compose up -d
```

---

## Run the Spring Boot application

```
mvn spring-boot:run
```

The API will be available at:

http://localhost:8080

---

## API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

## Local Development

During development, the **Spring Boot application runs locally**, while the **MySQL database runs inside a Docker container**.

This setup allows faster development, easier debugging, and avoids rebuilding Docker images during development.

# Example API Endpoints

Authentication:

```
POST /auth/register
POST /auth/login
```

Students:

```
GET /students
POST /students
GET /students/{id}
```

Courses:

```
GET /courses
POST /courses
```

Enrollments:

```
POST /enrollments
```

Evaluations:

```
POST /evaluations
```

---

# Project Structure

```
src/main/java/com/university/ums

controller
service
repository
entity
dto
mapper
security
config
exception
```

---

# Author

**DARIUS ADRIAN BENTA BURZA**  
Backend Developer focused on **Java and Spring Boot**

GitHub: https://github.com/DariusAdrianBenta
LinkedIn: https://www.linkedin.com/in/dariusadrianbenta/

---

This project is part of my **backend development portfolio** and was built to demonstrate practical experience with modern backend technologies and professional software architecture.

Through this project I showcase skills in:

- REST API design
- Secure authentication using **JWT**
- Layered architecture and clean code practices
- Business logic implementation in the service layer
- Database modeling with **JPA / Hibernate**
- API documentation using **Swagger / OpenAPI**
- Backend development with **Spring Boot**
- Containerized database using **Docker**

---

The goal of this project is to simulate a **real-world university management system backend**, implementing typical academic domain operations such as student enrollment, course management and academic evaluations.
```
