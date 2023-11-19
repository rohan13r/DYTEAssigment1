# Log Management System

## Overview

This is a simple log management system built with Spring Boot. It allows users to ingest logs, search logs using various filters, and perform advanced queries.

## How to Run the Project

1. **Build the Project:**

    ```bash
    mvn clean install
    ```

2. **Run the Application:**

    ```bash
    java -jar target/log-management-system.jar
    ```

3. **Access the Application:**

    Open your web browser and go to [http://localhost:3000](http://localhost:3000).

## System Design

The system follows a client-server architecture using Spring Boot for the backend. Logs are ingested through a RESTful API, and the system persists log data in a PostgreSQL database. The application provides a CLI interface for users to interact with the log data. The backend supports various features like full-text search, filtering, and real-time log ingestion.

## Features Implemented

1. **Log Ingestion:**
   - Ingest logs through the `/logs` endpoint.

2. **Search and Filtering:**
   - Search logs based on level, message, timestamp, and more.
   - Support for full-text search and regular expressions.

3. **Date Range Search:**
   - Search logs within specific date ranges.

4. **Real-time Log Ingestion and Search (Bonus):**
   - Mechanisms for handling real-time log ingestion and searching.

5. **Role-Based Access Control (Bonus):**
   - Implemented role-based access control to restrict access to the query interface.

## Identified Issues

1. **Performance Concerns:**
   - In a production environment with a large volume of logs, performance may be a concern. Consider optimizing database queries and introducing caching mechanisms.

2. **Security:**
   - The application currently lacks proper security measures. Consider implementing secure communication (HTTPS) and user authentication.

3. **Real-time Features Limitations:**
   - Real-time log ingestion and search features may have limitations in a highly distributed or scaled environment. Consider using dedicated tools for log streaming and indexing.

4. **Error Handling:**
   - Error handling is currently minimal. Implement comprehensive error handling to provide meaningful feedback to users.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

