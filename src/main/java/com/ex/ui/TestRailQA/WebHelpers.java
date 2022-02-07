package com.ex.ui.TestRailQA;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WebHelpers {

    long timeOut = 5L;

//    WebElement findElement(WebDriver webDriver, By locator) {
//        return findElement(webDriver,locator,timeOut);
//    }

    WebElement findElement(WebDriver webDriver, By locator) {
     return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut)).until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitForAjax (WebDriver webDriver) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0");
            }
        });
    }

    /**
     *
     * waitForAjax - вверху переписал в более сжатом виде. Внизу закомментированный - взято на Stackoverflow.
     * Ждет завершение выполнения JS, потом продолжает тест.
     *
     */

//public void waitForAjax(WebDriver webDriver) {
//
//    try {
//        WebDriverWait driverWait = new WebDriverWait(webDriver, Duration.ofSeconds(1));
//
//        ExpectedCondition<Boolean> expectation;
//        expectation = new ExpectedCondition<Boolean>() {
//
//            public Boolean apply (WebDriver webDriver) {
//
//                JavascriptExecutor js = (JavascriptExecutor) webDriver;
//                return js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
//            }
//        };
//        driverWait.until(expectation);
//    }
//    catch (TimeoutException exTimeout) {
//
//        // fail code
//    }
//    catch (WebDriverException exWebDriverException) {
//
//        // fail code
//    }
//}

    WebElement waitElementIsLoaded(WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement waitPageToBeLoaded(WebDriver webDriver, By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(timeOut)).until(
                ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
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