# 📌 Sistema de Reservas para Coworking Space

Este proyecto es una API REST para la gestión de reservas de salas en un espacio de coworking.

## 🚀 Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3.4.2**
- **PostgreSQL**
- **Spring Security** (autenticación con tokens)
- **Spring Data JPA** (manejo de base de datos)
- **Lombok** (reducción de código repetitivo)
- **ModelMapper** (conversión de DTOs)
- **JWT** (manejo de autenticación)

## ⚙️ Configuración del entorno

### 1️⃣ **Base de datos**
Asegúrate de tener PostgreSQL instalado y ejecuta:
```sql
CREATE DATABASE coworking_space;
```

### 2️⃣ **Configuración en application.properties**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/coworking_space
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

## **3️⃣ Ejecutar el proyecto**
mvn spring-boot:run

## **📌 Colaboración**
```
git clone https://github.com/tu-usuario/coworking-space.git

git checkout -b nombre-de-la-rama

git add .
git commit -m "Descripción del cambio"
git push origin nombre-de-la-rama


```



