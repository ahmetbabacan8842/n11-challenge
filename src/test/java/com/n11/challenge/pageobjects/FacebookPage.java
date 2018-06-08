package com.n11.challenge.pageobjects;

import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookPage extends Page {

    private By facebookEmailInputSelector = By.id("email");

    private By facebookPasswordInputSelector = By.id("pass");

    private By facebookLoginButtonSelector = By.id("loginbutton");

    public FacebookPage(WebDriver driver) {
        super("/", driver);
    }

    public WebElement getFacebookEmailInput() throws InterruptedException {
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
        Thread.sleep(3000);
        return getDriver().findElement(facebookEmailInputSelector);
    }

    public WebElement getFacebookPasswordInput(){
        return getDriver().findElement(facebookPasswordInputSelector);
    }

    public FacebookPage getFacebookLoginButton() throws InterruptedException {
        getDriver().findElement(facebookLoginButtonSelector).click();
        Thread.sleep(3000);

        return this;
    }
}
