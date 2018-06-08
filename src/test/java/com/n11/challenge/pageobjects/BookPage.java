package com.n11.challenge.pageobjects;

import com.n11.challenge.config.ConfigReader;
import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.WebDriver;

public class BookPage extends Page {

    public BookPage(WebDriver driver) {
        super("/kitap", driver);
    }

    public BookPage getAuthorLink() throws InterruptedException {
        getDriver().get(ConfigReader.getInstance().getHost() +"/yazarlar");

        Thread.sleep(5000);
        return this;
    }

}
