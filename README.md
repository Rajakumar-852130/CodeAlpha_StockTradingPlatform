# CodeAlpha Stock Trading Platform

A professional-grade virtual stock trading simulation built during my Java Programming Internship at **CodeAlpha**. This platform allows users to experience real-time market dynamics, manage a virtual portfolio, and execute trades in a simulated environment.

## 🚀 Features
- **Real-time Market Simulation**: Stock prices fluctuate every 5 seconds using a random-walk algorithm.
- **Dynamic Portfolio Management**: Track owned stocks, quantities, and real-time valuation.
- **Buy/Sell Operations**: Execute trades instantly with virtual currency ($10,000 starting balance).
- **Transaction History**: Audit log of all completed trades with timestamps and execution prices.
- **Persistent Storage**: Uses **MySQL Database** to save user data, portfolio, and history.
- **FinTech Dashboard**: A premium, dark-themed responsive UI with live price updates via AJAX.

## 🛠️ Technology Stack
- **Backend**: Java 17, Spring Boot 3.x, Spring Data JPA
- **Database**: MySQL 8.x
- **Frontend**: HTML5, CSS3 (Modern Glassmorphism), JavaScript (AJAX/Fetch API), Thymeleaf
- **Build Tool**: Maven

## 💻 Setup and Installation
1. **Prerequisites**:
   - Java 17 or higher.
   - MySQL Server running.
2. **Database Configuration**:
   - The application is configured to connect to `localhost:3306`.
   - It will automatically create the database `stock_trading_db` if it doesn't exist.
   - Update your credentials in `src/main/resources/application.properties`.
3. **How to Run**:
   - Double-click `run_project.bat` (Windows).
   - Or run: `./mvnw spring-boot:run`
4. **Access the App**:
   - Open: `http://localhost:8082`

## 📊 Task Requirements Covered
- [x] Simulate a basic stock trading environment.
- [x] Market data display and buy/sell operations.
- [x] Portfolio performance tracking.
- [x] Object-Oriented Programming (OOP) for models.
- [x] Persistent storage via MySQL database.

---
*Created by [Raj Kumar] as part of the CodeAlpha Internship program.*
