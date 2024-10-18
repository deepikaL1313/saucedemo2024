# Selenium Automation Framework

This is a Selenium-based automation framework for testing an e-commerce application. It supports cross-browser testing, data-driven testing, and includes reusable components for managing common actions and utilities. It predominantly leverages Page Factory which is a class provided by Selenium WebDriver to support Page Object Design pattern.

Advantages of Page Object Model are
1. Reusability
2. Reliability
3. Maintainability
4. Readability

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Framework Structure](#framework-structure)
- [Test Data](#test-data)
- [Listeners](#listeners)
- [Logging](#logging)
- [Configuration](#configuration)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven
- TestNG
- Git

## Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/deepikaL1313/saucedemo2024.git
   
2. Navigate to the project directory:
   ```bash
   cd saucedemo2024

3. Install the project dependencies:
   ```bash
   mvn clean install
   
## Running Tests
   ```bash
   mvn test -DsuiteXmlFile=testng.xml





## Framework Structure

saucedemo2024/
|-- src/
|   |-- main/
|   |   |-- java/
|   |       |-- com/
|   |           |-- ecommerce/
|   |               |-- frontend/
|   |               |   |-- constants/
|   |               |   |-- pages/
|   |               |-- core/
|   |                   |-- utils/
|   |-- test/
|       |-- java/
|           |-- com/
|               |-- ecommerce/
|                   |-- tests/
|                   |   |-- base/
|                   |   |-- data/
|                   |   |-- suite/
|-- testng.xml
|-- README.md

## Key Components
Pages: Contains page object classes for various pages of the web application.

Constants: Holds constants used throughout the framework.

Utils: Contains utility classes for common functionalities like reading from Excel, taking screenshots, etc.

Base: Contains the base test class with setup and teardown methods.

Data: Includes data providers for supplying test data to test methods.

Suite: Contains the test classes grouped into different test suites.

## Test Data
Test data is stored in Excel files located in the resources directory. The ExcelUtility class is used to read data from these files and provide it to test methods via data providers.

## Listeners
The framework includes a custom listener (FailedTestRetryListener) for retrying failed tests. This listener is configured in the testng.xml file.

## Logging
This framework uses Log4j2 for logging. Log4j2 is a powerful, flexible, and reliable logging framework that provides various features to log information at different levels such as INFO, DEBUG, WARN, ERROR, etc.

## Configuration
The Log4j2 configuration file (log4j2.xml) is located in the resources directory. This file defines the log format, log levels, and log appenders (e.g., console, file).

## Reporting
Test reports are generated by TestNG and can be found in the target/surefire-reports directory after the tests are executed. Screenshots are taken for each test step and are included in the reports.

## Contributing
Contributions are welcome! Please create a fork of the repository, make your changes, and submit a pull request.

## License
This project is licensed under the GNU GENERAL PUBLIC LICENSE. See the LICENSE file for details.

   
