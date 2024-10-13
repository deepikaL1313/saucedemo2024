package com.ecommerce.frontend.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    private Logger log = LogManager.getLogger(this.getClass().getName());

    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(WebDriver driver , int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public void explicitWait(WebDriver driver, WebElement element ,int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(d -> element.isDisplayed());
    }

    public void waitForElementTobeVisible(WebDriver driver, WebElement element ,int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementTobeInVisible(WebDriver driver, WebElement element ,int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebDriver driver, WebElement element ,int timeInSeconds) {
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
