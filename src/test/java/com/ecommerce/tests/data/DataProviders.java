package com.ecommerce.tests.data;

import com.ecommerce.core.utils.ExcelUtility;
import com.ecommerce.frontend.constants.Constants;
import org.testng.annotations.DataProvider;
public class DataProviders {

    @DataProvider(name ="testDataForValidLoginCredentials", parallel = false)
    public Object[][] testDataForValidLoginCredentials() {
//        String[][] data = {
//                {"standard_user","secret_sauce"},
//                {"problem_user","secret_sauce"},
//                {"error_user","secret_sauce"},
//                {"visual_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"}
//        };
        String[][] data =  new ExcelUtility().
                getDataFromExcelSheet(Constants.PATH_TO_TEST_DATA_FILE,"TestDataSauce","LoginValidCredentials");
        return data;
    }

    @DataProvider(name ="testDataForInValidLoginCredentials", parallel = false)
    public Object[][] testDataForInValidLoginCredentials() {
        String[][] data = new ExcelUtility().
                getDataFromExcelSheet(Constants.PATH_TO_TEST_DATA_FILE,"TestDataSauce","LoginWithInValidCredentials");
        return data;
    }

    public Object[][] testDataForProducts() {
        String[][] data = {{},{},{}};
        return data;
    }
}
