package com.ex.ui.AccountLogin;

import com.ex.ui.AccountLogin.MainPage;
import com.ex.ui.BaseTest;
import org.testng.annotations.Test;

public class AccountLoginSuite extends BaseTest {
    @Test
    public void testLoginForm() {
        new MainPage(webDriver, "https://testrail1235.testrail.io/index.php?/auth/login")
            .clickOnMyAccountLink()
            .inputEmail("123@dsas.com")
            .inputPassword("password")
            .clickOnLoginButton()
            .verifyPasswordFieldIsdEmpty();
    }
}
