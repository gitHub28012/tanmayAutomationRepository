package org.automation.test_scripts;

import org.automation.base.BaseTest;
import org.automation.element_repository.Cart_Page;
import org.automation.element_repository.ProductList_Page;
import org.automation.generic_utilities.CustomeListeners;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomeListeners.class)
public class CartTest extends BaseTest{

	
	@Test
	public void addAndModifyCartMethod() throws InterruptedException
	{
		ProductList_Page plp = new ProductList_Page(driver);
		plp.clickOnSubCategory(plp.getWomenCategoryLink(),plp.getWomenTshirst());
		Cart_Page cp = new Cart_Page(driver);
		explicitwait.until(ExpectedConditions.visibilityOf(cp.getAddToCartButton()));
		Assert.assertEquals(cp.getAddToCartButton().isDisplayed(),true);
		cp.addProducToCart();
	    explicitwait.until(ExpectedConditions.visibilityOf(cp.getRemoveFromCartButton()));
		cp.increaseQtyOfProduct();
		Thread.sleep(2000);
		cp.decreaseQtyOfProduct();
		cp.removeProductFromCart(cp.getRemoveProductYes());
		cp.continueShoppingFromCart();
	}
}
