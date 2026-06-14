# 📚 Catalogue Management
A multi-tier Spring Boot application for managing a book catalogue. It allows book collectors to create, update, view, and delete books in their personal library.

___

# 🚀 Project Overview
This project is split into two Spring Boot Services
**Management Service**: Expose A RESTAPI to manage Books
**Web UI Service**(optional, if you are planning): renders a web interface

This repository contains **Management Service** and Docker Support

___

# 🛠️ Tech Stack
* Java 17
* Sping Boot 3
* Maven
* H2 DataBase
* Docker
* Swagger API Documentation

# 📦 Features
* 📖 List all books
* ➕ Add new book
* 📝 update existing book
* ❌ Delete books
* Swagger UI for exploration

# ⚙️ How To Run
## 🐋 Docker (Recommended)
## 1. **Create the docker network for both services**
    docker network create catalogue-network

## 2. **Build docker image**
    docker build -t catalogue-management.

## 3. **Run docker image inside the network**
    docker run -d --name cataloguemanagement --network catalogue-network -p 8080:8080 catalogue-management

# 🧪 Run Locally(without Docker)
## 1. **Run the project to produce the jar:**
     mvn clean package
## 2. **Run the application:**
      java -jar target/catalogue-management-0.0.1-SNAPSHOT.jar

# Running with maven
## 1. **Clone Repository:**
    git clone https://github.com/kaahoza/catalogue-management.git
    cd CatalogueManagement
## **Build and run the project**
    mvn spring-boot:run

___

# Accessing the API using Swagger
Open your browser and go to http://localhost:8080/swagger-ui/index.html#/
<img src="./img.png"/>

___



