# Chain of Responsibility

A **Spring Boot** application demonstrating flexible and configurable **chain of responsibility** design pattern in spring boot application with escalation matrix example.

---

## 🧩 Features

- Built with **Java** and **Spring Boot**
- Uses **Chain of Responsibility** for handling tickets
- Chain of responsibility support handlers are configured based on priorities.
- Supports **extensibility** to add more logic without changing existing handler.

---

### Chained Responsibility
- Query Support: Handles basic queries.
- Operations Support: Tackles operational issues.
- Finance Support: Deals with finance-related problems.
- Admin Support: Handles administrative and high-level critical issues.

---

## Prerequisites

- Java 17+
- Maven 3.6+
- IntelliJ IDEA or any Java IDE with Maven support

---

## Running the Example

### 1. Clone the repository and build it

```bash
git clone https://github.com/rahulk270486/chain-of-responsibility.git
cd chain-of-responsibility
mvn clean install
```

### 1. Start the application
```bash
mvn spring-boot:run
```
---

## Testing It Out
### call ticket API and check the console for support handlers executions.
```bash
curl -X POST http://localhost:8080/api/ticket \
  -H "Content-Type: application/json" \
  -d '{
    "type": "QUERY",
    "description": "When will the refund for my order id - AB123 will be processed"
  }'

```

---

👤 Author

Rahul K

Senior Technical Architect | Java • Spring Boot • Kafka • Cloud

🔗 [LinkedIn](https://www.linkedin.com/in/rahul-kumar-9754b919/)






