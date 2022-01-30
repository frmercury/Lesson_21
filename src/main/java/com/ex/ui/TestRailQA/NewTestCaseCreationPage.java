package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTestCaseCreationPage extends BasePage{
    NewTestCaseCreationPage(WebDriver webDriver) {
        super(webDriver);
    }

    By addTestCaseButton = By.id("accept");

    public NewTestCaseCreationPage fillTitleInput () {
        return this;

    }

    public NewTestCaseCreationPage chooseCaseTemplate () {
        return this;

    }

    public NewTestCaseCreationPage chooseCaseType () {
        return this;

    }

    public NewTestCaseCreationPage chooseCasePriority () {
        return this;

    }

    public NewTestCaseCreationPage setTestEstimation () {
        return this;

    }

    public NewTestCaseCreationPage setTestReferences () {
        return this;

    }

    public NewTestCaseCreationPage setPreconditions () {

        return this;
    }

    public NewTestCaseCreationPage clickAddTestCaseButton () {
        findElement(webDriver, addTestCaseButton);
        return this;
    }
}
