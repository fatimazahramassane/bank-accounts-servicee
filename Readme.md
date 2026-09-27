<div align="center">

# Compte Bancaire Microservice

**Activité Pratique N°1 — Implémentation d'un microservice avec Spring Boot**

![Java](https://img.shields.io/badge/Java-Spring_Boot-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-6DB33F)
![GraphQL](https://img.shields.io/badge/GraphQL-API-E10098?logo=graphql&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-Database-445511)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?logo=swagger&logoColor=black)

</div>

---

##  Informations du projet

| | |
|---|---|
| **Réalisatrice** | Fatimazahra Massane |
| **Formation** | Master SDIA — Systèmes Distribués et Intelligence Artificielle |
| **Encadrant** | Prof. Mohamed Youssfi |
| **Année universitaire** | 2026/2027 |
| **Période** | Septembre 2026 |

---

##  Table des matières

1. [Description du projet](#1-description-du-projet)
2. [Technologies utilisées](#2-technologies-utilisées)
3. [Architecture et étapes de réalisation](#3-architecture-et-étapes-de-réalisation)
4. [Tests des API REST](#4-tests-des-api-rest-postman--swagger)
5. [Projections Spring Data REST](#5-projections-spring-data-rest)
6. [API GraphQL & gestion des erreurs](#6-api-graphql--gestion-des-erreurs)
7. [Installation et démarrage](#7-installation-et-démarrage)
8. [Endpoints disponibles](#8-endpoints-disponibles)

---

## 1. Description du projet

Ce projet consiste en la création d'un **microservice bancaire** complet permettant de gérer des comptes bancaires et des clients. Il met en œuvre les bonnes pratiques de développement avec **Spring Boot**, l'exposition de services **REST** et **GraphQL**, ainsi que la gestion centralisée des exceptions.

**Fonctionnalités principales :**
- ✅ CRUD complet des comptes bancaires et des clients
- ✅ API RESTful documentée avec Swagger/OpenAPI
- ✅ Projections Spring Data REST pour un contrôle fin des données
- ✅ API GraphQL avec requêtes et mutations
- ✅ Gestion personnalisée des erreurs
- ✅ Base de données H2 en mémoire

---

## 2. Technologies utilisées

| Domaine | Technologie |
|---------|-------------|
| **Langage** | Java 17+ |
| **Framework** | Spring Boot 3.x |
| **ORM** | Spring Data JPA (Hibernate) |
| **Base de données** | H2 (In-memory) |
| **Documentation** | Springdoc OpenAPI / Swagger UI |
| **API Query** | Spring GraphQL |
| **Réduction de code** | Lombok |
| **Build Tool** | Maven |

---

## 3. Architecture et étapes de réalisation

### Phase 1 : Initialisation et modélisation
1. Création du projet Spring Boot avec les dépendances Web, Spring Data JPA, H2 et Lombok
2. Création de l'entité JPA `BankAccount` et de l'entité `Customer`
3. Création des interfaces `BankAccountRepository` et `CustomerRepository`

### Phase 2 : Couche métier
4. Implémentation des DTOs (`BankAccountRequestDTO`, `BankAccountResponseDTO`)
5. Création des mappers pour la conversion Entity ↔ DTO
6. Implémentation de la couche service (métier) avec `AccountService`

### Phase 3 : Exposition des API
7. Création du contrôleur REST `AccountRestController`
8. Configuration de la documentation Swagger/OpenAPI
9. Intégration de Spring Data REST avec projections personnalisées

### Phase 4 : GraphQL et gestion des erreurs
10. Développement de l'API GraphQL (`BankAccountGraphQLController`)
11. Configuration du schéma GraphQL (`schema.graphqls`)
12. Gestion personnalisée des erreurs avec `CustomDataFetcherExceptionResolver`

---

## 4. Tests des API REST (Postman & Swagger)

### Test via Postman

#### Création d'un compte (POST)
```bash
POST http://localhost:8080/bankAccounts
Content-Type: application/json

{
  "id": "BA001",
  "balance": 5000.0,
  "currency": "MAD",
  "type": "SAVINGS_ACCOUNT",
  "customerId": "CUST001"
}
```

#### Consultation des comptes (GET)
```bash
GET http://localhost:8080/bankAccounts
```

### Documentation Swagger UI

Accès à l'interface interactive : **http://localhost:8080/swagger-ui.html**

| Fonctionnalité | Endpoint |
|----------------|----------|
| Liste des comptes | `GET /bankAccounts` |
| Compte par ID | `GET /bankAccounts/{id}` |
| Création | `POST /bankAccounts` |
| Mise à jour | `PUT /bankAccounts/{id}` |
| Suppression | `DELETE /bankAccounts/{id}` |

---

## 5. Projections Spring Data REST

Spring Data REST permet d'exposer directement les repositories tout en contrôlant les formats de sortie grâce aux **projections**.

### Projection personnalisée

```java
@Projection(name = "p1", types = BankAccount.class)
public interface AccountProjection {
    String getId();
    Double getBalance();
    String getCurrency();
}
```

### Utilisation

```bash
# Récupération avec projection
GET http://localhost:8080/bankAccounts/search/findByType?type=SAVINGS_ACCOUNT&projection=p1
```

---

## 6. API GraphQL & gestion des erreurs

### Schéma GraphQL

Le fichier `schema.graphqls` définit les types, requêtes et mutations :

```graphql
type BankAccount {
    id: ID!
    balance: Float!
    currency: String!
    type: AccountType!
    customer: Customer
}

type Query {
    bankAccounts: [BankAccount!]!
    bankAccountById(id: ID!): BankAccount
}

type Mutation {
    createBankAccount(input: BankAccountInput!): BankAccount!
    deleteBankAccount(id: ID!): Boolean!
}
```

### Requêtes GraphQL

#### Récupérer tous les comptes
```graphql
query {
    bankAccounts {
        id
        balance
        currency
        type
    }
}
```

#### Créer un compte
```graphql
mutation {
    createBankAccount(input: {
        balance: 5000.0,
        currency: "MAD",
        type: SAVINGS_ACCOUNT,
        customerId: "CUST001"
    }) {
        id
        balance
    }
}
```

### Gestion des erreurs

Les erreurs GraphQL sont gérées de manière personnalisée via `CustomDataFetcherExceptionResolver` pour retourner des messages clairs et exploitables par le client.

---

## 7. Installation et démarrage

### Prérequis
- JDK 17 ou supérieur
- Maven 3.8+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

### Démarrage

```bash
# 1. Cloner le dépôt
git clone https://github.com/fatimazahramassane/bank-accounts-servicee.git
cd bank-accounts-servicee

# 2. Compiler le projet
mvn clean install

# 3. Lancer l'application
mvn spring-boot:run
```

### Accès à l'application

- **Swagger UI** : http://localhost:8080/swagger-ui.html
- **GraphiQL (Interface GraphQL)** : http://localhost:8080/graphiql
- **H2 Console** : http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:bankdb`
  - Username: `sa`
  - Password: ``

---

## 8. Endpoints disponibles

### REST API

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/bankAccounts` | Liste tous les comptes |
| GET | `/bankAccounts/{id}` | Récupère un compte par ID |
| POST | `/bankAccounts` | Crée un nouveau compte |
| PUT | `/bankAccounts/{id}` | Met à jour un compte |
| DELETE | `/bankAccounts/{id}` | Supprime un compte |
| GET | `/bankAccounts/search/findByType` | Recherche par type |

### Spring Data REST

| Endpoint | Description |
|----------|-------------|
| `/bankAccounts` | Exposition REST complète |
| `/bankAccounts/search` | Méthodes de recherche |
| `/bankAccounts/{id}?projection=p1` | Avec projection |

### GraphQL

| Type | Nom | Description |
|------|-----|-------------|
| Query | `bankAccounts` | Liste tous les comptes |
| Query | `bankAccountById` | Récupère un compte par ID |
| Mutation | `createBankAccount` | Crée un compte |
| Mutation | `deleteBankAccount` | Supprime un compte |

---

---

<div align="center">

**Projet réalisé par Fatimazahra Massane**  
Master SDIA — ENSET Mohammedia  
Année universitaire 2026/2027

</div>