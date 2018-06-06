package com.n11.challenge.tests;

import com.n11.challenge.config.ConfigReader;
import com.n11.challenge.pageobjects.HomePage;
import com.n11.challenge.pageobjects.LoginPage;
import com.n11.challenge.tests.common.BaseTest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void successfullyLoginTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getLoginLink().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getEmailInput().sendKeys(ConfigReader.getInstance().getUserName());
        loginPage.getPasswordInput().sendKeys(ConfigReader.getInstance().getPassword());
        loginPage.getLoginButton().click();

        assertThat(homePage.getMyAccountMenuUserFullNameLink().getText(), equalTo("Ahmet Babacan"));
    }

}
