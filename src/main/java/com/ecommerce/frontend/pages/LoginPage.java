package com.ecommerce.frontend.pages;

import com.ecommerce.frontend.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private Logger log = LogManager.getLogger(this.getClass().getName());
    WebDriver driver ;
    /*
     **
     * Constructor for the LoginPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        /*  Initializes the Web Elements Declared*/
        PageFactory.initElements(driver, this);
    }

    /* Locators for Web Elements */
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

    public boolean isLoginPage() {
        waitForElementTobeVisible(driver,pageTitle, Constants.WAIT_TIME_TWO_SECONDS);
        return pageTitle.isDisplayed();
    }

    /* Operations to be performed on locators are wrapped in methods below */

    public void enterUserName(String userNameInput) {
        userName.clear();
        userName.sendKeys(userNameInput);
    }
    public void enterPassword(String passwordInput) {
        password.clear();
        password.sendKeys(passwordInput);
    }
    public void clickLoginBtn() {
        loginBtn.click();
    }

    public boolean isLockedOut() {
        return lockedOutErrorMsg.isDisplayed();
    }
}
