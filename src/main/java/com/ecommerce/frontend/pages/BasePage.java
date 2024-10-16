package com.ecommerce.frontend.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * BasePage class providing common WebDriver utilities.
 */
public class BasePage {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    // Constructor to initialize WebDriver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets an implicit wait.
     *
     * @param driver WebDriver instance
     * @param timeInSeconds Time in seconds for implicit wait
     */
    public void implicitWait(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    /**
     * Sets an explicit wait until an element is displayed.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for
     * @param timeInSeconds Time in seconds for explicit wait
     */
    public void explicitWait(WebDriver driver, WebElement element, int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(d -> element.isDisplayed());
    }

    /**
     * Waits for an element to be visible.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for visibility
     * @param timeInSeconds Time in seconds for wait
     */
    public void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be invisible.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for invisibility
     * @param timeInSeconds Time in seconds for wait
     */
    public void waitForElementToBeInvisible(WebDriver driver, WebElement element, int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for clickability
     * @param timeInSeconds Time in seconds for wait
     */
    public void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitToLoad(int timeInSeconds) {
        try {
            wait(timeInSeconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
