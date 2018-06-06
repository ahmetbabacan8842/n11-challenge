package com.n11.challenge.pageobjects;

import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {

    private By myAccountMenuUserFullNameLinkSelector = By.cssSelector("#header .myAccount .menuLink.user");

    private By loginLinkSelector = By.cssSelector("#header .myAccount .btnSignIn");

    public HomePage(WebDriver driver) {
        super("/", driver);
    }

    public WebElement getLoginLink() {
        return getDriver().findElement(loginLinkSelector);
    }

    public WebElement getMyAccountMenuUserFullNameLink() {
        return getDriver().findElement(myAccountMenuUserFullNameLinkSelector);
    }

}
