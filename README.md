# Selenium Automation Framework

This is a Selenium-based automation framework for testing an e-commerce application. It supports cross-browser testing, data-driven testing, and includes reusable components for managing common actions and utilities.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Framework Structure](#framework-structure)
- [Test Data](#test-data)
- [Listeners](#listeners)
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
   git clone https://github.com/deepikaL1313/saucedemo2024.git
   
2. Navigate to the project directory:
   cd saucedemo2024

3. Install the project dependencies:
   mvn clean install
   
## Running Tests
mvn test -DsuiteXmlFile=testng.xml

Alternatively, you can run the tests directly through your IDE (such as IntelliJ IDEA or Eclipse) by right-clicking the testng.xml file and selecting "Run".

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



   
