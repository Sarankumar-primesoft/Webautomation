
# WebAutomation

**OTT Web Automation Project with Extent Reports and Log4j**

This project automates the testing of an OTT (Over-The-Top) web application using Selenium WebDriver. It includes integration with Extent Reports for comprehensive reporting and Log4j for detailed logging.

---

## 🚀 Features

- Automated end-to-end testing of OTT web application features.
- Integration with **Extent Reports** for beautiful and detailed HTML test reports.
- Logging via **Log4j** for easy debugging and traceability.
- Structured framework using Page Object Model for scalability and maintainability.
- Supports cross-browser testing (based on configuration).

---

## 🛠️ Technologies Used

- **Java**
- **Selenium WebDriver**
- **Extent Reports**
- **Log4j**
- **TestNG** (assumed for test execution)
- **Maven** (for dependency management and build)

---

## 📂 Project Structure

```
Webautomation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── [Page Objects and Utility Classes]
│   └── test/
│       └── java/
│           └── [Test Cases]
├── testng.xml
├── pom.xml
└── README.md
```

---

## ⚙️ Installation & Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/Sarankumar-primesoft/Webautomation.git
   ```

2. **Navigate to the project directory**

   ```bash
   cd Webautomation
   ```

3. **Open in IDE**

   Import the project into your favorite Java IDE like IntelliJ IDEA or Eclipse.

4. **Build the project**

   If using Maven:

   ```bash
   mvn clean install
   ```

5. **Configure as needed**

   Update configurations in `config.properties` or `testng.xml` as needed.

---

## ▶️ Running the Tests

You can run the test suite using TestNG via command line or IDE.

**From Command Line:**

```bash
mvn test
```

**From IDE:**

Right-click on `testng.xml` and select **Run**.

---

## 📊 Test Reports

After test execution, HTML test reports are generated using Extent Reports.

**Report location:**

```
/test-output/ExtentReports/
```

Open the HTML file in a browser to view results.

---

## 📝 Logging

Log4j is used for logging runtime information and errors.

**Logs location:**

```
/logs/
```

Check `log4j.properties` for custom log level configuration.

---

## 🤝 Contributing

Contributions are welcome! Feel free to fork this repo and submit pull requests for improvements or fixes.

For major changes, please open an issue first to discuss what you'd like to change.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
