# Projeto Hexagonal - Spring Boot

![Java](https://img.shields.io/badge/Java-21-007396?)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.1-6DB33F?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apachemaven)
![MapStruct](https://img.shields.io/badge/MapStruct-1.5.5.Final-blue)
![Lombok](https://img.shields.io/badge/Lombok-1.18.30-orange)
![MongoDB](https://img.shields.io/badge/MongoDB-6.0.7-47A248?logo=mongodb)
![Kafka](https://img.shields.io/badge/Kafka-3.6.1-231F20?logo=apachekafka)
![Wiremock](https://img.shields.io/badge/Wiremock-3.13.1-yellow)

## 📌 Visão Geral
Este projeto é uma aplicação Java baseada em **Spring Boot** implementando **Arquitetura Hexagonal** (Ports and Adapters).  
O objetivo é organizar o código de forma desacoplada, facilitando manutenção, testes e troca de tecnologias.

A aplicação expõe uma API REST para gerenciamento de clientes, integra com serviços externos, envia e consome mensagens, e persiste dados em banco relacional.


## 🏗 Arquitetura
A **Arquitetura Hexagonal** divide a aplicação em três camadas principais:

- **Domain**: Regras de negócio puras, sem dependências externas.
- **Application**: Casos de uso que orquestram a execução das regras de negócio.
- **Adapters**: Implementações concretas das portas (ports) para integração com o mundo externo, como banco de dados, APIs externas, mensageria, etc.

### Estrutura de diretórios
```
src/
 ├── main/
 │   ├── java/com/pivetta/projetohexagonal/
 │   │    ├── domain/                # Entidades e portas (interfaces)
 │   │    ├── application/           # Casos de uso
 │   │    ├── adapters/
 │   │    │     ├── in/              # Controllers REST, Listeners
 │   │    │     └── out/             # Repositórios, Clients externos
 │   │    └── config/                 # Beans e configurações
 │   └── resources/
 │         ├── application.properties # Configurações da aplicação
 │         └── ...                    
 └── test/                            # Testes unitários e de integração
```

---

## 📋 Pré-requisitos
Certifique-se de ter instalado:

- **Java 17** ou superior  
- **Maven 3.8+**  
- **Docker**  
- **Git**

---

## 🐳 Para rodar a aplicação é necessário rodar o Docker Compose
Suba com:
```bash
  docker compose up -d
```


## 🧩 Wiremock
O projeto inclui o **Wiremock** (`wiremock-standalone-3.13.1.jar`) para simular APIs externas.

Para rodar:
```bash
  java -jar wiremock-standalone-3.13.1.jar --port 8089 --verbose
```

## 🚀 Rodar a aplicação
Usando Maven:
```bash
  mvn spring-boot:run
```

## 🧪 Rodar testes
```bash
  mvn test
```

## 📚 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Kafka**
- **MapStruct**
- **Lombok**
- **PostgreSQL**
- **Kafka**
- **Wiremock**


## 👨‍💻 Autor
Pivetta - Engenheiro de Software  
