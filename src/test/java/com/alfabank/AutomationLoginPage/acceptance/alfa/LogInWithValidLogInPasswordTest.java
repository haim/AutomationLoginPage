package com.alfabank.AutomationLoginPage.acceptance.alfa;

import com.alfabank.AutomationLoginPage.core.ChromeConfigurationTest;
import com.alfabank.AutomationLoginPage.pages.alfa.LogInPage;
import com.alfabank.AutomationLoginPage.pages.alfa.UserProfilePage;
import com.codeborne.selenide.CollectionCondition;
import com.opencsv.CSVReader;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertEquals;

public class LogInWithValidLogInPasswordTest extends ChromeConfigurationTest {

    LogInPage logInPage;

    private String name;
    private String password;

    @Parameterized.Parameters
    public static List<String[]> testData() throws IOException {
        return getTestData("helperfiles/positive.csv");
    }


    public LogInWithValidLogInPasswordTest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static List<String[]> getTestData(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName));
        List<String[]> myEntries = reader.readAll();
        reader.close();
        return myEntries;

    }

    @Test
    public void logInWithValidLoginPassword() {
        logInPage = open("https://my.alfabank.com.ua/login", LogInPage.class);
        logInPage.logInAs(name, password);

        UserProfilePage UserProfilePage = logInPage.goToUserProfilePage();
        UserProfilePage.results().shouldHave(CollectionCondition.
                texts("User Profile page"));
        logInPage.submit();

        String errorMessage = $(By.xpath(".//*[@id='LoginForm']/div[2]/div/div[2]/div/span"))
                .shouldBe(visible).getText();
        assertEquals(errorMessage, "Не удалось войти в систему. Проверьте, пожалуйста, правильность ввода логина и пароля");
    }

}
