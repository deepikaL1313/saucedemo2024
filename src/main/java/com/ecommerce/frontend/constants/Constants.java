package com.ecommerce.frontend.constants;

public class Constants {

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final int WAIT_TIME_TWO_SECONDS = 2;
    public static final int WAIT_TIME_THREE_SECONDS = 3;
    public static final int WAIT_TIME_FIVE_SECONDS = 5;
    public static final String Application_URL_STAGE = "https://www.saucedemo.com/";
    public static final String Application_URL_PROD = "https://www.saucedemo.com/";
    public static final String Application_URL_DEV = "https://www.saucedemo.com/";

    public static final String PATH_TO_TEST_DATA_FILE = PROJECT_PATH + "/src/test/java/com/ecommerce/tests/data/TestDataForSauceDemo.xls";
    public static final String PATH_TO_SCREENSHOTS_FOLDER =  PROJECT_PATH + "/target/screenshots/";
    public static final String DATE_FORMAT =  "yyyyMMdd_HHmmss";

}
