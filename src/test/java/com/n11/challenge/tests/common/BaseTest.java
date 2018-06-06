package com.n11.challenge.tests.common;

import com.n11.challenge.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public abstract class BaseTest {

    private WebDriver driver;

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable t, Description description) {
            try {
                String imageFileName = description.getTestClass().getSimpleName() + "_" + description.getMethodName() + ".png";
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(ConfigReader.getInstance().getScreenshotsFolder() + imageFileName));
            } catch (Exception e) {
                System.out.println("Couldn't take screenshot for failed test: ");
                e.printStackTrace();
            }
            driver.quit();
        }

        @Override
        protected void succeeded(Description description) {
            driver.quit();
        }
    };

    @Before
    public void setUp() {
        if ("firefox".equalsIgnoreCase(ConfigReader.getInstance().getPlatform())) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        // no-op
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
