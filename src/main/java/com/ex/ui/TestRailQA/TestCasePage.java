package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class TestCasePage extends BasePage{
    public TestCasePage(WebDriver webDriver) {
        super(webDriver);
    }
    private By addResultButton = By.xpath("//a[@id='sidebar-tests-addresult']");
    private By addResultButtonPopUp = By.xpath("//button[@id='addResultSubmit']");
    private By addResultField = By.xpath("//div[@id='addResultStatus_chzn']/a");
    private By testCaseStatuses = By.xpath("//div[@id='addResultStatus_chzn']//li");
    private By statusMark = By.xpath("//div[@class='change-meta']/span");

    public TestCasePage clickAddTestCaseButton () {
        findElement(webDriver, addResultButton).click();
        return this;
    }

    public TestCasePage addRandomResultStatus() {
        findElement(webDriver, addResultField).click();
        chooseRandomCaseStatus();
        clickAddResultButtonPopUp();
        return this;
    }

    public void chooseRandomCaseStatus () {
        List<WebElement> randomCaseStatusList = webDriver.findElements(testCaseStatuses);
        Random random = new Random();
        WebElement randomStatus = randomCaseStatusList.get(random.nextInt(randomCaseStatusList.size()));
        randomStatus.click();
    }
    public void clickAddResultButtonPopUp () {
        findElement(webDriver, addResultButtonPopUp).click();
    }

    public void checkStatusModification () {
        waitForAjax(webDriver);
        Assert.assertNotEquals(findElement(webDriver, statusMark).getText(), "Untested");
    }
}
