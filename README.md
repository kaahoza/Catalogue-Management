# 📚 Catalogue Management API

![Java CI](https://github.com/kaahoza/Catalogue-Management/actions/workflows/maven.yml/badge.svg)

A backend REST API built with **Java 17 and Spring Boot** for managing a personal book catalogue.

The application provides CRUD operations for books and follows a layered architecture using:

```text
Controller → Service → Repository → PostgreSQL
```

The project demonstrates practical backend development practices including:

- REST API development
- Layered architecture
- PostgreSQL persistence
- Spring Data JPA
- Unit testing
- Controller testing
- Integration testing
- Mockito
- MockMvc
- Testcontainers
- Docker
- Docker Compose
- Swagger/OpenAPI
- Environment-based configuration
- GitHub Actions CI

The project is designed as a portfolio project to demonstrate practical Java and Spring Boot development skills.

---

# 🚀 Project Overview

The Catalogue Management API allows users to manage a collection of books through REST endpoints.

### Core functionality

- 📖 View all books
- 🔍 Find a book by ID
- ➕ Add a new book
- 📝 Update an existing book
- ❌ Delete a book
- 📚 Persist catalogue data using PostgreSQL
- 📋 Explore and test the API using Swagger UI

The application separates responsibilities into different layers, making the code easier to maintain, test, and extend.

---

# 🏗️ System Architecture

The application follows a layered architecture.

```text
                         Client
                           │
                           │ HTTP Request
                           ▼
                   ┌───────────────┐
                   │    REST API   │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │   Controller  │
                   │   Web Layer   │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │    Service    │
                   │ Business Logic│
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │   Repository  │
                   │   Data Layer  │
                   └───────┬───────┘
                           │
                           ▼
                   ┌───────────────┐
                   │  PostgreSQL   │
                   │   Database    │
                   └───────────────┘
```

## Architecture Layers

### Controller

The Controller layer handles incoming HTTP requests and returns HTTP responses.

Responsibilities include:

- Receiving API requests
- Mapping requests to application operations
- Returning responses to clients

### Service

The Service layer contains the application's business logic.

Responsibilities include:

- Coordinating application operations
- Communicating with repositories
- Processing book operations

### Repository

The Repository layer handles data access using **Spring Data JPA**.

Responsibilities include:

- Persisting books
- Retrieving books
- Updating books
- Deleting books

### PostgreSQL

PostgreSQL provides persistent relational data storage for the application.

---

# 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java 17** | Programming language |
| **Spring Boot 3** | Backend framework |
| **Spring Web** | REST API development |
| **Spring Data JPA** | Database persistence |
| **PostgreSQL** | Relational database |
| **Maven** | Build and dependency management |
| **JUnit 5** | Automated testing |
| **Mockito** | Mocking dependencies |
| **MockMvc** | Controller/API testing |
| **Testcontainers** | Integration testing with PostgreSQL |
| **Swagger / OpenAPI** | API documentation |
| **Docker** | Application containerisation |
| **Docker Compose** | Application/database orchestration |
| **GitHub Actions** | Continuous integration |

---

# 📦 Features

## 📚 Book Management

The API supports:

- Get all books
- Get a book by ID
- Create a book
- Update a book
- Delete a book

## 🌐 REST API

The application exposes HTTP endpoints for interacting with catalogue data.

## 📖 Swagger / OpenAPI

Swagger provides an interactive interface for exploring and testing the API directly from a browser.

## 🧪 Automated Testing

The project includes multiple testing strategies:

```text
Unit Tests
    ↓
Controller Tests
    ↓
Integration Tests
```

The testing stack includes:

- JUnit 5
- Mockito
- Spring Boot Test
- MockMvc
- Testcontainers
- PostgreSQL

## 🐳 Docker

The application can be packaged and executed inside a Docker container.

## 🐳 Docker Compose

Docker Compose can be used to run the application and PostgreSQL database together.

```text
┌───────────────────────────────────────┐
│           Docker Compose              │
│                                       │
│  ┌─────────────────┐                  │
│  │   Spring Boot   │                  │
│  │   Application   │                  │
│  │     :8080       │                  │
│  └────────┬────────┘                  │
│           │                           │
│           │ JDBC                      │
│           ▼                           │
│  ┌─────────────────┐                  │
│  │    PostgreSQL    │                  │
│  │      :5432       │                  │
│  └─────────────────┘                  │
│                                       │
└───────────────────────────────────────┘
```

Start the application with:

```bash
docker compose up --build
```

## ⚙️ Continuous Integration

GitHub Actions is used to automatically build and test the application.

The CI pipeline is designed to validate changes before they are merged.

---

# 🔌 API Endpoints

The API endpoints are defined by the application's `BookController`.

The current controller tests cover the following operations:

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/books/getAllBooks` | Get all books |
| `POST` | `/api/books/addBook` | Add a new book |
| `GET` | `/api/books/...` | Get a book by ID |
| `PUT` | `/api/books/...` | Update a book |
| `DELETE` | `/api/books/...` | Delete a book |

> The exact ID, update, and delete mappings should match the current `BookController`. Swagger UI provides the authoritative list of available endpoints.

---

# 📝 Example Book

A book contains information such as:

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbNumber": "ISBN123",
  "publishedDate": "2026-06-07",
  "price": 200.00,
  "bookType": "HARDCOVER"
}
```

---

# 📁 Project Structure

```text
catalogue-management/
│
├── src/
│   │
│   ├── main/
│   │   │
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── anele/
│   │   │           └── catalogue_management/
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── BookController.java
│   │   │               │
│   │   │               ├── entity/
│   │   │               │   ├── Book.java
│   │   │               │   └── BookType.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── BookRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── BookService.java
│   │   │               │
│   │   │               └── CatalogueManagementApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.yml
│   │
│   └── test/
│       │
│       └── java/
│           └── com/
│               └── anele/
│                   └── catalogue_management/
│                       │
│                       ├── controller/
│                       │   └── BookControllerTest.java
│                       │
│                       ├── service/
│                       │   └── BookServiceTest.java
│                       │
│                       └── integration/
│                           └── BookIntegrationTest.java
│
├── .github/
│   └── workflows/
│       └── ...
│
├── .dockerignore
├── .env.example
├── .gitignore
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

# 🧪 Testing Strategy

Testing is an important part of the project.

The application uses a layered testing strategy to verify individual components as well as integration with a real PostgreSQL database.

```text
                    Testing Strategy
                           │
             ┌─────────────┼─────────────┐
             ↓             ↓             ↓
        Unit Tests    Controller Tests  Integration
             │             │             │
             ↓             ↓             ↓
          Mockito        MockMvc      Testcontainers
             │             │             │
             ↓             ↓             ↓
       Mock Repository Mock Service   PostgreSQL
```

---

## 1. Unit Testing

The service layer is tested independently using **JUnit 5 and Mockito**.

### `BookServiceTest`

The service tests cover:

- Retrieving all books
- Retrieving a book by ID
- Handling a book that does not exist
- Saving a book
- Updating a book
- Deleting a book

The repository is mocked so that the tests do not require a real database.

Example:

```java
@Mock
private BookRepository bookRepository;

@InjectMocks
private BookService bookService;
```

This keeps service tests fast and isolated.

---

# 2. Controller Testing

The REST controller is tested using:

- `@WebMvcTest`
- `MockMvc`
- Mockito

### `BookControllerTest`

Controller tests verify:

- HTTP endpoints
- HTTP status codes
- JSON responses
- Request bodies
- Service interactions

The service layer is mocked so the controller can be tested independently.

Example:

```java
@WebMvcTest(BookController.class)
class BookControllerTest {
```

This allows the web layer to be tested without connecting to PostgreSQL.

---

# 3. Integration Testing

The application also includes integration testing using:

- Spring Boot Test
- Testcontainers
- PostgreSQL
- JPA

### `BookIntegrationTest`

The integration test starts a temporary PostgreSQL database using Docker.

```text
BookIntegrationTest
        ↓
Spring Boot
        ↓
BookRepository
        ↓
Hibernate / JPA
        ↓
Testcontainers
        ↓
PostgreSQL Container
```

This verifies that the application can:

1. Start the Spring application context.
2. Connect to PostgreSQL.
3. Persist a Book.
4. Retrieve the Book from the database.
5. Verify the persisted data.

The test does not depend on the developer's local PostgreSQL password or database.

---

# 🐳 Testcontainers

Testcontainers provides a temporary PostgreSQL database for integration tests.

Example:

```java
@Container
@ServiceConnection
static PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16");
```

This makes integration tests more reliable and reproducible.

The developer does not need to manually create a PostgreSQL test database.

Docker must be running when executing integration tests locally.

---

# ▶️ Running Tests

Run the complete test suite using Maven.

### Windows

```powershell
.\mvnw clean test
```

### Linux / macOS

```bash
./mvnw clean test
```

The Maven build should finish with:

```text
BUILD SUCCESS
```

### Run a specific test

Run the service tests:

```powershell
.\mvnw -Dtest=BookServiceTest test
```

Run the controller tests:

```powershell
.\mvnw -Dtest=BookControllerTest test
```

Run the integration test:

```powershell
.\mvnw -Dtest=BookIntegrationTest test
```

---

# 🔄 Testing Pipeline

The intended development workflow is:

```text
Developer writes code
        │
        ▼
Run unit tests
        │
        ▼
Run controller tests
        │
        ▼
Run integration tests
        │
        ▼
Maven build
        │
        ▼
Git commit
        │
        ▼
Git push
        │
        ▼
GitHub Actions
        │
        ▼
Automated tests
        │
        ▼
Build passes ✅
```

---

# ⚙️ Getting Started

## Prerequisites

### Option 1 — Docker

For the easiest application setup, install:

- Docker Desktop

Docker Desktop includes Docker Compose.

### Option 2 — Local Development

For running the application directly on your machine, install:

- Java 17
- Maven
- PostgreSQL

### For Integration Tests

Docker Desktop is required because Testcontainers starts a PostgreSQL container.

---

# 🐳 Running with Docker Compose

Docker Compose is recommended when running the complete application stack.

## 1. Clone the Repository

```bash
git clone https://github.com/kaahoza/Catalogue-Management.git
cd Catalogue-Management
```

## 2. Configure Environment Variables

Create a `.env` file in the project root.

Example:

```env
POSTGRES_DB=catalogue_db
POSTGRES_USER=catalogue_user
POSTGRES_PASSWORD=your_password
```

> Never commit your real `.env` file to GitHub.

A `.env.example` file should be included in the repository to document the required variables.

## 3. Build and Start the Application

```bash
docker compose up --build
```

Docker Compose will:

1. Build the Spring Boot application.
2. Start PostgreSQL.
3. Wait for PostgreSQL to become healthy.
4. Start the Spring Boot application.
5. Connect Spring Boot to PostgreSQL.

The application will be available at:

```text
http://localhost:8080
```

## 4. Run in the Background

```bash
docker compose up -d
```

## 5. Check Running Containers

```bash
docker compose ps
```

You should see services similar to:

```text
catalogue-management
catalogue-postgres
```

## 6. View Application Logs

```bash
docker compose logs -f app
```

To view all logs:

```bash
docker compose logs -f
```

## 7. Stop the Application

```bash
docker compose down
```

The PostgreSQL data is persisted using a Docker named volume.

## 8. Remove the Database Volume

```bash
docker compose down -v
```

> ⚠️ This removes the PostgreSQL data stored in the Docker volume.

---

# 💻 Running Locally Without Docker

Docker Compose is recommended, but the application can also be run directly using Java and PostgreSQL.

## 1. Create the Database

Create a PostgreSQL database:

```sql
CREATE DATABASE catalogue_db;
```

Configure the database connection using environment variables.

Example:

```yaml
spring:
  datasource:
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/catalogue_db}
    username: ${SPRING_DATASOURCE_USERNAME:postgres}
    password: ${SPRING_DATASOURCE_PASSWORD}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
```

Do not place your real database password in `application.yml`.

## 2. Set Environment Variables

### Windows PowerShell

```powershell
$env:SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/catalogue_db"
$env:SPRING_DATASOURCE_USERNAME="postgres"
$env:SPRING_DATASOURCE_PASSWORD="your_password"
```

### Linux / macOS

```bash
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/catalogue_db
export SPRING_DATASOURCE_USERNAME=postgres
export SPRING_DATASOURCE_PASSWORD=your_password
```

## 3. Build the Application

Using the Maven wrapper:

### Windows

```powershell
.\mvnw clean package
```

### Linux / macOS

```bash
./mvnw clean package
```

## 4. Run the Application

```bash
.\mvnw spring-boot:run
```

Or run the generated JAR:

```bash
java -jar target/catalogue-management-0.0.1-SNAPSHOT.jar
```

The API will be available at:

```text
http://localhost:8080
```

---

# 📖 Swagger / OpenAPI

Once the application is running, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger provides an interactive interface for:

- Viewing available endpoints
- Inspecting request models
- Inspecting response models
- Sending API requests
- Testing CRUD operations

### Swagger UI

![Swagger UI](./img.png)

---

# 🔐 Configuration & Security

Database credentials should never be committed directly to the repository.

The application uses environment variables for sensitive configuration.

Example:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/catalogue_db
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=your_password
```

For Docker Compose:

```env
POSTGRES_DB=catalogue_db
POSTGRES_USER=catalogue_user
POSTGRES_PASSWORD=your_password
```

The `.env` file should be included in `.gitignore`.

A `.env.example` file can be committed to document the required configuration:

```env
POSTGRES_DB=catalogue_db
POSTGRES_USER=catalogue_user
POSTGRES_PASSWORD=your_password
```

For production applications, secrets should be managed using a dedicated secrets-management solution.

---

# 🐳 Docker Architecture

The Docker Compose environment consists of two primary services.

## Spring Boot Application

```text
Service: app
Port: 8080
```

## PostgreSQL

```text
Service: postgres
Port: 5432
```

The services communicate through the Docker Compose network.

Inside Docker, the Spring Boot application connects to PostgreSQL using:

```text
postgres:5432
```

rather than:

```text
localhost:5432
```

This allows the application container to communicate with the PostgreSQL container through the Docker network.

---

# 🔄 Continuous Integration

GitHub Actions is used to automatically build and test the project.

The CI workflow is designed to run when changes are pushed or pull requests are opened.

```text
                 Git Push / Pull Request
                           │
                           ▼
                   GitHub Actions
                           │
                           ▼
                    Checkout Code
                           │
                           ▼
                    Setup Java 17
                           │
                           ▼
                    Maven Build
                           │
                           ▼
                     Run Tests
                           │
             ┌─────────────┴─────────────┐
             ↓                           ↓
       Unit Tests                  Integration Tests
             │                           │
             │                     Testcontainers
             │                           │
             │                       PostgreSQL
             └─────────────┬─────────────┘
                           ▼
                     Build Success
```

This provides an automated quality check for changes made to the repository.

---

# 🎯 Project Goals

This project demonstrates practical experience with:

- ☕ Java 17
- 🌱 Spring Boot
- 🌐 REST API development
- 🏗️ Layered architecture
- 🗄️ Spring Data JPA
- 🐘 PostgreSQL
- 📦 Maven
- 🧪 JUnit 5
- 🎭 Mockito
- 🌐 MockMvc
- 🐳 Testcontainers
- 📖 Swagger/OpenAPI
- 🐳 Docker
- 🐙 Docker Compose
- 🔐 Environment-based configuration
- ⚙️ GitHub Actions
- 🔀 Git and GitHub workflows

---

# 📈 Development Practices

The project focuses on several practices commonly used in professional backend development.

### Separation of Concerns

Controllers, services, and repositories have separate responsibilities.

### Automated Testing

Different testing levels are used to verify application behaviour.

### Dependency Isolation

Mockito is used to isolate unit tests from external dependencies.

### Integration Testing

Testcontainers provides a real PostgreSQL environment for integration tests.

### Containerisation

Docker provides a consistent application runtime environment.

### Environment-Based Configuration

Sensitive database configuration is provided through environment variables.

### Continuous Integration

GitHub Actions automatically validates code changes.

---

# 🔮 Future Improvements

Potential improvements include:

- 🔐 Authentication and authorisation using Spring Security
- 👤 User accounts and personal catalogues
- 🔎 Book search and filtering
- 📄 Pagination and sorting
- ✅ Request validation
- ❗ Global exception handling
- 📝 Standardised API error responses
- 🚀 Cloud deployment
- 📊 Application monitoring and observability
- 🗄️ Database migrations using Flyway or Liquibase
- 📈 Code coverage reporting
- 🧪 Additional integration and end-to-end tests

---

# 👨‍💻 Author

## Kanyisa Anele Hoza

**Junior Software Developer**

Java | Spring Boot | REST APIs | PostgreSQL | React

Cape Town, South Africa

### Links

- GitHub: https://github.com/kaahoza
- Portfolio: https://portfolio-anele-s-projects.vercel.app/
- LinkedIn: https://www.linkedin.com/in/anele-kanyisa-hoza/

---

# 📄 License

This project is available for educational and portfolio purposes.