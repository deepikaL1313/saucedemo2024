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

public class FooterSection extends BasePage{

    private Logger log = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    /*
     **
     * Constructor for the LoginPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */

    public FooterSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        /*  Initializes the Web Elements Declared*/
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='footer_copy'][contains(.,'© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy')]")
    private WebElement footerMesssage;

    @FindBy(xpath = "//ul[@class='social']")
    private WebElement socialIcon;
    public boolean isFooterMessageCorrect() {
        waitForElementTobeVisible(driver,footerMesssage, Constants.WAIT_TIME_TWO_SECONDS);
        return footerMesssage.isDisplayed();
    }

    public String getFooterMessage() {
        return footerMesssage.getText();
    }
    public boolean isSocialIconsPresent(int numberOfSocialIcons) {
      List<WebElement> socialIcons = socialIcon.findElements(By.tagName("li"));
      return socialIcons.size() == numberOfSocialIcons;
    }

}
