package com.ex.ui.TestRailQA;

import com.ex.ui.AccountLogin.MainPage;
import com.ex.ui.BaseTest;
import org.testng.annotations.Test;

public class TestRailQASuite extends BaseTest {

        @Test
        public void testLoginForm() {
            new LoginPage(webDriver, "https://testrail1235.testrail.io/index.php?/auth/login")
                    .inputEmail("testrail1235@mailforspam.com")
                    .inputPassword("zxasqw4567")
                    .clickOnLoginButton();
    }
}
