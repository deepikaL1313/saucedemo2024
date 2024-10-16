package com.ecommerce.tests.base;

import com.ecommerce.frontend.constants.Constants;
import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.Browser.CHROME;

/**
 * BaseTest class, serving as the base for all test classes.
 * Contains common setup and teardown methods for tests.
 */
public class BaseTest {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    /**
     * Sets up the WebDriver before each test method.
     * Configures the browser (Chrome / Firefox / Edge) for cross-browser testing.
     *
     * @param env     The test environment (DEV, STAGE, PROD).
     * @param browser The browser to be used for testing.
     */
    @BeforeMethod
    @Parameters({"test.env", "test.browser"})
    public void setup(String env, String browser) {
        log.info("Set up a WebDriver instance for [" + browser + "]");
        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                log.error("Option to launch browser : [" + browser + "] is not available in framework");
                break;
        }
        log.info("Browser Initialized to [" + browser + "]");

        driver.manage().window().maximize();
        switch (env) {
            case "DEV":
                driver.get(Constants.Application_URL_DEV);
                break;
            case "STAGE":
                driver.get(Constants.Application_URL_STAGE);
                break;
            case "PROD":
                driver.get(Constants.Application_URL_PROD);
                break;
            default:
                log.error("Environment [" + env + "] is not supported in this framework");
                break;
        }
        log.info("Environment Initialized to [" + env + "]");
    }

    /**
     * Tears down the WebDriver after each test method.
     * Adds a delay of 5 seconds before quitting.
     */
    @AfterMethod
    public void tearDown() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }

    /**
     * Returns the WebDriver instance for test classes.
     *
     * @return The WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Captures a screenshot.
     */
    public void takeScreenshot() {
        String timeStamp;
        File screenShotName;
        try {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            timeStamp = new SimpleDateFormat(Constants.DATE_FORMAT).format(Calendar.getInstance().getTime());
            screenShotName = new File(Constants.PATH_TO_SCREENSHOTS_FOLDER + timeStamp + ".png");
            FileUtils.copyFile(scrFile, screenShotName);
        } catch (Exception e) {
            log.error("Error capturing screenshot due to [" + e.getLocalizedMessage() + "]");
            throw new RuntimeException(e);
        }
        log.info("Screenshot taken at : [" + screenShotName + "]");
        Reporter.log(" <a href='" + screenShotName.getAbsolutePath() + "'> <img src=file:///'" + screenShotName.getAbsolutePath() + "' height='200' width='200'/> </a>  ");
    }
}
