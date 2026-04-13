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
```sql
CREATE DATABASE backend;
```

### 3. Set environment variables

The app reads database credentials from environment variables.  
Make sure they match your local PostgreSQL setup.

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
```
http://localhost:8080
```

## API Documentation

Swagger UI:
```
http://localhost:8080/swagger-ui/index.html#/
```

## Basic API Flow

1. Create an author  
2. Create a book (linked to author)  
3. Create a user profile  
4. Add a rating  


## Notes

- Spring Boot is handled automatically (no manual install needed)
- Database is local for now
  
