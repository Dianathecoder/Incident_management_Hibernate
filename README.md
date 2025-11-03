# Incident Management Hibernate

##  Project Description

**Incident Management Hibernate** is a Java desktop/CLI application designed to manage incidents within an organization.  
The project uses:

- **Java 17** and **Hibernate** for data persistence.
- **MySQL** as the database.
- **Adminer** for web-based MySQL administration.
- **Docker and Docker Compose** for easy deployment of the full environment.

Key features:

- Employee management (create, update, delete, change password).
- Recording and querying incidents between employees.
- User validation and session management through Hibernate.

---

##  Technologies Used

| Technology       | Purpose                                         |
|-----------------|------------------------------------------------|
| Java 17          | Main application language                     |
| Hibernate        | ORM for database persistence                   |
| MySQL 8          | Database                                      |
| Adminer          | Web interface for database management         |
| Docker / Compose | Container orchestration and service deployment |

---

##  How to Run the Environment

1. Make sure **Docker** and **Docker Compose** are installed on your machine.
2. From the project root, run:

```bash
docker compose up -d --build
