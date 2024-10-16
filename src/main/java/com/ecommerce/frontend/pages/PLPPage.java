package com.ecommerce.frontend.pages;

import com.ecommerce.frontend.constants.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

/**
 * PLPPage class for interacting with the Product Listing Page (PLP) of the web application.
 */
public class PLPPage extends BasePage {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    // WebDriver instance
    WebDriver driver;

    // List to store product elements
    ArrayList<WebElement> productList = new ArrayList<>();

    /**
     * Constructor for the PLPPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */
    public PLPPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // Initialize the Web Elements declared with @FindBy annotations
        PageFactory.initElements(driver, this);
    }

    // Locators for Web Elements on the PLP
    @FindBy(xpath = "//span[@class='title'][contains(.,'Products')]")
    private WebElement plpPageTitle;

    @FindBy(xpath = "//div[contains(@class,'inventory_list')]")
    private List<WebElement> productsList;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<WebElement> productName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrice;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private List<WebElement> productDescription;

    @FindBy(xpath = "(//button[contains(.,'Add to cart')])")
    private List<WebElement> addToCartBtn;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement sortByDropDown;

    /**
     * Checks if the PLP page is displayed.
     *
     * @return true if the PLP page is displayed, false otherwise.
     */
    public boolean isPLPPage() {
        waitForElementToBeVisible(driver, plpPageTitle, Constants.WAIT_TIME_TWO_SECONDS);
        return plpPageTitle.isDisplayed();
    }

    /**
     * Returns the number of products on the PLP.
     *
     * @return The number of products listed on the PLP.
     */
    public int numberOfProductsOnPage() {
        return productsList.size();
    }

    /**
     * Gets the name of a product by index.
     *
     * @param index The index of the product in the list.
     * @return The name of the product.
     */
    public String getProductName(int index) {
        return productName.get(index).getText();
    }

    /**
     * Gets the price of a product by index.
     *
     * @param index The index of the product in the list.
     * @return The price of the product.
     */
    public String getProductPrice(int index) {
        return productPrice.get(index).getText();
    }

    /**
     * Gets the description of a product by index.
     *
     * @param index The index of the product in the list.
     * @return The description of the product.
     */
    public String getProductDescription(int index) {
        return productDescription.get(index).getText();
    }

    /**
     * Adds a product to the cart by index.
     *
     * @param index The index of the product in the list.
     */
    public void addProductToCart(int index) {
        addToCartBtn.get(index).click();
    }

    /**
     * Sorts the PLP page based on the specified option.
     *
     * @param optionName The name of the option to sort by possible values
     *
     *        * Name (A to Z)
     *        * Name (Z to A)
     *        * Price (Low to High)
     *        * Price (High to Low)
     *
     * @param selectBy method to be used possible values :
     *         * VisibleText
     *         * Value
     */
    public void sortPLPPageBasedOn(String optionName, String selectBy) {
        Select select = new Select(sortByDropDown);
        log.info("Selecting sort type as [" + optionName + "] for Option type [" + selectBy + "]");
        switch (selectBy) {
            case "VisibleText":
                select.selectByVisibleText(optionName);
                break;
            case "Value":
                select.selectByValue(optionName);
                break;
            default:
                log.error("Invalid Option Type entered [" + selectBy + "]");
        }
    }

    /**
     * Finds a product on the PLP by name.
     *
     * @param name The name of the product to find.
     * @return The index of the product if found, 0 otherwise.
     */
    public int findProductOnPLPPage(String name) {
        int i = 1;
        for (WebElement ele : productName) {
            if (ele.getText().equalsIgnoreCase(name)) {
                log.info("Product [" + name + "] found at [" + i + "]");
                return i;
            }
            i++;
        }
        return 0;
    }

    /**
     * Checks if a product is found on the PLP.
     *
     * @param name The name of the product to be found
     * @return true if the product is found, false otherwise.
     */
    public boolean isProductFoundOnPLPPage(String name) {
        if (findProductOnPLPPage(name) == 0) {
            log.error("Product [" + name + "] not found in PLP");
            return false;
        } else {
            return true;
        }
    }
}