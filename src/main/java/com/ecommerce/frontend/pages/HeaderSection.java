package com.ecommerce.frontend.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderSection extends BasePage{

    private Logger log = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    /*
     **
     * Constructor for the LoginPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */

    public HeaderSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        /*  Initializes the Web Elements Declared*/
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Open Menu')]")
    private WebElement openMenu;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Close Menu')]")
    private WebElement closeMenu;

    @FindBy(xpath = "//a[contains(@data-test,'inventory-sidebar-link')]")
    private WebElement allItemsMenuOption;

    @FindBy(xpath = "//a[contains(@data-test,'logout-sidebar-link')]")
    private WebElement aboutMenuOption;

    @FindBy(xpath = "//a[contains(@data-test,'logout-sidebar-link')]")
    private WebElement logOutMenuOption;

    @FindBy(xpath = "//a[contains(@data-test,'reset-sidebar-link')]")
    private WebElement resetAppStateMenuOption;

    public void navigateToShoppingCart() {
         shoppingCart.click();
    }

    public void openMenu() {
         openMenu.click();
    }

    public void closeMenu() {
       closeMenu.click();
    }

    public void click_AllItems_MenuOption() {
      allItemsMenuOption.click();
    }

    public void click_About_MenuOption() {
        aboutMenuOption.click();
    }

    public void click_LogOut_MenuOption() {
         logOutMenuOption.click();
    }

    public void click_ResetAppState_MenuOption() {
        resetAppStateMenuOption.click();
    }
}
