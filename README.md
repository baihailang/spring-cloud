这是一个使用 Spring Cloud 搭建的微服务架构示例项目，包含了 Eureka 注册中心和服务提供者的简单实现。适合用于学习微服务的基础搭建和 Spring Cloud 的相关功能。

### 项目结构

- **eureka-server**: Eureka 注册中心服务，负责服务的注册与发现。
- **service-a**: 一个简单的服务提供者，提供了一个返回 "Hello World" 的 REST 接口。
- **service-b**: 另一个服务提供者，演示了如何通过 Eureka 发现其他服务并进行通信。

### 主要功能

- 服务注册与发现（Eureka Server）
- REST 接口调用（Service A 和 Service B）

### 技术栈

- Spring Boot
- Spring Cloud
- Eureka Server
- Maven

### 环境要求

- Java 8 或以上版本
- Maven 3.x
- Git

### 安装与运行

1. 克隆项目到本地：

   ```bash
   git clone https://gitee.com/white_waves/spring-cloud.git
   cd spring-cloud
   ```

2. 启动 Eureka Server：

   ```bash
   cd eureka-server
   ./mvnw spring-boot:run
   ```

3. 启动 Service A：

   ```bash
   cd ../service-a
   ./mvnw spring-boot:run
   ```

4. 启动 Service B：

   ```bash
   cd ../service-b
   ./mvnw spring-boot:run
   ```

### 使用示例

- 访问 Eureka 控制台查看注册的服务：http://localhost:8761
- 访问 Service A 的接口：http://localhost:8081/helloWorld
- 访问 Service B 的接口：http://localhost:8082/helloEureka

### 贡献指南

欢迎提交 Issue 和 Pull Request。请遵循项目的代码规范并确保测试通过。

### 许可证

本项目采用 MIT 许可证。详情请查看仓库中的 LICENSE 文件。

### 联系方式

如有问题或建议，欢迎在 Gitee 上提交 Issue 或联系项目维护者。