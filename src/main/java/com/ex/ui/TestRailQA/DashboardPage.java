package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By testCaseLink = By.xpath("//a[contains(@href, 'suites')]");
    private By testRunsLink = By.xpath("//a[contains(@href, 'runs')]");

    public DashboardPage clickOnTestCasesLink(){
        findElement(webDriver, testCaseLink).click();
        return this;
    }
        public DashboardPage clickOnTestRunsLink (){
        findElement(webDriver, testRunsLink).click();
        return this;
    }

}
