# Domino's Microservices Project 🍕🚀

## Project Overview
This project simulates Domino's Pizza ordering system using **Microservices Architecture**.  
Each service handles a specific part of the application. This architecture helps in **scalability**, **maintainability**, and **independent deployment**.

---

## Services Included

| Service Name | Description |
|--------------|-------------|
| **API Gateway** | Entry point for all client requests, routes to the right microservice |
| **Service Registry (Eureka)** | Keeps track of all microservices running in the system |
| **User Service** | Handles user registration, login, and profile management |
| **Order Service** | Handles placing, updating, and tracking pizza orders |
| **Menu Service** | Manages pizza menu items and details |
| **Payment Service** | Handles payment processing for orders |
| **Delivery Service** | Manages order delivery status and tracking |
| **Notification Service** | Sends email notifications for order confirmations |

---

## Features
- Place **single** or **bulk orders**  
- Upload required **documents** for orders  
- Update **order status** and **order details**  
- **User authentication** and role management  
- **Email notifications** for successful orders  
- **Eureka service registry** for dynamic discovery  
- **API Gateway** for routing requests  

---

## Technology Stack
- **Backend:** Spring Boot (Java 17)  
- **Microservices:** Spring Cloud, Eureka, Spring Gateway  
- **Database:** PostgreSQL / H2  
- **Communication:** REST APIs  
- **Email Service:** JavaMailSender  
- **Build Tool:** Maven  
- **Testing:** JUnit  

---

## Folder Structure

dominos-microservices/
│
├─ dominos-api-gateway/ # Gateway Service
├─ dominos-service-registry/ # Eureka Service
├─ dominos-user-service/ # User Management
├─ dominos-order-service/ # Orders Management
├─ dominos-menu-service/ # Menu Management
├─ dominos-payment-service/ # Payment Handling
├─ dominos-delivery-service/ # Delivery Tracking
└─ dominos-notification-service/ # Email Notifications


---

## How to Run
1. Start **Eureka Service** first (`dominos-service-registry`)  
2. Start **API Gateway** (`dominos-api-gateway`)  
3. Start other microservices in any order:  
   - User Service  
   - Order Service  
   - Menu Service  
   - Payment Service  
   - Delivery Service  
   - Notification Service  
4. Access the system via API Gateway on `http://localhost:8080`  

---

## Sample API Endpoints

| Service | Endpoint | Method | Description |
|---------|----------|--------|-------------|
| API Gateway | /users/** | GET/POST/PUT | Access User Service |
| API Gateway | /orders/** | GET/POST/PUT | Access Order Service |
| API Gateway | /menu/** | GET | Access Menu Service |
| API Gateway | /payments/** | POST | Process Payment |
| API Gateway | /delivery/** | GET | Track Delivery |
| API Gateway | /notifications/** | POST | Send Email Notifications |

---

## Author
**Rajesh Patil**  
- GitHub: [RajeshPatil2](https://github.com/RajeshPatil2)
