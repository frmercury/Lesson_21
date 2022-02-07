package com.ex.ui;

import com.ex.ui.TestRailQA.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver webDriver;

    @BeforeTest
    public void setUp(){
        webDriver = WebDriverManagerClass.getWebDriver();
    }

    @BeforeClass
    public void doLogin() {
    new LoginPage(webDriver, "https://testrail1235.testrail.io/index.php?/auth/login")
            .inputEmail("testrail1235@mailforspam.com")
            .inputPassword("zxasqw4567")
            .clickOnLoginButton();
    }

    @AfterClass
    public void shutDown() {
        webDriver.quit();
    }
}
