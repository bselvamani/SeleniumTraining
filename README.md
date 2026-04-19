# SeleniumTraining

A Selenium WebDriver training project built with Java, TestNG, and Cucumber BDD. The project automates UI tests against [https://automationexercise.com](https://automationexercise.com) using the Page Object Model (POM) pattern.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
  - [Run TestNG Tests](#run-testng-tests)
  - [Run Cucumber Tests](#run-cucumber-tests)
  - [Run with Browser Options](#run-with-browser-options)
- [Test Reports](#test-reports)

---

## Tech Stack

| Tool/Library            | Version  |
|-------------------------|----------|
| Java                    | 11+      |
| Gradle                  | 9.x      |
| Selenium WebDriver      | 4.15.0   |
| WebDriverManager        | 5.6.3    |
| TestNG                  | 7.8.0    |
| Cucumber (Java/TestNG)  | 7.14.0   |
| Logback (SLF4J)         | 1.4.11   |
| Cucumber Reporting      | 5.11.0   |

---

## Project Structure

```
src/
└── test/
    ├── java/com/selenium/
    │   ├── driver/        # WebDriver setup and management
    │   ├── helper/        # Config loader and utility helpers
    │   ├── pom/           # Page Object Model classes (BasePage, HomePage, LoginPage, MyAccountPage)
    │   ├── steps/         # Cucumber step definitions and BaseTest hooks
    │   └── testcases/     # TestNG test classes and listeners (LoginPageTest, TestListener)
    └── resources/
        ├── config/
        │   └── config.properties   # URL, username, and password
        ├── features/
        │   └── LoginPage.feature   # Cucumber feature files
        ├── testng.xml              # TestNG suite configuration
        └── logback.xml             # Logging configuration
```

---

## Prerequisites

- **Java 11** or later installed and `JAVA_HOME` set
- **Google Chrome** browser installed
- No manual ChromeDriver download needed — WebDriverManager handles it automatically

---

## Configuration

Edit `src/test/resources/config/config.properties` to set the target URL and login credentials:

```properties
url=https://automationexercise.com/
user=your_email@example.com
password=your_password
```

---

## Running Tests

All commands are run from the project root. Use `./gradlew` on macOS/Linux or `gradlew.bat` on Windows.

### Run TestNG Tests

Runs the TestNG suite defined in `src/test/resources/testng.xml`:

```bash
./gradlew test
```

To force a clean re-run (skip Gradle's UP-TO-DATE check):

```bash
./gradlew cleanTest test
```

**What it runs:**
- `com.selenium.testcases.LoginPageTest` — Login and account page validation

---

### Run Cucumber Tests

Runs all Cucumber feature files under `src/test/resources/features/` (excluding scenarios tagged `@Ignore` or `@ignore`):

```bash
./gradlew cucumberTest
```

**What it runs:**
- `src/test/resources/features/LoginPage.feature`
  - `@regression` — As a user, I should validate my account page

**Cucumber reports** are generated in:
- `target/cucumber-html-report/` — HTML report
- `target/cucumber.json` — JSON report (for CI integration)

---

### Run with Browser Options

You can pass system properties to switch browser or enable headless mode:

```bash
# Run with Firefox
./gradlew test -Dbrowser=firefox

# Run Chrome in headless mode
./gradlew test -Dheadless=true

# Run Cucumber headless
./gradlew cucumberTest -Dheadless=true
```

Supported browser values: `chrome` (default), `firefox`

---

## Test Reports

| Report Type     | Location                                      |
|-----------------|-----------------------------------------------|
| TestNG HTML     | `build/reports/tests/test/index.html`         |
| TestNG XML      | `build/test-results/test/`                    |
| Cucumber HTML   | `target/cucumber-html-report/index.html`      |
| Cucumber JSON   | `target/cucumber.json`                        |

Open the HTML reports in a browser after a test run to view detailed results, step breakdowns, and failure screenshots.

