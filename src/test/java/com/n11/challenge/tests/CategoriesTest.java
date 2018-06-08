package com.n11.challenge.tests;

import com.n11.challenge.config.ConfigReader;
import com.n11.challenge.pageobjects.BookMusicFilmGamePage;
import com.n11.challenge.pageobjects.BookPage;
import com.n11.challenge.pageobjects.HomePage;
import com.n11.challenge.tests.common.BaseTest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CategoriesTest extends BaseTest {

    @Test
    public void successfullyGoToBookPageTest() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getGoToBookMusicFilmGameLink().click();

        BookMusicFilmGamePage bookMusicFilmGame = new BookMusicFilmGamePage(getDriver());
        bookMusicFilmGame.getBookLink();

        assertThat(getDriver().getCurrentUrl(), equalTo(ConfigReader.getInstance().getHost() + "/kitap"));
    }

    @Test
    public void bookAuthorTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getGoToBookMusicFilmGameLink().click();

        BookMusicFilmGamePage bookMusicFilmGame = new BookMusicFilmGamePage(getDriver());
        bookMusicFilmGame.getBookLink();

        BookPage bookPage = new BookPage(getDriver());
        bookPage.getAuthorLink();

        assertThat(getDriver().getCurrentUrl(), equalTo(ConfigReader.getInstance().getHost() + "/yazarlar"));
    }
}
