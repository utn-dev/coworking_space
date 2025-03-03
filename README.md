# Documentación del Proyecto Coworking Space

## Descripción
Este proyecto es una API REST desarrollada con Spring Boot para la gestión de espacios de coworking. Permite la administración de reservas y salas.

## Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3.4.2**
- **PostgreSQL**
- **Lombok**
- **ModelMapper**
- **JWT para autenticación**

## Configuración
### Configuración de PostgreSQL
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/coworking_space
spring.datasource.username={nombre_de_usuario}
spring.datasource.password={contraseña}
```

### Configuración de Hibernate
```properties
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Endpoints
### Gestión de Reservas (`/v1/booking`)
- **GET** `/v1/booking` - Obtiene todas las reservas.

  _Response:_
  ```json
  [
      {
          "id": 1,
          "room": {
              "id": 101,
              "name": "Sala A"
          },
          "user": "johndoe",
          "date": "2025-03-02",
          "startTime": "10:00:00",
          "endTime": "12:00:00"
      }
  ]
  ```

- **GET** `/v1/booking/{id}` - Obtiene una reserva por su ID.

  _Response:_
  ```json
  {
      "id": 1,
      "room": {
          "id": 101,
          "name": "Sala A"
      },
      "user": "johndoe",
      "date": "2025-03-02",
      "startTime": "10:00:00",
      "endTime": "12:00:00"
  }
  ```

- **POST** `/v1/booking` - Registra una nueva reserva.

  _Request:_
  ```json
  {
  "room": {
    "id": 1
  },
  "user": "John Doe",
  "date": "2024-06-15",
  "startTime": "10:00:00",
  "endTime": "12:00:00" 
  }
 
  ```
  _Response:_ `201 Created`

- **PUT** `/v1/booking/{id}` - Actualiza una reserva existente.

  _Request:_
  ```json
  {
  "room": {
    "id": 1
  },
  "user": "John Doe",
  "date": "2024-06-15",
  "startTime": "13:00:00",
  "endTime": "16:00:00" 
  }
  ```
  _Response:_ `200 OK`

- **DELETE** `/v1/booking/{id}` - Elimina una reserva.

  _Response:_ `204 No Content`

### Gestión de Salas (`/v1/rooms`)
- **GET** `/v1/rooms` - Obtiene todas las salas.

  _Response:_
  ```json
  [
      {
          "id": 101,
          "name": "Sala de Reuniones A",
          "capacity": 10,
          "status": "AVAILABLE"
      }
  ]
  ```

- **GET** `/v1/rooms/{id}` - Obtiene una sala por su ID.

  _Response:_
  ```json
  {
      "id": 101,
      "name": "Sala de Reuniones A",
      "capacity": 10,
      "status": "AVAILABLE"
  }
  ```

- **POST** `/v1/rooms` - Registra una nueva sala.

  _Request:_
  ```json
  {
      "name": "Sala de Reuniones B",
      "capacity": 20,
      "status": "AVAILABLE"
  }
  ```
  _Response:_ `201 Created`

- **PUT** `/v1/rooms/{id}` - Actualiza una sala existente.

  _Request:_
  ```json
  {
      "name": "Sala de Reuniones B",
      "capacity": 25,
      "status": "OCCUPIED"
  }
  ```
  _Response:_ `200 OK`

- **DELETE** `/v1/rooms/{id}` - Elimina una sala.

  _Response:_ `204 No Content`

## Ejecución del Proyecto
Para ejecutar el proyecto, sigue estos pasos:
1. Clona el repositorio.
2. Configura PostgreSQL con las credenciales adecuadas.
3. Ejecuta el siguiente comando:
   ```sh
   mvn spring-boot:run
   ```

## Contribuciones
Si deseas contribuir a este proyecto, sigue estos pasos:
1. **Realiza un fork del repositorio:**
   ```sh
   git clone https://github.com/tu-usuario/coworking-space.git
   ```
2. **Crea una nueva rama:**
   ```sh
   git checkout -b feature-nueva-funcionalidad
   ```
3. **Realiza tus cambios y confírmalos:**
   ```sh
   git add .
   git commit -m "Agregando nueva funcionalidad"
   ```
4. **Sube tus cambios a tu fork:**
   ```sh
   git push origin feature-nueva-funcionalidad
   ```
5. **Abre un Pull Request en GitHub y describe los cambios.**


