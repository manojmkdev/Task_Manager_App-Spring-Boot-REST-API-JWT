# Student Task Manager – Spring Boot REST API + JWT

A backend REST API built using **Spring Boot** that provides **JWT-based authentication**, **secure task management**, **MySQL database integration**, and **Swagger (OpenAPI) documentation**.

This project demonstrates **clean architecture**, **stateless authentication**, and **real-world backend development practices**.

## 🚀 Features

- User Registration & Login  
- JWT Authentication (Stateless)  
- Secure APIs using Spring Security  
- User-based Task Management  
- MySQL Database with JPA/Hibernate  
- Swagger UI for API documentation & testing  
- Clean layered architecture (Controller, Service, Repository)

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (io.jsonwebtoken – JJWT)  
- Spring Data JPA (Hibernate)  
- MySQL  
- Spring OpenAPI (Swagger)  
- Maven  


## 📂 Project Structure

<img width="370" height="201" alt="image" src="https://github.com/user-attachments/assets/a663df92-ec00-46f3-9a65-77eaac0accb2" />


## 🔐 Authentication Flow (JWT)

1. User registers using `/auth/register`
2. User logs in using `/auth/login`
3. Server returns a **JWT token**
4. Client sends token in request header:
5. JWT filter validates the token for every secured request


## 📌 API Endpoints

### Authentication

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login & get JWT token |

### Tasks

| Method | Endpoint | Description |
|------|---------|------------|
| POST | `/tasks/assignTask` | Create task (Authenticated) |
| GET | `/tasks/getAllTask` | View logged-in user tasks |


## 🧪 Swagger (OpenAPI)

Swagger UI is enabled for easy API testing.

**URL**

http://localhost:8080/swagger-ui/index.html

### 🔐 Using JWT in Swagger

1. Call `/auth/login`
2. Copy the JWT token
3. Click **Authorize**
4. Enter: <JWT_TOKEN>

## Update application.properties

- spring.datasource.url=jdbc:mysql://localhost:3306/student_task_db
- spring.datasource.username=root
- spring.datasource.password=your_password

## How to Run the Project

- git clone https://github.com/<your-username>/Task_Manager_App-Spring-Boot-REST-API-JWT.git
- cd student-task-manager
- mvn clean install
- mvn spring-boot:run





