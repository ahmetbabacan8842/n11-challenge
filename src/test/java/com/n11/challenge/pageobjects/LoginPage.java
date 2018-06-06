package com.n11.challenge.pageobjects;

import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

    private final By emailInputSelector = By.id("email");

    private final By passwordInputSelector = By.id("password");

    private final By loginButtonSelector = By.id("loginButton");

    public LoginPage(WebDriver driver) {
        super("/giris-yap", driver);
    }

    public WebElement getEmailInput() {
        return getDriver().findElement(emailInputSelector);
    }

    public WebElement getPasswordInput() {
        return getDriver().findElement(passwordInputSelector);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButtonSelector);
    }

}
