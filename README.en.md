This is an example project using Spring Cloud to build a microservices architecture, featuring a simple implementation of the Eureka registration center and service providers. It is suitable for learning the foundational setup of microservices and related Spring Cloud functionalities.

### Project Structure

- **eureka-server**: The Eureka registration center service responsible for service registration and discovery.
- **service-a**: A simple service provider offering a REST endpoint that returns "Hello World".
- **service-b**: Another service provider demonstrating how to discover and communicate with other services via Eureka.

### Key Features

- Service registration and discovery (Eureka Server)
- REST API calls (Service A and Service B)

### Technology Stack

- Spring Boot
- Spring Cloud
- Eureka Server
- Maven

### System Requirements

- Java 8 or higher
- Maven 3.x
- Git

### Installation and Setup

1. Clone the project locally:

   ```bash
   git clone https://gitee.com/white_waves/spring-cloud.git
   cd spring-cloud
   ```

2. Start the Eureka Server:

   ```bash
   cd eureka-server
   ./mvnw spring-boot:run
   ```

3. Start Service A:

   ```bash
   cd ../service-a
   ./mvnw spring-boot:run
   ```

4. Start Service B:

   ```bash
   cd ../service-b
   ./mvnw spring-boot:run
   ```

### Usage Examples

- Access the Eureka dashboard to view registered services: http://localhost:8761
- Access Service A's endpoint: http://localhost:8081/helloWorld
- Access Service B's endpoint: http://localhost:8082/helloEureka

### Contribution Guidelines

Issues and pull requests are welcome. Please follow the project's code conventions and ensure all tests pass.

### License

This project is licensed under the MIT License. See the LICENSE file in the repository for details.

### Contact

For questions or suggestions, please open an issue on Gitee or contact the project maintainers.