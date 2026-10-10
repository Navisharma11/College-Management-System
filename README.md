# College Management System

A web-based College Management System built using **Java, Spring Boot, Spring MVC, Spring Data JPA, Thymeleaf, and MySQL**.

This project helps manage student records through a web application using a layered architecture.

## Features

- Register new students
- View all registered students
- Update student details
- Store student records in MySQL
- Handle student forms using Spring MVC
- Display dynamic pages using Thymeleaf
- Show messages after successful operations

## Tech Stack

- **Java**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **Thymeleaf**
- **HTML5 and CSS3**
- **MySQL**
- **Maven**
- **Git and GitHub**

## Architecture

The application follows a layered architecture:

```text
Browser
   |
   v
Web Controller
   |
   v
Service Layer
   |
   v
Repository Layer
   |
   v
MySQL Database
```

## Project Structure

```text
college-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/navisharma/collegemanagementsystem/
│   │   │       ├── model/
│   │   │       ├── repo/
│   │   │       ├── rest/
│   │   │       ├── service/
│   │   │       ├── web/
│   │   │       └── CollegeManagementSystemApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── css/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── .gitignore
└── README.md
```

## Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/Navisharma11/College-Management-System.git
cd College-Management-System
```

### 2. Create the MySQL Database

```sql
CREATE DATABASE college_management_system;
```

### 3. Configure the Database

Configure your MySQL URL, username, and password in `application.properties`. Keep your actual database password private and never commit secrets to GitHub.

### 4. Run the Application

On Linux, run:

```bash
./mvnw spring-boot:run
```

### 5. Open the Application

Visit the following URL in your browser:

http://localhost:1167/CMSApp/

## Learning Outcomes

- Understanding Spring Boot and MVC architecture
- Implementing dependency injection
- Performing database operations using Spring Data JPA
- Connecting Java applications to MySQL
- Creating dynamic web pages using Thymeleaf
- Organizing code using a layered architecture
- Managing projects using Git and GitHub

## Future Improvements

- Add student deletion functionality
- Implement search and filtering
- Add authentication using Spring Security
- Improve form validation and exception handling
- Add unit and integration testing
- Deploy the application online

## Author

**Navi Sharma**

GitHub: [Navisharma11](https://github.com/Navisharma11)