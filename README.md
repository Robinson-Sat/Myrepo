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
## Database Initialization

### Database Information

- **Database Name:** robot_db

### Survivors Table

#### Fields

- `id` (Serial, Primary Key)
- `name` (String, Not Null)
- `age` (Integer, Not Null)
- `gender` (String, Not Null)
- `latitude` (Double Precision, Not Null)
- `longitude` (Double Precision, Not Null)
- `has_water` (Boolean, Not Null)
- `has_food` (Boolean, Not Null)
- `has_medication` (Boolean, Not Null)
- `has_ammunition` (Boolean, Not Null)
- `is_infected` (Boolean, Not Null)
- `infection_counter` (Integer, Default 0)

### Database Initialization Script

To initialize the database with the necessary tables and schema, execute the following SQL script:

```sql
-- Create Database if not exists
CREATE DATABASE IF NOT EXISTS robot_db;

-- Use the created database
USE robot_db;

-- Create Survivors Table
CREATE TABLE IF NOT EXISTS survivors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL,
    gender VARCHAR(10) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    has_water BOOLEAN NOT NULL,
    has_food BOOLEAN NOT NULL,
    has_medication BOOLEAN NOT NULL,
    has_ammunition BOOLEAN NOT NULL,
    is_infected BOOLEAN NOT NULL,
    infection_counter INTEGER DEFAULT 0
);

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
Infected Percentage: http://localhost:8081/api/survivors/infectedPercentage
Non-Infected Percentage: http://localhost:8081/api/survivors/nonInfectedPercentage
Infected List: http://localhost:8081/api/survivors/infectedList
Non-Infected List: http://localhost:8081/api/survivors/nonInfectedList
