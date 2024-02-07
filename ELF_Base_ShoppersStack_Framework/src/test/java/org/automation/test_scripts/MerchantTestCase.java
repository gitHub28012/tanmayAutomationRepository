package org.automation.test_scripts;

import org.automation.base.BaseTest;
import org.automation.element_repository.Merchant_Page;
import org.automation.generic_utilities.CustomeListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomeListeners.class)

public class MerchantTestCase extends BaseTest {
	
	
	@Test(alwaysRun = true)
	public void addProdctToShoppersStack() throws InterruptedException
	{
		Merchant_Page mp = new Merchant_Page(driver);
		Assert.assertEquals(driver.getTitle(),"ShoppersStack | Login");
		
	     String productName = readData.readAnyDataFromExcelInString("AddProductData",1,0);
		 String brand = readData.readAnyDataFromExcelInString("AddProductData",1,1);
		 String productTitle = readData.readAnyDataFromExcelInString("AddProductData",1,2);
		 String off = readData.readAnyDataFromExcelInString("AddProductData",1,3);
		 String price = readData.readAnyDataFromExcelInString("AddProductData",1,4);
		 String qty = readData.readAnyDataFromExcelInString("AddProductData",1,5);
		 String thumbnail = readData.readAnyDataFromExcelInString("AddProductData",1,6);
		 String desc = readData.readAnyDataFromExcelInString("AddProductData",1,7);
		 String productLink = readData.readAnyDataFromExcelInString("AddProductData",1,8);
		 String searchTag = readData.readAnyDataFromExcelInString("AddProductData",1,9);
		 
		 mp.addProductDetails(productName, brand, productTitle);
		 mp.selectProductCategoryAndOffer("electronics","mobile", off);
		 mp.productPriceQtyAndThumbnail(price, qty, thumbnail);
		 mp.productDescriptionLinkAndSearchTag(desc, productLink, searchTag);
		 mp.saveAndSubmitProduct();
		
		
	}

}
