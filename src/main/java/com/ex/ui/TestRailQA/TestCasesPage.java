package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage{

    TestCasesPage(WebDriver webDriver) {
        super(webDriver);
    }

    By sideAddNewTestCaseButton = By.id("sidebar-cases-add");

    public TestCasesPage addNewTestCase() {
        findElement(webDriver, sideAddNewTestCaseButton).click();
        return this;
    }
}
