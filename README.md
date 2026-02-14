# 💳 Console-Based Digital Wallet System (Java OOP)

A simple console-based digital wallet system built using core Java and OOP principles.

This project simulates a basic PhonePe-like payment flow with support for:
- Normal Users
- VIP Users (Cashback enabled)
- Money transfer between users
- Deposit functionality
- Balance checking

---

## 🚀 Features

- Create Normal and VIP users
- Add balance to users
- Transfer money between users
- VIP users receive 10% cashback on transactions
- Basic validation (duplicate user check, insufficient balance, invalid amounts)
- Uses abstraction and polymorphism

---

## 🧠 OOP Concepts Used

- **Abstraction** → `Person` abstract class
- **Inheritance** → `User` and `VIP` extend `Person`
- **Polymorphism** → `isEligible()` and dynamic method dispatch
- **Encapsulation** → Private fields with controlled access

---

## 🏗 Project Structure

- `Person` (Abstract Base Class)
- `User` (Normal User)
- `VIP` (Cashback Enabled User)
- `Bank` (Business Logic Layer)
- `PhonePe` (Console UI / Main Class)

---

## 💡 How It Works

1. Users are created and stored in the Bank system.
2. Money can be deposited.
3. Transfers deduct full amount from sender.
4. VIP users automatically receive 10% cashback.
5. Balance can be viewed anytime.

---

## 📌 Limitations (Learning Version)

- Uses fixed-size array (max 10 users)
- Lookup uses loops (O(n²) transfer logic)
- No transaction history
- No persistent storage

Future upgrade ideas:
- Replace array with HashMap
- Add transaction history
- Improve scalability
- Add service layer separation

---

## 🛠 Tech Used

- Java
- OOP Principles
- Console-based interaction

---

## 📈 Learning Goal

Built to practice:
- Object-Oriented Design
- Runtime Polymorphism
- Basic system modeling

---

## ▶️ How to Run

Compile and run `PhonePe.java`.

