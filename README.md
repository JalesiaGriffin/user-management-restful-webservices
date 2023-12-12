# User Management RESTful Web Services

This project is a User Management system built with Spring Web, Spring Data JPA, MySQL Driver, and Lombok. It follows a structured architecture employing the DTO -> Controller -> Service -> Repository model and provides CRUD RESTful APIs for seamless user data management.

## Technologies Used

- **Spring Web:** Facilitates the creation of RESTful APIs for efficient communication.
- **Spring Data JPA:** Simplifies database operations using Java Persistence API.
- **MySQL Driver:** Connector for MySQL database.
- **Lombok:** Enhances code readability by reducing boilerplate code.

## Project Structure

The project is organized into the following components:

- **DTO (Data Transfer Objects):**
  - Efficiently maps entities to client requests.

- **Controller:**
  - Manages incoming HTTP requests, interacting with the service layer.

- **Service:**
  - Implements business logic, communicates with the repository, and includes exception handling.

- **Repository:**
  - Handles database operations using Spring Data JPA.

## Exception Handling

- **ResourceNotFoundException:**
  - Custom exception for handling resource not found situations based on the User ID.

- **EmailNotFoundException:**
  - Custom exception for handling email not found situations.

- **GlobalExceptionHandler:**
  - Manages global exceptions, providing consistent error responses.

## CRUD Operations

The application supports CRUD operations through the following RESTful APIs:

- **Create User:**
  - `POST /api/users`

- **Get All Users:**
  - `GET /api/users`

- **Get User by ID:**
  - `GET /api/users/{id}`

- **Update User:**
  - `PUT /api/users/{id}`

- **Delete User:**
  - `DELETE /api/users/{id}`

## Build and Run

To build and run the project, use the following commands:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Exceptional User Experience

The project ensures a smooth and reliable user experience through robust exception handling, adhering to RESTful principles.

## Contribution

Feel free to contribute to the project by opening issues or submitting pull requests.

