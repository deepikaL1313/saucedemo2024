package com.ecommerce.frontend.pages;

import com.ecommerce.frontend.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginPage class for interacting with the login page of the web application.
 */
public class LoginPage extends BasePage {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    /**
     * Constructor for the LoginPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // Initialize the Web Elements declared with @FindBy annotations
        PageFactory.initElements(driver, this);
    }

    /* Locators for Web Elements in Login Page */
    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@class='login_logo'][contains(.,'Swag Labs')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//h3[@data-test='error'][contains(.,'Epic sadface: Sorry, this user has been locked out.')]")
    private WebElement lockedOutErrorMsg;

    /**
     * Checks if the login page is displayed.
     *
     * @return true if the login page is displayed, false otherwise.
     */
    public boolean isLoginPage() {
        waitForElementToBeVisible(driver, pageTitle, Constants.WAIT_TIME_TWO_SECONDS);
        return pageTitle.isDisplayed();
    }

    /**
     * Enters the username.
     *
     * @param userNameInput The username to be entered.
     */
    public void enterUserName(String userNameInput) {
        userName.clear();
        userName.sendKeys(userNameInput);
    }

    /**
     * Enters the password.
     *
     * @param passwordInput The password to be entered.
     */
    public void enterPassword(String passwordInput) {
        password.clear();
        password.sendKeys(passwordInput);
    }

    /**
     * Clicks the login button.
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }

    /**
     * Checks if the locked out error message is displayed.
     *
     * @return true if the locked out error message is displayed, false otherwise.
     */
    public boolean isLockedOut() {
        return lockedOutErrorMsg.isDisplayed();
    }
}