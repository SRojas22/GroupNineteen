# Group Nineteen – Backend

Backend starter for our **Bookstore API** using Java, Spring Boot, and PostgreSQL.

## Requirements
- Java 17+
- PostgreSQL
- Git
- IntelliJ IDEA (recommended)

## Setup for everyone

### 1. Clone the repo
```bash
git clone https://github.com/SRojas22/GroupNineteen.git
cd GroupNineteen/backend
```
### 2. Create the database (local)

Each person must create this on their own machine:
```bash
CREATE DATABASE backend;
```
### 3. Set environment variables

Use your own Postgres username/password.

macOS / Linux
```bash
export DB_USERNAME=your_username
export DB_PASSWORD=your_password
```
Windows 
```bash
setx DB_USERNAME "your_username"
setx DB_PASSWORD "your_password"
```

### 4. Run the app
```bash
./mvnw spring-boot:run
```
App runs at:

http://localhost:8080

### Notes

- Spring Boot is handled automatically (no manual install needed)

- This is just initial setup, no features yet

- Database is local for now
