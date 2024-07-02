package org.automation.generic_utilities;

public interface FrameworkConstants {
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_PATH="./src/main/resources/drivers/chromedriver.exe";
	
	String EDGE_KEY="webdriver.edge.driver";
	String EDGE_PATH="./src/main/resources/drivers/msedgedriver.exe";
	
	String SCREENSHOT_PATH="./ScreenShots/";
	String PROPERTY_PATH="./src/test/resources/propertyFiles/config.properties";
	String EXCEL_PATH="./src/test/resources/testData/ShoppersStackTestData.xlsx";
	
	String EXTENT_REPORTS="./Reports/";
	
	int PAGE_LOAD_TIMEOUT = 10;
	int IMPLICIT_TIMEOUT = 60;
	int EXPLICIT_TIMEOUT = 30;


}
