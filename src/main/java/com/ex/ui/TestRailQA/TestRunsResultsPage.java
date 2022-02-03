package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRunsResultsPage extends BasePage {
    By sideAddTestRunButton = By.id("navigation-runs-add");

    TestRunsResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public TestRunsResultsPage addNewTestRun () {
        findElement(webDriver, sideAddTestRunButton).click();
        return this;
    }

}
