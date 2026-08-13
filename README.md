# 📚 Catalogue Management API

A backend REST API built with **Java 17 and Spring Boot** for managing a personal book catalogue.

The application provides CRUD operations for books and follows a layered architecture using **Controller → Service → Repository** separation. It uses **PostgreSQL** for persistent data storage and includes **Swagger/OpenAPI documentation**, automated testing, Docker support, and GitHub Actions.

---

## 🚀 Project Overview

The Catalogue Management API allows users to:

* 📖 View all books
* 🔍 Find a book by ID
* ➕ Add a new book
* 📝 Update an existing book
* ❌ Delete a book
* 📚 Manage catalogue data through REST endpoints
* 📋 Explore and test the API using Swagger UI

The project was designed to demonstrate practical backend development using the **Spring Boot ecosystem**, including REST API development, database persistence, testing, containerisation, and CI/CD.

---

## 🏗️ System Architecture

The application follows a **layered architecture** based on separation of concerns.

```text
                    Client
                      │
                      │ HTTP Request
                      ▼
              ┌───────────────┐
              │   REST API    │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │  Controller   │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │    Service    │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │  Repository   │
              └───────┬───────┘
                      │
                      ▼
              ┌───────────────┐
              │  PostgreSQL   │
              └───────────────┘
```

### Architecture Layers

**Controller**

Handles incoming HTTP requests and returns HTTP responses.

**Service**

Contains the application's business logic and coordinates operations between the controller and repository.

**Repository**

Uses Spring Data JPA to communicate with the PostgreSQL database.

**PostgreSQL**

Provides persistent storage for catalogue data.

---

## 🛠️ Tech Stack

| Technology        | Purpose                         |
| ----------------- | ------------------------------- |
| Java 17           | Programming language            |
| Spring Boot 3     | Backend framework               |
| Spring Web        | REST API development            |
| Spring Data JPA   | Database persistence            |
| PostgreSQL        | Relational database             |
| Maven             | Build and dependency management |
| Swagger / OpenAPI | API documentation               |
| JUnit             | Unit testing                    |
| Mockito           | Mocking and test isolation      |
| Docker            | Containerisation                |
| GitHub Actions    | CI/CD                           |

---

## 📦 Features

### Book Management

* Get all books
* Get a book by ID
* Create a book
* Update a book
* Delete a book

### API Documentation

The API is documented using **Swagger/OpenAPI**, allowing developers to view available endpoints and send requests directly from the browser.

### Testing

The project includes automated tests using:

* JUnit
* Mockito
* Spring Boot testing utilities

### Containerisation

The application can be packaged and executed using Docker.

### CI/CD

GitHub Actions is used to automate the build and testing process.

---

## 🔌 API Endpoints

| Method   | Endpoint          | Description       |
| -------- | ----------------- | ----------------- |
| `GET`    | `/api/books`      | Get all books     |
| `GET`    | `/api/books/{id}` | Get a book by ID  |
| `POST`   | `/api/books`      | Create a new book |
| `PUT`    | `/api/books/{id}` | Update a book     |
| `DELETE` | `/api/books/{id}` | Delete a book     |

### Example Request

```http
GET /api/books
```

Example response:

```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin"
  }
]
```

> Replace the example endpoint paths and JSON fields above if your implementation uses different names.

---

# 📁 Project Structure

A typical structure for the application is:

```text
catalogue-management/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│   │
│   └── test/
│       └── java/
│           └── ...
│
├── Dockerfile
├── pom.xml
├── README.md
└── .github/
    └── workflows/
        └── ...
```

---

# ⚙️ Getting Started

## Prerequisites

Before running the application, make sure you have:

* Java 17
* Maven
* PostgreSQL

If you are using Docker, you only need Docker installed.

---

# 💻 Running Locally

## 1. Clone the Repository

```bash
git clone https://github.com/kaahoza/catalogue-management.git
cd catalogue-management
```

## 2. Configure PostgreSQL

Create a PostgreSQL database for the application.

For example:

```sql
CREATE DATABASE catalogue;
```

Configure the database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogue
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Do not commit real database passwords or secrets to GitHub. Use environment variables or a local configuration file for sensitive values.

---

## 3. Build the Application

```bash
mvn clean package
```

This creates the application JAR inside the `target` directory.

---

## 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the generated JAR:

```bash
java -jar target/catalogue-management-0.0.1-SNAPSHOT.jar
```

The API should then be available at:

```text
http://localhost:8080
```

---

# 🐳 Running with Docker

Docker can be used to package and run the Spring Boot application in a container.

## 1. Build the Docker Image

From the project root:

```bash
docker build -t catalogue-management .
```

## 2. Create a Docker Network

```bash
docker network create catalogue-network
```

## 3. Run PostgreSQL

Example:

```bash
docker run -d \
  --name catalogue-postgres \
  --network catalogue-network \
  -e POSTGRES_DB=catalogue \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  postgres:16
```

## 4. Run the Application

```bash
docker run -d \
  --name catalogue-management \
  --network catalogue-network \
  -p 8080:8080 \
  catalogue-management
```

The application will be available at:

```text
http://localhost:8080
```

> Make sure your Spring Boot datasource configuration uses the PostgreSQL container hostname (`catalogue-postgres`) when the application itself is running inside Docker.

---

# 📖 Swagger API Documentation

Once the application is running, Swagger UI can be accessed at:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger provides an interactive interface for:

* Viewing available endpoints
* Inspecting request/response models
* Sending API requests
* Testing CRUD operations

### Swagger UI

![Swagger UI](./img.png)

---

# 🧪 Testing

Run the test suite using Maven:

```bash
mvn test
```

The project uses:

```text
JUnit
Mockito
Spring Boot Test
```

Tests focus on validating application behaviour while keeping business logic isolated from external dependencies where appropriate.

---

# 🔄 Continuous Integration

GitHub Actions is used to automate the project's build and test process.

The CI pipeline can be used to:

```text
Push / Pull Request
        │
        ▼
   GitHub Actions
        │
        ▼
  Install Dependencies
        │
        ▼
     Run Tests
        │
        ▼
    Build Project
```

This helps ensure that changes are automatically validated before they are merged.

---

# 🔐 Configuration & Security

Sensitive configuration such as:

* Database passwords
* API keys
* Secrets
* Environment-specific credentials

should not be committed directly to the repository.

For production environments, these values should be supplied through environment variables or a secure secrets management solution.

---

# 🎯 Project Goals

This project was built to demonstrate practical knowledge of:

* Java backend development
* Spring Boot
* REST API design
* Layered architecture
* Spring Data JPA
* PostgreSQL
* Unit testing
* Docker
* API documentation
* CI/CD with GitHub Actions
* Git and GitHub development workflows

---

# 🔮 Future Improvements

Potential future improvements include:

* 🔐 Authentication and authorisation using Spring Security
* 👤 User accounts and personal catalogues
* 🔎 Book search and filtering
* 📄 Pagination and sorting
* ✅ Request validation
* ❗ Global exception handling
* 📝 Improved API error responses
* 🐳 Docker Compose for the application and database
* 🚀 Cloud deployment
* 📊 API monitoring and logging

---

# 👨‍💻 Author

**Kanyisa Anele Hoza**

Junior Software Developer | Java | Spring Boot | REST APIs | PostgreSQL

* GitHub: https://github.com/kaahoza
* Portfolio: https://portfolio-anele-s-projects.vercel.app/
* LinkedIn: [www.linkedin.com/in/anele-kanyisa-hoza](http://www.linkedin.com/in/anele-kanyisa-hoza)

---

## 📄 License

This project is available for educational and portfolio purposes.
