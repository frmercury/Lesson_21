package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    private By testCaseButton = By.xpath("//a[contains(@href, 'suites')]");

    public MainPage clickOnTestCasesButton (){
        findElement(webDriver, testCaseButton).click();
        return this;
    }
}
