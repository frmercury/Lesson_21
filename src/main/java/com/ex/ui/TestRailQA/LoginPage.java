package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    private By loginField = By.xpath("//input[@id='name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[@id='button_primary']");
    private By testCaseButton = By.xpath("//a[contains(@href, 'suites')]");

    public LoginPage inputEmail(String email){
        findElement(webDriver, loginField).sendKeys(email);
        return this;
    }
    public LoginPage inputPassword (String password){
        findElement(webDriver, passwordField).sendKeys(password);
        return this;
    }
    public LoginPage clickOnLoginButton (){
        findElement(webDriver, loginButton).click();
        return this;
    }
}