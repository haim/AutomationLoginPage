package com.alfabank.AutomationLoginPage.pages.alfa.page;

import static com.codeborne.selenide.Selenide.$;

public class Page {

    public static void enterContractNumber(String contractNumber){
        $("#contractNumber").setValue(contractNumber);
    }
}
