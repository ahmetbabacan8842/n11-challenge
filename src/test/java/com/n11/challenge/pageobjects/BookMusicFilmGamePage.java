package com.n11.challenge.pageobjects;

import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookMusicFilmGamePage extends Page {

    private By bookLinkSelector = By.cssSelector("#contentCategory .container .topCont .subCatMenu.l8 .mainCat");

    public BookMusicFilmGamePage(WebDriver driver) {
        super("/kitap-muzik-film-oyun", driver);
    }

    public BookMusicFilmGamePage getBookLink() throws InterruptedException {
        getDriver().findElements(bookLinkSelector).get(0).click();

        Thread.sleep(3000);
        return this;
    }
}
