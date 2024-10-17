package com.ecommerce.tests.suite;

import com.ecommerce.tests.data.DataProviders;
import com.ecommerce.frontend.pages.FooterSection;
import com.ecommerce.frontend.pages.LoginPage;
import com.ecommerce.tests.base.BaseTest;
import com.ecommerce.frontend.pages.PLPPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * LoginTest class for testing login functionality.
 */
public class LoginTest extends BaseTest {
    // Logger for logging information
    private Logger log = LogManager.getLogger(this.getClass().getName());

    /**
     * Verifies if a valid user can login.
     *
     * @param username The username to login with.
     * @param password The password to login with.
     * @throws Exception If an error occurs during the test.
     */
    @Test(groups = {"SANITY", "REGRESSION"}, description = "verifyLoginTest - Verifies if a valid user can login",
            dataProvider = "testDataForValidLoginCredentials", dataProviderClass = DataProviders.class)
    public void verifyLoginWithValidCredentialsTest(String username, String password) throws Exception {
        SoftAssert s_assert = new SoftAssert();
        boolean result = false;
        try {
            log.info("STEP 1 : Navigated to URL [" + getDriver().getCurrentUrl() + "]");
            LoginPage loginPage = new LoginPage(getDriver());

            log.info("STEP 2 : Verify Login page is loaded");
            result = loginPage.isLoginPage();
            s_assert.assertTrue(result, "Login Page is not displayed");
            log.info("STEP 3 : Login page Opened : [" + result + "]");

            log.info("STEP 4 : Enter credentials on Login page : Username and Password and click Login button");
            loginPage.enterUserName(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginBtn();

            log.info("STEP 5 : Verify PLP page is loaded");
            PLPPage plpPage = new PLPPage(getDriver());
            result = plpPage.isPLPPage();
            log.info("STEP 6 : PLP page Opened : [" + result + "]");
            takeScreenshot();
            s_assert.assertTrue(result, "PLP Page is not displayed");

            log.info("STEP 7 : Verify Footer section of PLP page is loaded");
            FooterSection footerSection = new FooterSection(getDriver());
            result = footerSection.isFooterMessageCorrect();
            log.info("STEP 8 : Footer section of PLP page Opened : [" + result + "]");
            s_assert.assertTrue(result, "Footer message is not correct");

            log.info("STEP 9 : Footer section Message is : [" + footerSection.getFooterMessage() + "]");
            takeScreenshot();
        } catch (Exception e) {
            s_assert.fail("Exception Occurred during execution of Test : [" + e.getMessage() + "]");
            log.error("Exception Occurred during execution of Test [" + e.getMessage() + "]");
        } finally {
            takeScreenshot();
            s_assert.assertAll();
        }
    }

    /**
     * Verifies if invalid user cannot login.
     *
     * @param username The username to login with.
     * @param password The password to login with.
     */
    @Test(groups = {"SANITY", "REGRESSION"}, description = "verifyLoginTest - Verifies if invalid user cannot login",
            dataProvider = "testDataForInValidLoginCredentials", dataProviderClass = DataProviders.class)
    public void verifyLoginWithInValidCredentialsTest(String username, String password) {
        SoftAssert s_assert = new SoftAssert();
        boolean result = false;
        try {
            log.info("STEP 1 : Navigated to URL [" + getDriver().getCurrentUrl() + "]");
            LoginPage loginPage = new LoginPage(getDriver());

            log.info("STEP 2 : Verify Login page is loaded");
            result = loginPage.isLoginPage();
            s_assert.assertTrue(result, "Login Page is not displayed");

            log.info("STEP 3 : Login page Opened : [" + result + "]");

            log.info("STEP 4 : Enter credentials on Login page : Username and Password and click Login button");
            loginPage.enterUserName(username);
            loginPage.enterPassword(password);
            loginPage.clickLoginBtn();

            log.info("STEP 5 : Verify Error message for locked out user");
            result = loginPage.isLockedOut();
            s_assert.assertTrue(result, "Locked out user error message is not displayed");

            log.info("STEP 6 : Locked out user error message displayed? [" + result + "]");
            s_assert.assertAll();
            takeScreenshot();
        } catch (Exception e) {
            s_assert.fail("Exception Occurred during execution of Test : [" + e.getMessage() + "]");
            log.error("Exception Occurred during execution of Test [" + e.getMessage() + "]");
            s_assert.assertAll();
        } finally {
            takeScreenshot();
        }
    }
}
