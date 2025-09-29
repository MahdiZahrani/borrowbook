# BorrowBook (Phase 1)

This project is the initial setup for a **Borrow Book Management System** built with **Spring Boot** and **MySQL** (production) / **H2** (test environment).  
The system is intended to manage book borrowing operations with a clean and extendable backend structure.

---

## ✅ Phase 1 - Completed
- **Spring Boot project setup**
- **REST API skeleton** (basic controllers & structure)
- **H2 database integration** for test execution
- **GlobalExceptionHandler** for consistent error handling
- **Environment separation**:
    - `application-dev.yml` → for local development (MySQL)
    - `application-test.yml` → for testing (H2 in-memory)

---

## 🛠 Tech Stack
- **Java 23+**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL (production)**
- **H2 (testing)**
- **Lombok**

---

## 🚀 How to Run

### Development
Make sure you have a running MySQL instance and update credentials in  
`src/main/resources/application-dev.yml`

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
