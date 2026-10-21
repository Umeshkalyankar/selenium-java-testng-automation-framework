# Selenium Java TestNG Automation Framework

A UI test automation framework built using **Selenium WebDriver, Java, TestNG, Maven, and Page Object Model (POM)** to automate key banking application workflows.

This project demonstrates practical experience in designing reusable automation components, organizing test suites, managing test execution, capturing failure screenshots, and generating execution reports.

## 🚀 Project Overview

The framework automates key workflows of a banking application, including:

* User login and authentication validation
* User registration
* Dashboard verification and navigation
* Sending money
* Receiving money
* Payments using QR codes
* Transaction history verification
* Logout functionality

## 🛠️ Tech Stack

| Technology              | Purpose                                    |
| ----------------------- | ------------------------------------------ |
| Java                    | Programming language                       |
| Selenium WebDriver      | Browser automation                         |
| TestNG                  | Test execution and assertions              |
| Maven                   | Dependency management and build automation |
| Page Object Model (POM) | Maintainable and reusable page classes     |
| Extent Reports          | HTML test execution reports                |
| Git & GitHub            | Version control and source code management |
| Eclipse IDE             | Development environment                    |

## ✨ Key Framework Features

### 1. Page Object Model (POM)

* Separates page locators and application interactions from test logic.
* Improves code reusability and maintainability.
* Keeps test classes organized and readable.

### 2. Reusable Base Class

* Centralizes WebDriver setup and teardown.
* Supports Chrome, Firefox, and Edge browser configuration.
* Provides reusable application login functionality.

### 3. TestNG Integration

* Organizes test cases using TestNG annotations.
* Uses assertions to validate expected application behavior.
* Groups tests into Smoke and Regression suites.
* Supports independent test execution.

### 4. Retry Analyzer

* Implements a custom TestNG `IRetryAnalyzer`.
* Configures failed tests for up to two retry attempts.
* Helps investigate intermittent test failures.

**Note:** Retrying a test does not automatically mean the underlying issue is resolved.

### 5. Automatic Failure Screenshots

* Captures screenshots when tests fail.
* Uses a reusable screenshot utility.
* Saves screenshots for failure investigation.

### 6. Extent Reports

* Generates an HTML execution report.
* Records passed, failed, and skipped test results.
* Attaches failure screenshots to the report when available.

### 7. Configuration Management

* Uses a configuration properties file for environment settings and credentials.
* Keeps configuration separate from test implementation.
* Excludes the credentials file from version control.

## 📂 Project Structure

```text
ttabank/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── baselayer/
│   │       │   └── BaseClass.java
│   │       │
│   │       ├── pagelayer/
│   │       │   ├── SignInPageClass.java
│   │       │   ├── SignUpPageClass.java
│   │       │   ├── DashboardPageClass.java
│   │       │   ├── SendMoneyPageClass.java
│   │       │   ├── ReceiveMoneyPageClass.java
│   │       │   ├── PayWithQRPageClass.java
│   │       │   └── TransactionsPageClass.java
│   │       │
│   │       └── utilitieslayer/
│   │           ├── ConfigReader.java
│   │           ├── ScreenshotUtility.java
│   │           ├── ListenerSetup.java
│   │           ├── ExtentReportManager.java
│   │           └── RetryAnalyzer.java
│   │
│   └── test/
│       ├── java/
│       │   └── testlayer/
│       │       ├── SignInTestClass.java
│       │       ├── SignUpTestClass.java
│       │       ├── DashboardTestClass.java
│       │       ├── SendMoneyTestClass.java
│       │       ├── ReceiveMoneyTestClass.java
│       │       ├── PayWithQRTestClass.java
│       │       └── TransactionsTestClass.java
│       │
│       └── resources/
│           └── config.properties
│
├── testng.xml
├── testng-smoke.xml
├── testng-regression.xml
├── pom.xml
├── .gitignore
└── README.md
```

## ⚙️ Prerequisites

Install the following before running the project:

* Java JDK 21
* Apache Maven 3.9.16 or compatible version
* Eclipse IDE or another Java IDE
* Google Chrome, Mozilla Firefox, or Microsoft Edge
* Git

Verify Java and Maven installations:

```bash
java -version
mvn -version
```

## 🔧 Setup and Installation

### Step 1: Clone the repository

```bash
git clone https://github.com/Umeshkalyankar/selenium-java-testng-automation-framework.git
```

### Step 2: Navigate to the project

```bash
cd selenium-java-testng-automation-framework
```

### Step 3: Configure the application

Update `src/test/resources/config.properties` with the appropriate application URL, browser configuration, and test credentials expected by `ConfigReader.java`.

Use valid credentials for your test environment. Do not commit passwords, tokens, or other secrets to GitHub.

### Step 4: Build the project

```bash
mvn clean compile
```

## ▶️ Running the Tests

### Run the complete test suite

```bash
mvn clean test
```

### Run the Smoke suite

```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

### Run the Regression suite

```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng-regression.xml
```

The test suites are configured through their respective TestNG XML files.

## 📊 Test Reports

After test execution, the Extent Reports HTML file is generated at:

```text
test-output/ExtentReport.html
```

Open the report in a web browser to review test results.

The report includes execution status and failure details, with screenshots attached to failed tests when available.

The `test-output/` directory is generated during execution and excluded from version control.

## 📸 Failure Screenshot Handling

The framework uses a reusable `ScreenshotUtility` and a custom TestNG listener.

When a test fails:

1. TestNG reports the failure to the listener.
2. The listener requests a screenshot.
3. The screenshot utility captures the browser screen.
4. The listener records the failure in Extent Reports and attaches the screenshot when available.
5. The browser is closed during teardown.

## 🧪 Test Execution Strategy

The framework separates test execution into two suites:

| Suite      | Purpose                                            |
| ---------- | -------------------------------------------------- |
| Smoke      | Validates essential application functionality      |
| Regression | Covers additional workflows and negative scenarios |

TestNG groups and XML suite files allow the relevant tests to be executed independently.

## 🔄 Future Enhancements

* Integrate test execution with a CI/CD pipeline.
* Expand data-driven testing using TestNG `DataProvider`.
* Improve cross-browser execution coverage.
* Enhance test logging and execution diagnostics.
* Add API testing and database validation where appropriate.

## 👨‍💻 Author

**Umesh Kalyankar**

GitHub: [Umeshkalyankar](https://github.com/Umeshkalyankar)

---

*This project demonstrates a structured approach to Selenium automation using reusable page objects, TestNG execution management, automated failure screenshots, and HTML reporting.*
