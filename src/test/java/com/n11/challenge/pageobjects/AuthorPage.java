package com.n11.challenge.pageobjects;

import com.n11.challenge.pageobjects.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AuthorPage extends Page {

    private By listElementSelector = By.cssSelector("#authorsList ul li a");

    public AuthorPage(WebDriver driver) {
        super("/yazarlar", driver);
    }

    public List<WebElement> getListElement() {
        return getDriver().findElements(listElementSelector);
    }

    public void authorListControl2Page() {
        List<WebElement> authorsBlock = getDriver().findElements(By.xpath("//div[@id='authorsList']/div"));
        int lastIndexOfAuthorBlocks = authorsBlock.size();

        List<WebElement> eachAuthor = getDriver().findElements(By.xpath("//div[@id='authorsList']/div[" + lastIndexOfAuthorBlocks + "]/ul/li"));
        int lastIndexOfEachAuthor = eachAuthor.size();

        WebElement lastAuthorOnPage = getDriver().findElement(By.xpath("//div[@id='authorsList']/div[" + lastIndexOfAuthorBlocks + "]/ul/li[" + lastIndexOfEachAuthor + "]/a"));
        String nameOfLastAuthorOnFirstPage = lastAuthorOnPage.getAttribute("innerHTML");

        System.out.println(nameOfLastAuthorOnFirstPage);

        getDriver().findElement(By.xpath("//a[@class='pageLink'][text()='2']")).click();

        ArrayList<String> namesOnSecondPage = new ArrayList<String>();

        for (int i = 1; i <= authorsBlock.size(); i++) {

            List<WebElement> eachBlock = getDriver().findElements(By.xpath("//div[@id='authorsList']/div[" + i + "]/ul/li"));
            for (int j = 1; j <= eachBlock.size(); j++) {
                WebElement EachAuthor = getDriver().findElement(By.xpath("//div[@id='authorsList']/div[" + i + "]/ul/li[" + j + "]/a"));
                String authorName = EachAuthor.getAttribute("innerHTML");
                namesOnSecondPage.add(authorName);
            }
        }

        assertThat(namesOnSecondPage, not(hasItem(nameOfLastAuthorOnFirstPage)));

    }
}
