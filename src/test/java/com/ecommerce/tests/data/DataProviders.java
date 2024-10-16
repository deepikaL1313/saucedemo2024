package com.ecommerce.tests.data;

import com.ecommerce.core.utils.ExcelUtility;
import com.ecommerce.frontend.constants.Constants;
import org.testng.annotations.DataProvider;

/**
 * DataProviders class for providing test data to test methods.
 */
public class DataProviders {

    /**
     * Provides test data for valid login credentials.
     *
     * @return A 2D array of valid login credentials.
     */
    @DataProvider(name ="testDataForValidLoginCredentials", parallel = false)
    public Object[][] testDataForValidLoginCredentials() {
        // Read data from Excel sheet
        String[][] data = new ExcelUtility()
                .getDataFromExcelSheet(Constants.PATH_TO_TEST_DATA_FILE, "TestDataSauce", "LoginValidCredentials");
        return data;
    }

    /**
     * Provides test data for invalid login credentials.
     *
     * @return A 2D array of invalid login credentials.
     */
    @DataProvider(name ="testDataForInValidLoginCredentials", parallel = false)
    public Object[][] testDataForInValidLoginCredentials() {
        // Read data from Excel sheet
        String[][] data = new ExcelUtility()
                .getDataFromExcelSheet(Constants.PATH_TO_TEST_DATA_FILE, "TestDataSauce", "LoginWithInValidCredentials");
        return data;
    }

    /**
     * Provides test data for products.
     *
     * @return A 2D array of product data.
     */
    @DataProvider(name = "testDataForProducts", parallel = false)
    public Object[][] testDataForProducts() {
        // Placeholder for product data
        String[][] data = {{},{},{}};
        return data;
    }
}
