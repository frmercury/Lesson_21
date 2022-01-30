package com.ex.ui.TestRailQA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebHelpers {

    long timeOut = 5L;

    WebElement findElement(WebDriver webDriver, By locator) {
        return findElement(webDriver,locator,timeOut);
    }

    WebElement findElement(WebDriver webDriver, By locator, Long timeOut) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement waitForElementIsClickable (WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    Boolean checkIsVisible (WebDriver webDriver, By locator) {
        return findElement(webDriver, locator).isDisplayed();
    }

    Boolean checkIsInvisible (WebDriver webDriver, By locator) {
        try {
            return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e){
            System.out.println("Element is visible on the page. Check window resizing.");
        }
        return null;
    }

    void scrollToElement(WebDriver webDriver, WebElement webElement) {
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true)", webElement);
    }
}
