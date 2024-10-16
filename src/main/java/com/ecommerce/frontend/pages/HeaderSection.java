package com.ecommerce.frontend.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HeaderSection class for interacting with the header section of the web application.
 */
public class HeaderSection extends BasePage {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    /**
     * Constructor for the HeaderSection class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */
    public HeaderSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // Initialize the Web Elements declared with @FindBy annotations
        PageFactory.initElements(driver, this);
    }

    // Shopping cart link element
    @FindBy(xpath = "//a[contains(@class,'shopping_cart_link')]")
    private WebElement shoppingCart;

    // Open menu button
    @FindBy(xpath = "//button[@type='button'][contains(.,'Open Menu')]")
    private WebElement openMenu;

    // Close menu button
    @FindBy(xpath = "//button[@type='button'][contains(.,'Close Menu')]")
    private WebElement closeMenu;

    // All items menu option
    @FindBy(xpath = "//a[contains(@data-test,'inventory-sidebar-link')]")
    private WebElement allItemsMenuOption;

    // About menu option
    @FindBy(xpath = "//a[contains(@data-test,'logout-sidebar-link')]")
    private WebElement aboutMenuOption;

    // Logout menu option
    @FindBy(xpath = "//a[contains(@data-test,'logout-sidebar-link')]")
    private WebElement logOutMenuOption;

    // Reset app state menu option
    @FindBy(xpath = "//a[contains(@data-test,'reset-sidebar-link')]")
    private WebElement resetAppStateMenuOption;

    /**
     * Navigates to the shopping cart.
     */
    public void navigateToShoppingCart() {
        shoppingCart.click();
        waitToLoad(3);
    }

    /**
     * Opens the menu.
     */
    public void openMenu() {
        openMenu.click();
    }

    /**
     * Closes the menu.
     */
    public void closeMenu() {
        closeMenu.click();
    }

    /**
     * Clicks on the All Items menu option.
     */
    public void click_AllItems_MenuOption() {
        allItemsMenuOption.click();
    }

    /**
     * Clicks on the About menu option.
     */
    public void click_About_MenuOption() {
        aboutMenuOption.click();
    }

    /**
     * Clicks on the Logout menu option.
     */
    public void click_LogOut_MenuOption() {
        logOutMenuOption.click();
    }

    /**
     * Clicks on the Reset App State menu option.
     */
    public void click_ResetAppState_MenuOption() {
        resetAppStateMenuOption.click();
    }
}