package com.alfabank.AutomationLoginPage.pages.alfa;

import com.alfabank.AutomationLoginPage.pages.alfa.page.Page;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LogInPage extends Page {


    @Step
    public void logInAs(String userName, String password) {
        $("#login").shouldBe(visible).setValue(userName);
        $("#password").shouldBe(visible).setValue(password);
    }

    @Step
    public static void submit() {
        $(".submit.btn.btn_red").click();
    }

    @Step
    public ForgotPasswordPage goToForgotPasswordPage() {
        $(".forgot_password").click();
        return page(ForgotPasswordPage.class);
    }

    @Step
    public UserProfilePage goToUserProfilePage() {
        $(".forgot_password").click();
        return page(UserProfilePage.class);
    }

}
