package com.ex.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverManagerClass {
    private  static WebDriver webDriver;

    private WebDriverManagerClass(String browser) {
        setWebDriver(browser);
    }

    private void setWebDriver(String browser) {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        switch (browser) {
            case "chrome":
                webDriver = WebDriverManager.chromedriver().create();
//                webDriver = new ChromeDriver();
                break;
            case "ff":
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException(browser + " browser does not exists. Set a correct one");
        }
    }

    public static WebDriver getWebDriver() {

        String browser = "chrome";
        if (webDriver == null) {
            new WebDriverManagerClass(browser);
        }
        return webDriver;
    }
}