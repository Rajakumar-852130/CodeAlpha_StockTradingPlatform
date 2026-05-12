# PROJECT REPORT: Stock Trading Platform
**Organization:** CodeAlpha Internship  
**Project Number:** Task 2  
**Developer:** [Raj Kumar]

---

## 1. Project Overview
The Alpha Trading Platform is a sophisticated Java-based web application that simulates a real-world stock trading environment. It provides users with virtual capital to trade various stocks, track their portfolio's performance, and observe market trends through a dynamic dashboard.

## 2. Objectives
- To simulate live stock market price fluctuations.
- To provide secure and efficient buy/sell transaction logic.
- To maintain a persistent record of user balances and portfolios.
- To demonstrate advanced OOP principles and Spring Boot integration with relational databases.

## 3. System Architecture & Tech Stack
The project utilizes a robust N-Tier architecture:
- **Programming Language:** Java 17
- **Backend Framework:** Spring Boot 3.x
- **ORM:** Spring Data JPA (Hibernate)
- **Database:** MySQL 8.x
- **Frontend:** HTML5, CSS3, JavaScript (ES6+), Thymeleaf
- **Styling:** Custom CSS with Glassmorphism and Responsive Grid system.

## 4. Key Features Implemented
- **Automated Price Engine:** A background service that updates stock prices every 5 seconds to simulate a live market.
- **Financial Transaction Engine:** Handles complex logic for deducting balances, calculating trade costs, and updating inventory quantities.
- **Portfolio Tracking:** Real-time view of owned assets and their current market value.
- **AJAX Live Polling:** The frontend fetches updated price data without requiring a full page refresh, ensuring a smooth user experience.
- **Audit Logging:** Every trade is recorded in a transaction history table with precise timestamps.

## 5. Technical Implementation (OOP)
- **Entities:** Decoupled models for `Stock`, `Trader`, `PortfolioItem`, and `Transaction`.
- **Relationship Mapping:** Used `@OneToMany` and `@ManyToOne` to link traders with their assets and history.
- **Service Layer:** Transactional methods ensure data integrity during financial operations (Buy/Sell).

## 6. Conclusion
Task 2 has been successfully completed, delivering a production-grade simulation platform. The integration of a persistent MySQL database and real-time frontend updates makes this a robust solution for understanding the fundamentals of FinTech application development.

---
*Date: May 2026*  
*Submitted to: CodeAlpha Technical Team*
