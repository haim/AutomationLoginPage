package com.alfabank.AutomationLoginPage.core;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.CHROME;


public class ChromeConfigurationTest {

    @Before
    public void startServer() throws Exception {
//        System.setProperty("webdriver.chrome.driver", "./helperfiles/chromedriver");
        Configuration.browser = CHROME;
        Configuration.baseUrl = "https://alfabank.ua/";




       /** setWebDriver(driver);
        driver = new RemoteWebDriver(new URL("http://192.168.0.94:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        **/
    }

    @Rule
    public TestRule selenideTextReport = new TextReport();
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();


    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        FileUtils.copyFile(screenshot, new File("target\\allure-results\\screenshots\\" + screenshot.getName()));
        return Files.toByteArray(screenshot);

    }
}
