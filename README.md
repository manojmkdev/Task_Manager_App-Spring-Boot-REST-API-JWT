Student Task Manager – Spring Boot REST API + JWT

A backend REST API built using Spring Boot that provides JWT-based authentication, secure task management, MySQL database integration, and Swagger (OpenAPI) documentation.

This project demonstrates clean architecture, stateless authentication, and real-world backend development practices.

🚀 Features

User Registration & Login
JWT Authentication (Stateless)
Secure APIs using Spring Security
User-based Task Management
MySQL Database with JPA/Hibernate
Swagger UI for API documentation & testing
Clean layered architecture (Controller, Service, Repository)

🛠️ Tech Stack

Java 17
Spring Boot
Spring Security
JWT (io.jsonwebtoken – JJWT)
Spring Data JPA (Hibernate)
MySQL
Spring OpenAPI (Swagger)

Maven

📂 Project Structure

<img width="802" height="341" alt="image" src="https://github.com/user-attachments/assets/7463615e-d24d-4c65-8c5f-72e98488dae1" />


🔐 Authentication Flow (JWT)

User registers using /auth/register

User logs in using /auth/login

Server returns a JWT token

Client sends token in header:

Authorization: Bearer <JWT_TOKEN>

JWT filter validates the token for every secured request

📌 API Endpoints

Authentication

Method	Endpoint	Description
POST	/auth/register	Register new user
POST	/auth/login	Login & get JWT

Tasks

Method	Endpoint	Description
POST	/tasks/assignTask	Create task (Authenticated)
GET	/tasks/getAllTask	View logged-in user tasks

🧪 Swagger (OpenAPI)

Swagger UI is enabled for easy API testing.


📍 URL:

http://localhost:8080/swagger-ui/index.html


🔐 Using JWT in Swagger

Call /auth/login

Copy the JWT token

Click Authorize

Enter:

Bearer <JWT_TOKEN>


Call secured APIs

🗄️ Database Configuration (MySQL)

Create database:
CREATE DATABASE student_task_db;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student_task_db
spring.datasource.username=root
spring.datasource.password=your_password

▶️ How to Run the Project

git clone https://github.com/<your-username>/Task_Manager_App-Spring-Boot-REST-API-JWT.git
cd student-task-manager
mvn clean install
mvn spring-boot:run

🧠 Key Concepts Demonstrated

Stateless authentication using JWT
Custom security filter using OncePerRequestFilter
Secure REST APIs with Spring Security
JPA entity relationships
Swagger integration with JWT authorization
Clean separation of concerns
