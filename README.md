
## Requisitos
- Java 17+
- Maven 3.6+

## Como ejecutar

Paso 1 - Clonar el repositorio: git clone https://github.com/RubenGarQuin/inditexTest.git
Paso 2 - Navegar al directorio ->  cd inditexTest
Paso 3 - Compilar usando el comando mvn clean compile
Paso 4 - Ejecutar la aplicación usando el comando maven mvn spring-boot:run

La aplicación estará disponible en: http://localhost:8080

## endpoints

### Consultar precio aplicable
**GET** `/api/prices?applicationDate={dateTime}&productId={id}&brandId={id}`

## Acceso a base de datos H2
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:inditex
- Usuario: admin
- Password: admin

## Documentación de API
La definición OpenAPI está disponible en src/main/resources/static/api.yaml
También disponible una vez levantado el proyecto en http://localhost:8080/swagger-ui/index.html
