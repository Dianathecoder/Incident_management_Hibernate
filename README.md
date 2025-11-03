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

## 🌐 Servicios

| Servicio        | Dirección en navegador                         | Comentario                                     |
| --------------- | ---------------------------------------------- | ---------------------------------------------- |
| Adminer         | [http://localhost:8000](http://localhost:8000) | Acceso a PostgreSQL vía web                    |
| Spring Boot App | [http://localhost:8081](http://localhost:8081/swagger-ui/index.html#/) | Si habilitas el servicio `app`                 |
| PostgreSQL      | N/A desde host local, salvo que abras `5432`   | Internamente accesible como `db-postgres:5432` |

