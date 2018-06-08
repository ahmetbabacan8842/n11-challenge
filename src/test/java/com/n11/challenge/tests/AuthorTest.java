package com.n11.challenge.tests;

import com.n11.challenge.pageobjects.AuthorPage;
import com.n11.challenge.pageobjects.BookMusicFilmGamePage;
import com.n11.challenge.pageobjects.BookPage;
import com.n11.challenge.pageobjects.HomePage;
import com.n11.challenge.tests.common.BaseTest;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class AuthorTest extends BaseTest {

    @Test
    public void listAuthorTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getGoToBookMusicFilmGameLink().click();

        BookMusicFilmGamePage bookMusicFilmGame = new BookMusicFilmGamePage(getDriver());
        bookMusicFilmGame.getBookLink();

        BookPage bookPage = new BookPage(getDriver());
        bookPage.getAuthorLink();

        AuthorPage authorPage = new AuthorPage(getDriver());

        assertThat(authorPage.getListElement().size(), equalTo(80));
    }

    @Test
    public void list2PageAuthorTest() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.browse();
        homePage.getGoToBookMusicFilmGameLink().click();

        BookMusicFilmGamePage bookMusicFilmGame = new BookMusicFilmGamePage(getDriver());
        bookMusicFilmGame.getBookLink();

        BookPage bookPage = new BookPage(getDriver());
        bookPage.getAuthorLink();

        AuthorPage authorPage = new AuthorPage(getDriver());
        authorPage.authorListControl2Page();
    }
}
