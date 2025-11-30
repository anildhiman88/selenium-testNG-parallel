# selenium-testNG-parallel

This project demonstrates a Selenium-based UI automation framework using TestNG for parallel test execution. It provides a basic structure for testing web applications, incorporating page object models, configuration management, and reporting.

## Features and Functionality

*   **UI Automation:**  Automated testing of web applications using Selenium WebDriver.
*   **TestNG Framework:** Utilizes TestNG for test management, parallel execution, and reporting.
*   **Page Object Model (POM):** Implements POM for better code organization and maintainability.  Key page classes include `LoginPage`, `ProductsPage`, and `CartPage`.
*   **Configuration Management:** Reads configuration parameters (e.g., browser, URL) from a `config.properties` file.  System properties can override the file.
*   **Cross-Browser Support:**  Supports Chrome and Firefox browsers.  The browser is configurable via the `browser` property in `config.properties`.
*   **Reporting:** Generates Extent Reports for detailed test execution results.  Reports are saved in the `target/extent-report.html` directory.
*   **Screenshot on Failure:** Captures screenshots when a test fails and embeds them in the Extent Report.  Screenshots are saved in the `target/screenshots` directory.
*   **ThreadLocal WebDriver:** Manages WebDriver instances using `ThreadLocal` for safe parallel test execution.

## Technology Stack

*   **Java:** Programming language.
*   **Selenium WebDriver:**  For browser automation.
*   **TestNG:**  Testing framework.
*   **WebDriverManager:**  For managing browser drivers.
*   **ExtentReports:** For generating test reports.
*   **Apache Commons IO:** For file operations (specifically, screenshot handling).

## Prerequisites

*   **Java Development Kit (JDK):**  Ensure you have JDK 8 or higher installed.
*   **Maven:**  Maven is required to build and run the project.
*   **Web Browsers:**  Install the desired web browsers (Chrome and/or Firefox).  The project will attempt to download the necessary drivers automatically via WebDriverManager.

## Installation Instructions

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/anildhiman88/selenium-testNG-parallel.git
    cd selenium-testNG-parallel
    ```

2.  **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

## Usage Guide

1.  **Configure the `config.properties` file:**

    Located at `selenium-practise/src/test/resources/config.properties`.  This file contains configuration parameters such as the base URL, browser, and implicit wait time.  Example:

    ```properties
    base.url=https://www.saucedemo.com/
    browser=chrome
    implicit.wait=10
    ```

    *   `base.url`: The base URL of the web application to be tested.
    *   `browser`: The browser to use for testing (e.g., `chrome`, `firefox`).
    *   `implicit.wait`: The implicit wait time in seconds.

2.  **Run the tests using Maven:**

    ```bash
    mvn test
    ```

    This command will execute all tests defined in the `selenium-practise/src/test/java/tests` directory. TestNG suite files are not specified explicitly, so TestNG will execute all tests found.

3.  **View the Extent Report:**

    After the tests have finished executing, the Extent Report can be found at `target/extent-report.html`.  Open this file in a web browser to view the test results.

4.  **Running tests in parallel:**

    To enable parallel test execution, configure the `testng.xml` file (if present - example configuration below):

    ```xml
    <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
    <suite name="Parallel Test Suite" parallel="methods" thread-count="2">
        <listeners>
            <listener class-name="listeners.ExtentTestListener"/>
        </listeners>
        <test name="Login Tests">
            <classes>
                <class name="tests.LoginTests"/>
            </classes>
        </test>
        <test name="Cart Tests">
            <classes>
                <class name="tests.CartTests"/>
            </classes>
        </test>
    </suite>
    ```

    Modify the `parallel` attribute of the `<suite>` tag to control the level of parallelism (e.g., `methods`, `tests`, `classes`).  Adjust the `thread-count` attribute to specify the number of threads to use. If using a testng.xml file, modify the maven command to specify the file :

    ```bash
    mvn test -Dsurefire.suiteXmlFiles=testng.xml
    ```

5. **Overriding Configuration:**

   You can override the properties defined in the `config.properties` file by setting system properties when running the Maven command. For example, to run the tests in Firefox and set the implicit wait to 5 seconds, use the following command:

    ```bash
    mvn test -Dbrowser=firefox -Dimplicit.wait=5
    ```

## API Documentation (Not Applicable)

This project does not expose a public API. It is a UI automation framework.

## Contributing Guidelines

Contributions are welcome!  To contribute to this project, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them with descriptive commit messages.
4.  Submit a pull request.

## License Information

No license has been specified for this project. All rights are reserved by the owner.

## Contact/Support Information

For questions or support, please contact anildhiman88 through GitHub.