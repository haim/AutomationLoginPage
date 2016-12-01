package com.alfabank.AutomationLoginPage.pages.alfa;

import com.alfabank.AutomationLoginPage.pages.alfa.page.Page;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$$;

public class UserProfilePage extends Page {

    @Step
    public ElementsCollection results(){
        return $$(By.cssSelector("#UserProfilePage"));
    }
}
