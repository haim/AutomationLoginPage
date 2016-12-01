LoginPageTests
=======


An example of Java project using UI tests to test LoginPage.

# Prompt:
* For Windows please change in POM
* `<webdriver.chrome.driver>./helperfiles/chromedriver</webdriver.chrome.driver>`
* To
* `<webdriver.chrome.driver>./helperfiles/chromedriver.exe</webdriver.chrome.driver>`

# Commands:
To run Tests (chrome):

* `mvn clean test`

To run individual test:

  
* `mvn clean -Dtest=NameOfTestClass  test`

To generate HTML report:
  
* `mvn site`

To open generate HTML report:
  
* `Open in browser "file:///Users/den/code/AutomationLoginPage/target/site/allure-maven-plugin/index.html" `



# Technology
* unit-tests - `JUnit`
* UI Tests - `Selenide`
* Report - `Allure`

# Thanks


