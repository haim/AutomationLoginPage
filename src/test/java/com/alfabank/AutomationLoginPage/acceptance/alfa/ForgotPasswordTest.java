package com.alfabank.AutomationLoginPage.acceptance.alfa;

import com.alfabank.AutomationLoginPage.core.ChromeConfigurationTest;
import com.alfabank.AutomationLoginPage.pages.alfa.ForgotPasswordPage;
import com.alfabank.AutomationLoginPage.pages.alfa.LogInPage;
import com.codeborne.selenide.CollectionCondition;
import com.opencsv.CSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import static com.codeborne.selenide.Selenide.open;

@RunWith(value = Parameterized.class)
public class ForgotPasswordTest extends ChromeConfigurationTest {
  LogInPage logInPage;

  private String contractNumber;

  @Parameterized.Parameters
  public static List<String[]> testData() throws IOException {
    return getTestData("helperfiles/contractNumber.csv");
  }

  public ForgotPasswordTest(String contractNumber) {
    this.contractNumber = contractNumber;
  }

  public static List<String[]> getTestData(String fileName) throws IOException {
    CSVReader reader = new CSVReader(new FileReader(fileName));
    List<String[]> myEntries = reader.readAll();
    reader.close();
    return myEntries;

  }

  @Test
  public void forgotPassword() {
    LogInPage logInPage = open("https://my.alfabank.com.ua/login", LogInPage.class);
    ForgotPasswordPage forgotPasswordPage = logInPage.goToForgotPasswordPage();
    forgotPasswordPage.results().shouldHave(CollectionCondition.
            texts("января февраля марта апреля мая июня июля августа сентября октября ноября декабря"));
    forgotPasswordPage.enterContractNumber(contractNumber);
    forgotPasswordPage.submit();


  }

}
