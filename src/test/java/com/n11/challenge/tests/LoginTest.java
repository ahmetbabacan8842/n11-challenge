package com.n11.challenge.tests;

import com.n11.challenge.config.ConfigReader;
import com.n11.challenge.pageobjects.FacebookPage;
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

    @Test
    public void successfullyFacebookLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getLoginLink().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getFacebookLoginLink().click();

        FacebookPage facebookPage = new FacebookPage(getDriver());
        facebookPage.getFacebookEmailInput().sendKeys(ConfigReader.getInstance().getFacebookUser());
        facebookPage.getFacebookPasswordInput().sendKeys(ConfigReader.getInstance().getFacebookPassword());
        facebookPage.getFacebookLoginButton();

    }

    @Test
    public void unSuccessfullyFacebookLoginTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getLoginLink().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getFacebookLoginLink().click();

        FacebookPage facebookPage = new FacebookPage(getDriver());
        facebookPage.getFacebookEmailInput().sendKeys(ConfigReader.getInstance().getFacebookUser());
        facebookPage.getFacebookPasswordInput().sendKeys(ConfigReader.getInstance().getFacebookPassword());
        facebookPage.getFacebookLoginButton();

        assertThat(homePage.getMyAccountMenuUserFullNameLink().getText(), equalTo("Consciously becomes a perpetrator.!!!"));
    }
}
