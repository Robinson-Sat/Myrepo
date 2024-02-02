# Spring Boot Project: Robot Survivor API

## Overview

This Spring Boot project implements an API for managing robot survivors in a post-apocalyptic world.

## Prerequisites

- Java Development Kit (JDK) version 17 or higher
- PostgreSQL database installed

## Getting Started

Follow these steps to set up and run the project locally:

### 1. Check JDK Version

Ensure that you have JDK 11 or a higher version installed. You can check your Java version by running the following command:

```bash
java -version

2. Clone the Repository
Clone this repository to your local machine using the following command:
git clone https://github.com/your-username/robot-survivor-api.git

3. Database Setup
Install PostgreSQL on your machine if not already installed.
Create a database for the project (e.g., robot_db).

4. Database Configuration
In the src/main/resources/application.properties file, update the following properties with your database connection details:
spring.datasource.url=jdbc:postgresql://localhost:5432/robot_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

5. Run the Project
Open the project in your preferred IDE (e.g., IntelliJ IDEA).
Run the main class (contains the main method) to start the Spring Boot application

6. Accessing Endpoints
Use tools like Postman or cURL to interact with the API endpoints.
API Base URL: http://localhost:8081/api/survivors
http://localhost:8081/api/robotData To call the Robot CPU API
