package com.ex.ui.TestRailQA;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginPage clickOnTestCasesButton (){
        findElement(webDriver, testCaseButton).click();
        return this;
    }
}
