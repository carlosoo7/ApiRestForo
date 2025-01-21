
# API Rest Foro

## Autor/Creador
#### Carlos Fernando Calderon Mora
###### https://github.com/carlosoo7
###### https://www.linkedin.com/in/carlosoo7/

## Descripción

Esta es una **API Restful** desarrollada con **Spring Boot** para gestionar un foro de discusión. Permite a los usuarios autenticarse, crear, modificar, eliminar y consultar tópicos dentro del foro, garantizando la integridad de los datos mediante validaciones y seguridad con JWT. La API también soporta paginación para la consulta de tópicos.

## Características

- **Autenticación de Usuario**: Los usuarios pueden autenticarse utilizando **JWT** (JSON Web Token).
- **Gestión de Tópicos**: Los usuarios pueden crear, modificar, eliminar y obtener información de los tópicos del foro.
- **Validación de Datos**: Se realizan validaciones para evitar la creación de tópicos con títulos o mensajes duplicados.
- **Paginación**: Los resultados de la consulta de tópicos están paginados, facilitando la navegación de grandes volúmenes de datos.
- **Manejo de Errores**: La API maneja errores y excepciones, devolviendo códigos de estado HTTP adecuados y mensajes de error informativos.
- **Arquitectura Segura**: La autenticación y autorización de usuarios se manejan de forma segura con **Spring Security** y **JWT**.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security**: Para la gestión de seguridad y autenticación de usuarios.
- **JPA (Java Persistence API)**: Para la interacción con la base de datos.
- **JWT (JSON Web Tokens)**: Para la autenticación basada en tokens.
- **BCrypt**: Para la codificación de contraseñas.

## Swagger

### URL de Documentación

La documentación interactiva de la API generada por Swagger se encuentra disponible en:

## **Importante** Para que estos links funcionene debe estar ejecutandose la app en tu ide y/o localhost
- [Swagger UI](http://localhost:8080/swagger-ui/index.html)
- [Especificación OpenAPI](http://localhost:8080/v3/api-docs)

Estas herramientas permiten probar los endpoints de la API directamente desde el navegador.


## Endpoints

### Autenticación

- `POST /login`: Permite a los usuarios autenticarse utilizando su nombre de usuario y contraseña. Responde con un token JWT.

  **Request body**:
  ```json
  {
    "user": "nombre_usuario",
    "pass": "contraseña"
  }
  ```

  **Response**:
  ```json
  {
    "jwTtoken": "jwt_token_generado"
  }
  ```

### Gestión de Tópicos

- `POST /topicos`: Crea un nuevo tópico en el foro.

  **Request body**:
  ```json
  {
    "titulo": "Título del tópico",
    "mensaje": "Mensaje del tópico",
    "autor": "Nombre del autor",
    "curso": "Nombre del curso"
  }
  ```

  **Response**:
  ```json
  {
    "titulo": "Título del tópico",
    "mensaje": "Mensaje del tópico",
    "autor": "Nombre del autor",
    "curso": "Nombre del curso"
  }
  ```

- `GET /topicos/{id}`: Obtiene los detalles de un tópico por su ID.

  **Response**:
  ```json
  {
    "titulo": "Título del tópico",
    "mensaje": "Mensaje del tópico",
    "fecha": "Fecha de creación",
    "estado": true,
    "autor": "Nombre del autor",
    "curso": "Nombre del curso"
  }
  ```

- `GET /topicos`: Obtiene una lista paginada de todos los tópicos.

  **Response** (paginada):
  ```json
  {
    "content": [
      {
        "titulo": "Título del tópico",
        "mensaje": "Mensaje del tópico",
        "fecha": "Fecha de creación",
        "estado": true,
        "autor": "Nombre del autor",
        "curso": "Nombre del curso"
      }
    ],
    "totalPages": 1,
    "totalElements": 1
  }
  ```

- `PUT /topicos/{id}`: Modifica un tópico existente por su ID.

  **Request body**:
  ```json
  {
    "titulo": "Nuevo título",
    "mensaje": "Nuevo mensaje",
    "autor": "Nuevo autor",
    "curso": "Nuevo curso"
  }
  ```

  **Response**:
  ```json
  {
    "titulo": "Nuevo título",
    "mensaje": "Nuevo mensaje",
    "autor": "Nuevo autor",
    "curso": "Nuevo curso"
  }
  ```

- `DELETE /topicos/{id}`: Elimina un tópico por su ID.

  **Response**:
  ```json
  {}
  ```
## Manejo de Solicitudes

### 1. **POST /login**
  - **Código de respuesta:** `200 OK`
  - **Descripción:** El servidor devuelve un token JWT cuando la autenticación es exitosa.

### 2. **POST /topicos**
  - **Código de respuesta:** `201 Created`
  - **Descripción:** El servidor crea un nuevo tópico y devuelve una respuesta con el nuevo recurso creado.

### 3. **GET /topicos/{id}**
  - **Código de respuesta:** `200 OK`
  - **Descripción:** El servidor devuelve los detalles del tópico con el ID solicitado.

### 4. **GET /topicos**
  - **Código de respuesta:** `200 OK`
  - **Descripción:** El servidor devuelve una lista de todos los tópicos disponibles, paginados.

### 5. **PUT /topicos/{id}**
  - **Código de respuesta:** `200 OK`
  - **Descripción:** El servidor actualiza el tópico con el ID especificado y devuelve los detalles actualizados.

### 6. **DELETE /topicos/{id}**
  - **Código de respuesta:** `204 No Content`
  - **Descripción:** El servidor elimina el tópico con el ID especificado.

    
## Manejo de Errores

### 1. **POST /login** (Error)
  - **Código de respuesta:** `400 Bad Request`
  - **Descripción:** La autenticación falló debido a credenciales incorrectas.

### 2. **POST /topicos** (Error)
  - **Código de respuesta:** `400 Bad Request`
  - **Descripción:** El servidor no permite crear tópicos duplicados (título o mensaje ya existen).

### 3. **GET /topicos/{id}** (Error)
  - **Código de respuesta:** `404 Not Found`
  - **Descripción:** No se encuentra un tópico con el ID proporcionado.

### 4. **GET /topicos** (Error)
  - **Código de respuesta:** `400 Bad Request`
  - **Descripción:** La solicitud contiene parámetros inválidos o mal formateados.

### 5. **PUT /topicos/{id}** (Error)
  - **Código de respuesta:** `400 Bad Request`
  - **Descripción:** El tópico con el ID proporcionado no existe o los datos enviados son inválidos.

### 6. **DELETE /topicos/{id}** (Error)
  - **Código de respuesta:** `404 Not Found`
  - **Descripción:** No se encuentra un tópico con el ID proporcionado o ya fue eliminado.

La API maneja varios tipos de errores, incluyendo:

- **404 Not Found**: Cuando no se encuentra un recurso.
- **400 Bad Request**: Para errores de validación en los datos de entrada.
- **500 Internal Server Error**: Errores no controlados o internos del servidor.

## Instalación y Configuración

### Prerequisitos

- **Java 17** o superior
- **Maven** o **Gradle**
- **Base de Datos**: Configura una base de datos compatible con JPA (como MySQL o H2) y ajusta la configuración en el archivo `application.properties`.

### Pasos para ejecutar:

1. Clona el repositorio:
```bash
git clone https://github.com/carlosoo7/ApiRestForo.git
```

2. Navega a la carpeta del proyecto:
```bash
cd ApiRestForo
```

3. Configura la base de datos en `application.properties` o `application.yml` recuerda configurar las variables de entorno de tu computadora o reemplazar las variables marcadas con $ por datos estaticos de tu localhost. 
 ```bash
spring.application.name=ApiRestForo
spring.datasource.url=jdbc:mysql://localhost/${DB_FORO_NAME} 
spring.datasource.username=${DB_FORO_USER}
spring.datasource.password=${DB_FORO_PASS}
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
server.error.include-stacktrace=never
api.security.secret=${DB_PASS}
```

5. Compila y ejecuta la aplicación:
```bash
mvn spring-boot:run
```

5. La aplicación estará disponible en `http://localhost:8080`.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama para tu característica (`git checkout -b feature-nueva`).
3. Realiza los cambios y haz un commit (`git commit -am 'Añadir nueva característica'`).
4. Haz push a tu rama (`git push origin feature-nueva`).
5. Crea un pull request.

## Licencia

Distribuido bajo la Licencia MIT. Ver `LICENSE` para más información.
