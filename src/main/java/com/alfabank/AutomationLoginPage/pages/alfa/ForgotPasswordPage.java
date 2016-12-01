package com.alfabank.AutomationLoginPage.pages.alfa;

import com.alfabank.AutomationLoginPage.pages.alfa.page.Page;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForgotPasswordPage extends Page {

    @Step
    public ElementsCollection results(){
        return $$(By.cssSelector("#birthdayChooserMonth"));
    }

    @Step
    public static void submit(){
        $(".//*[@id='ForgotPasswordForm']/div[3]/i[1]").click();
    }
}
