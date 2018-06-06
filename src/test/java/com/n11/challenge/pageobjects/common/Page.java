package com.n11.challenge.pageobjects.common;

import com.n11.challenge.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    private final String url;

    private final WebDriver driver;

    public Page(String url, WebDriver driver) {
        this.url = url;
        this.driver = driver;
    }

    public void browse() {
        driver.get(ConfigReader.getInstance().getHost() + url);
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
