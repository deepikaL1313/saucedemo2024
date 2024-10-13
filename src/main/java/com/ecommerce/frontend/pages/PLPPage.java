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

public class PLPPage extends BasePage{

    private Logger log = LogManager.getLogger(this.getClass().getName());
    WebDriver driver;

    ArrayList productList = new ArrayList<WebElement>();
    /*
     **
     * Constructor for the LoginPage class.
     * Initializes the WebDriver.
     *
     * @param driver The WebDriver instance to be used for interacting with the web application.
     */

    public PLPPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        /*  Initializes the Web Elements Declared*/
        PageFactory.initElements(driver, this);
    }

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

    public boolean isPLPPage() {
        waitForElementTobeVisible(driver,plpPageTitle, Constants.WAIT_TIME_TWO_SECONDS);
        return plpPageTitle.isDisplayed();
    }

    public int numberOfProductsOnPage() {
        return productsList.size();
    }

    public String getProductName(int index) {
        return productName.get(index).getText();
    }

    public String getProductPrice(int index) {
        return productPrice.get(index).getText();
    }

    public String getProductDescription(int index) {
        return productDescription.get(index).getText();
    }

    public void addProductToCart(int index) {
        addToCartBtn.get(index).click();
    }

    public void sortPLPPageBasedOn(String optionName, String optionType) {
        Select select = new Select(sortByDropDown);
        log.info("Selecting sort type as [" +  optionName + "] for Option type ["+optionType+"]");
        switch (optionType){
            case "VisibleText" :  select.selectByVisibleText(optionName); break;
            case "Value" :  select.selectByValue(optionName); break;
            default:
                log.error("Invalid Option Type entered ["+ optionType +"]");
        }
    }

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

    public boolean isProductFoundOnPLPPage(String name) {
        if(findProductOnPLPPage(name) == 0) {
            log.debug("Product [" + name + "] not found at");
            return false;
        }
        else return true;
    }
}



