# Reqres.in API Automation Testing with Java and Selenide 🚀

Welcome to the **Reqres.in API Automation Testing Project**! This repository demonstrates how to automate API testing for [Reqres.in](https://reqres.in/) using **Java** and **Selenide**. Developed as part of the QA.GURU educational platform, this project showcases best practices in API testing, including test structure, reporting, and maintainability.

---

## 📝 Introduction

This project is designed for:
- Practicing API automation testing techniques.
- Understanding how to structure and execute API tests with modern tools.
- Gaining hands-on experience with **Selenide**, **REST Assured**, and other key technologies.

The testing scope includes verifying various RESTful API endpoints provided by Reqres.in for functionalities like user management, registration, and delayed responses.

---

## 🧪 Test Cases

### Covered Scenarios:
1. **GET Endpoints**:
   - Validate user data retrieval.
   - Test single and multiple user queries.
   - Validate error scenarios for non-existing users.

2. **POST Endpoints**:
   - Validate user creation.
   - Verify response payload and status codes.
   - Test unsuccessful registration and login attempts.

3. **PUT Endpoints**:
   - Validate user updates.

4. **DELETE Endpoints**:
   - Test user deletion and confirm appropriate responses.

5. **Edge Cases**:
   - Test invalid inputs and boundary conditions.
   - Validate server handling of large payloads.

---

## 🔧 Technologies Used

### Programming Language
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

### Test Frameworks and Libraries
- ![Selenide](https://img.shields.io/badge/Selenide-43B02A?style=for-the-badge&logo=selenium&logoColor=white): Used for its concise API for handling browser and API interactions.
- ![REST Assured](https://img.shields.io/badge/REST_Assured-4caf50?style=for-the-badge&logoColor=white): Simplifies API request and response validation.
- ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white): For organizing and executing test cases.

### Build and CI Tools
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white): Dependency management.
- ![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=jenkins&logoColor=white): CI/CD pipeline integration.

### Reporting
- **Allure Reports**: Provides detailed insights into test execution and results.

---

## ✨ Features

- **Comprehensive Test Suite**: Covers all essential Reqres.in endpoints with both positive and negative test scenarios.
- **Parameterized Tests**: Supports data-driven testing for enhanced coverage.
- **Clear Reporting**: Generates interactive reports with Allure.
- **Error Handling**: Implements robust error handling for failed API responses.
- **Scalable Structure**: Follows a modular design pattern, making it easy to add new tests.

---

## 📂 Project Structure

