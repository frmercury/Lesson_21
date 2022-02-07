package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class NewTestCaseCreationPage extends BasePage{
    NewTestCaseCreationPage(WebDriver webDriver) {
        super(webDriver);
    }

   private By newCaseTitleInput = By.xpath("//input[@id='title']");
   private By testCaseTemplate = By.xpath("//div[@id='template_id_chzn']//span");
   private By testCaseTemplateSteps = By.xpath("//li[@id='template_id_chzn_o_1']");
   private By testCaseType = By.xpath("//div[@id='type_id_chzn']//span");
   private By testCaseTypeAutomated  = By.xpath("//li[@id='type_id_chzn_o_2']");
   private By preconditionField  = By.xpath("//div[@id='custom_preconds_display']");
   private By addTestCaseButton = By.xpath("//button[@id='accept']");


    public NewTestCaseCreationPage fillCaseTitleInput() {
        Calendar calendar = new GregorianCalendar();
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        findElement(webDriver, newCaseTitleInput).sendKeys("New Automated TestCase " + date.format(calendar.getTime()));
        return this;
    }

    public NewTestCaseCreationPage chooseCaseTemplateSteps () {
        findElement(webDriver,testCaseTemplate).click();
        findElement(webDriver,testCaseTemplateSteps).click();
        waitForAjax(webDriver);
        return this;
    }

    public NewTestCaseCreationPage chooseCaseTypeAutomated () {
        findElement(webDriver,testCaseType).click();
        findElement(webDriver,testCaseTypeAutomated).click();
        return this;
    }

    public NewTestCaseCreationPage fillPreconditionField () {
        findElement(webDriver, preconditionField).sendKeys("Auth completed");
        return this;
    }

    public NewTestCaseCreationPage clickAddTestCaseButton () {
        findElement(webDriver, addTestCaseButton).click();
        return this;
    }
}