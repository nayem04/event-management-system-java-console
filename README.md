# Event Management System

## Project Description
The Event Management System is a console-based application that allows users to create, manage, and track events. It integrates user management, event scheduling, ticket booking, and real-time analytics. The project demonstrates the usage of advanced Java 21 features, Object-Oriented Programming (OOP) principles, Collections, Streams, Multithreading, Java I/O, and Functional Programming.

---

## Project Features and Requirements

### 1. User Requirements

#### Event Creation & Management:
- Create events with attributes: name, type, date, venue, and capacity.
- Update or delete existing events.

#### User Registration:
- Users can register for events.
- Ensure no duplicate registrations.

#### Analytics:
- Display real-time analytics, including:
    - Total registrations.
    - Event occupancy percentage.

#### Export Data:
- Export event and registration details to CSV or JSON formats.

---

### 2. Functional Requirements

#### Java 21 Features
- **Virtual Threads:** Handle concurrent user operations like registration and analytics efficiently.
- **Pattern Matching:** Validate user inputs such as email, phone number, and event types.

#### OOP Principles and Design Patterns
- **OOP Principles:**
    - Encapsulation for event and user data.
    - Modular design using inheritance and polymorphism.
- **Design Patterns:**
    - **Singleton:** Central configuration manager for managing database/file paths.
    - **Factory:** Event factory to create events of various types (e.g., seminar, concert).
    - **Builder:** Event builder to handle optional properties like speaker details or VIP access.

#### Collections Framework, Streams, and Multithreading
- **Collections:** Manage event and user data using collections (e.g., `Map` for event lookups, `List` for registrations).
- **Streams:** Filter and aggregate data (e.g., finding fully booked events).
- **Multithreading:** Handle operations like analytics and ticket updates in parallel.

#### Java I/O and Functional Programming
- **Java I/O:**
    - Read/write event and user data to/from files.
    - Support importing/exporting data in CSV/JSON formats.
- **Functional Programming:**
    - Use lambdas and functional interfaces for processing user inputs and managing event filters.

---

## System Design

### Core Classes

#### Event
- **Attributes:** `id`, `name`, `type`, `date`, `venue`, `capacity`, `registrations`.
- **Methods:** `addRegistration()`, `isFullyBooked()`.

#### User
- **Attributes:** `id`, `name`, `email`, `phone`.
- **Methods:** `validate()`.

#### EventFactory
- Creates events of different types using the Factory pattern.

#### Analytics
- Real-time calculation of registration statistics using streams and multithreading.

### Utility Classes

#### FileManager
- Handles reading/writing data to/from CSV/JSON using Java I/O.

#### ThreadManager
- Manages operations using virtual threads and multithreading.

#### Validator
- Validates inputs using pattern matching.

---

## Features Mapped to Topics
| **Feature**             | **Topic Coverage**                                      |
|-------------------------|-------------------------------------------------------|
| Event creation          | OOP principles (encapsulation, inheritance), Factory pattern |
| Registration management | Collections Framework, Streams, Functional Interfaces |
| Real-time analytics     | Streams API, Multithreading, Virtual Threads          |
| Data validation         | Pattern Matching (Switch), Functional Interfaces      |
| Export to CSV/JSON      | Java I/O, Functional Programming                      |
| Concurrency handling    | Multithreading, Virtual Threads                       |

---

## Example Workflow

### Start Console Application:
1. Display menu options:
    - Create Event
    - Register User
    - View Analytics
    - Export Data

### Event Creation:
1. User inputs event details (validated using pattern matching).
2. Event object is created using the Factory and Builder patterns.

### Registration:
1. User selects an event and provides details (validated using pattern matching).
2. Registration is handled using virtual threads to avoid blocking.

### View Analytics:
1. Generate analytics using streams and display them in real-time.

### Export Data:
1. Write event and registration data to CSV/JSON files using Java I/O.

---

## Technology Stack
- **Java Version:** Java 21
- **Key Concepts:**
    - Virtual Threads
    - Pattern Matching
    - OOP Principles and Design Patterns
    - Collections Framework
    - Streams API
    - Multithreading
    - Java I/O
    - Functional Programming

---

## How to Run
1. Clone the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Compile and run the `Main` class.
4. Follow the prompts in the console to interact with the system.

---

## Author
Developed as a demonstration project for integrating Java 21 features with modern programming paradigms.

