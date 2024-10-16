package com.ecommerce.frontend.pages;

import com.ecommerce.frontend.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

/**
 * FooterSection class for interacting with the footer section of the web application.
 */
public class FooterSection extends BasePage {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    /**
     * Constructor for the FooterSection class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */
    public FooterSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // Initialize the Web Elements declared with @FindBy annotations
        PageFactory.initElements(driver, this);
    }

    // Footer message element
    @FindBy(xpath = "//div[@class='footer_copy'][contains(.,'© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy')]")
    private WebElement footerMesssage;

    // Social icons element
    @FindBy(xpath = "//ul[@class='social']")
    private WebElement socialIcon;

    /**
     * Checks if the footer message is correct.
     *
     * @return true if the footer message is displayed, false otherwise.
     */
    public boolean isFooterMessageCorrect() {
        waitForElementToBeVisible(driver, footerMesssage, Constants.WAIT_TIME_TWO_SECONDS);
        return footerMesssage.isDisplayed();
    }

    /**
     * Gets the footer message text.
     *
     * @return The text of the footer message.
     */
    public String getFooterMessage() {
        return footerMesssage.getText();
    }

    /**
     * Checks if the specified number of social icons are present.
     *
     * @param numberOfSocialIcons The expected number of social icons.
     * @return true if the number of social icons matches, false otherwise.
     */
    public boolean isSocialIconsPresent(int numberOfSocialIcons) {
        List<WebElement> socialIcons = socialIcon.findElements(By.tagName("li"));
        return socialIcons.size() == numberOfSocialIcons;
    }
}
