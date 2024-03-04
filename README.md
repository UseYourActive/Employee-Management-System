# Employee Management System with Spring Boot

This project is a comprehensive Employee Management System built using Spring Boot. It employs various Spring Cloud technologies to ensure robustness and scalability.

## Spring Cloud Technologies Utilized:

- **API Gateway (Spring Cloud Gateway):** Facilitates routing between microservices, serving as a central point of entry for the project.

- **Configuration Server (Spring Cloud Config Server & Spring Cloud Bus):** Centralized microservice managing configurations for all other microservices.

- **Circuit Breakers (Resilience4j):** Ensures resilience and fault tolerance in the system.

- **Load Balancers:** Enables even distribution of loads among microservices, ensuring optimal performance.

- **OpenFeign:** Facilitates communication between microservices, simplifying service-to-service interactions.

- **Service Registry:** Allows for the discovery of instances of microservices, enhancing scalability and reliability.

## General Microservices:

- **Logger Service:** Responsible for storing important events generated by other microservices, utilizing Kafka/RabbitMQ for efficient event handling.

- **Notification Service:** Sends notifications via email using JavaMailSender and SMS via Twilio, enhancing user communication capabilities.

- **Payment Service:** Integrates Paypal to facilitate money transactions within the system, providing seamless payment processing.

- **User Authentication Service:** Serves as the authentication and authorization point, utilizing JWT for secure user management.

- **Chat Service:** Enables real-time chat functionality among logged-in users, leveraging Websockets for efficient communication.

## Project Specific Microservices:

- **Employee Service:** Handles operations related to employees within the system.

- **Department Service:** Manages department-related functionalities, ensuring efficient department management.

- **Leave Service:** Facilitates leave management functionalities, allowing for easy tracking and management of employee leave requests.

- **Asset Service:** Responsible for managing company assets, including procurement, allocation, and tracking.

- **Attendance Service:** Handles attendance tracking and management for employees, ensuring accurate records of work hours.

- **Training and Development Service:** Manages employee training programs and career development initiatives, facilitating skill enhancement and career growth opportunities.
