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

- **Database Name:** SurvivorResource_db

### Database Initialization Script

To initialize the database with the necessary tables and schema, execute the following SQL script:

```sql
-- Create Database if not exists
CREATE DATABASE IF NOT EXISTS SurvivorResource_db;

4. Run the Project
Open the project in your preferred IDE (e.g., IntelliJ IDEA).
Run the main class (contains the main method) to start the Spring Boot application

5. Accessing Endpoints
Use tools like Postman or cURL to interact with the API endpoints.

GET
getAllSurvivors
http://localhost:8085/api/survivors


GET
getSurvivorByID
http://localhost:8085/api/survivors/1
﻿

POST
createSurvivor
http://localhost:8085/api/survivors
﻿

Body
raw (json)
View More
json
{
    "name": "Zombie with Inventory",
    "age": 25,
    "gender": "Female",
    "latitude": 12.34,
    "longitude": 57.78,
    "infectionCounter": 1,
    "inventory": {
        "water": true,
        "food": true,
        "medication": false,
        "ammunition": true
    }
}
PUT
updateSurvivorLocation
http://localhost:8085/api/survivors/updateSurvivorLocation/1
﻿

Body
raw (json)
View More
json
{
  "latitude": 12.34,
  "longitude": 34.78
}
PUT
updateInfectionStatus
http://localhost:8085/api/survivors/updateInfectionStatus/1
﻿

Body
raw (json)
View More
json
{
  "infectionCounter": 4
}
GET
reportInfectedList
http://localhost:8085/api/survivors/infectedList
﻿

GET
reportNonInfectedList
http://localhost:8085/api/survivors/nonInfectedList
﻿

GET
calculateNonInfectedPercentage
http://localhost:8085/api/survivors/nonInfectedPercentage
﻿

GET
calculateInfectedPercentage
http://localhost:8085/api/survivors/infectedPercentage
﻿

GET
RobotList
http://localhost:8085/api/robotData(Turn off Zscaler Internet Security)
http://localhost:8085/api/flyingRobots
http://localhost:8085/api/landRobots
﻿


