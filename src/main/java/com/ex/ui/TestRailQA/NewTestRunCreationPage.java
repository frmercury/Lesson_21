package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class NewTestRunCreationPage extends BasePage{
    NewTestRunCreationPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By newCaseTitleInput = By.xpath("//input[@id='name']");
    private By descriptionField  = By.xpath("//div[@id='description_display']");
    private By addTestRunButton = By.xpath("//button[@id='accept']");


    public NewTestRunCreationPage fillRunTitleInput() {
        Calendar calendar = new GregorianCalendar();
        DateFormat date = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        findElement(webDriver, newCaseTitleInput).sendKeys("New Automated TestRun " + date.format(calendar.getTime()));
        return this;
    }

    public NewTestRunCreationPage fillDescriptionField () {
        findElement(webDriver, descriptionField).sendKeys("Randomly generated TestRun");
        return this;
    }

    public NewTestRunCreationPage clickAddTestCaseButton () {
        findElement(webDriver, addTestRunButton ).click();
        waitForAjax(webDriver);
        return this;
    }
}