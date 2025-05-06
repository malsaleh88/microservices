# Microservices Project

A Java-based microservices system using Spring Boot, demonstrating service decomposition, multiple database integrations, and containerized deployment.

---

## 📦 Services Included

- `order-service`
- `inventory-service`
- `product-service`

Each is an independent Spring Boot application.

---

## 🔧 Technologies Used

### ⚙️ Backend Frameworks & Libraries
- **Java 21**
- **Spring Boot**
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-boot-starter-webflux (for reactive/webclient communication)
  - spring-boot-starter-data-mongodb
  - spring-boot-starter-test
- **Lombok** – Reduces boilerplate code
- **Testcontainers** – For integration testing with MongoDB

### 🗃️ Databases
- **MySQL** – Used in `order-service`
- **MongoDB** – Used in `inventory-service` and `product-service`

### 🔗 Inter-Service Communication
- **Spring WebClient** – Non-blocking HTTP client for calling between services (e.g., product ↔ inventory)

### 🐳 Docker
- Each service runs in a Docker container
- Configured on **separate ports** for isolation and service discovery

---

## 🧪 Testing

- Unit and integration testing enabled via `spring-boot-starter-test`
- `Testcontainers` used for MongoDB-based services

---

## 🚀 Getting Started

### Prerequisites:
- Java 21
- Maven
- Docker

---

## 📁 Project Structure

