# REST Assured Java API Automation Framework

An enterprise-grade API automation framework built with **Java**, **REST Assured**, **TestNG**, and **Jackson**, featuring full CRUD operation test coverage, JSON schema contract validation, and an advanced CI/CD pipeline with Allure reporting, manual environment triggers, and cron scheduling.

## Tech Stack & Libraries

* **Language:** Java (JDK 21)
* **Automation Engine:** REST Assured
* **Test Framework:** TestNG
* **Data Serialization / POJO:** Jackson Databind
* **Contract Validation:** RestAssured JSON Schema Validator
* **Reporting:** Allure Report
* **Build Tool:** Maven
* **CI/CD:** GitHub Actions (with Workflow Dispatch & Cron Scheduling)

## Framework Architecture

```
api-automation-framework/
│
├── .github/
│   └── workflows/
│       └── api-tests.yml        # Advanced GitHub Actions Pipeline (Cron & Manual inputs)
│
├── src/
│   ├── main/java/com/api/
│   │   ├── models/              # POJO request/response models (User.java)
│   │   └── ...
│   │
│   └── test/
│       ├── java/com/api/
│       │   ├── base/            # Base specifications & configurations (BaseApiTest.java)
│       │   ├── services/        # Service client encapsulation (UserClient.java)
│       │   ├── tests/           # Test execution classes (UserTests.java)
│       │   └── utils/           # Utilities & Data Providers (ConfigLoader.java, TestDataProviders.java)
│       │
│       └── resources/
│           ├── schemas/         # JSON Schema contract files (user-schema.json)
│           ├── testng.xml       # TestNG Suite configuration
│           └── config.properties# Environment configurations
│
└── pom.xml                      # Maven project dependencies and plugins

```

## Key Features

* **Service Object Pattern:** Separates HTTP request execution logic from test assertions inside client classes (`UserClient`).
* **Dynamic Payloads:** Eliminates hardcoded strings by leveraging Jackson POJO serialization and TestNG `@DataProvider`.
* **Contract Testing:** Validates live API JSON responses against structural blueprint schemas.
* **Environment Management:** Centralizes configuration properties via a custom lazy-loaded `ConfigLoader` utility.
* **Advanced CI/CD Pipeline:** Configured with GitHub Actions supporting manual environment overrides (`qa`, `staging`, `production`), test suite selection, and automated nightly cron runs.

## Running Tests Locally

1. Clone the repository and open it in **IntelliJ IDEA**.
2. Run tests via Maven in your terminal:

```bash
mvn clean test

```

3. Generate and view the Allure report locally:

```bash
allure serve target/allure-results

```
