package org.automation.element_repository;

import org.automation.base.BasePage;
import org.automation.generic_utilities.InitObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_Page extends BasePage{

	public Cart_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "(//button[text()='add to cart'])[1]")
	private WebElement AddToCartButton;
	@FindBy(id="cart")
	private WebElement CartIcon;
	@FindBy(xpath = "//button[@id='buynow_fl']")
	private WebElement BuyNowButton;
	@FindBy(xpath = "//span[text()='Continue Shopping']")
	private WebElement ContinueShoppingButton;
	@FindBy(css = "path[d*='M7 11']")
	private WebElement minusIcon;
	@FindBy(css = "path[d*='M13']")
	private WebElement plusIcon;
	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textError MuiButton-sizeS')]")
	private WebElement RemoveFromCartButton;
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement RemoveProductYes;
	
	
	
	public WebElement getAddToCartButton() {
		return AddToCartButton;
	}
	public WebElement getCartIcon() {
		return CartIcon;
	}
	public WebElement getBuyNowButton() {
		return BuyNowButton;
	}
	public WebElement getContinueShoppingButton() {
		return ContinueShoppingButton;
	}
	public WebElement getMinusIcon() {
		return minusIcon;
	}
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getRemoveFromCartButton() {
		return RemoveFromCartButton;
	}
	public WebElement getRemoveProductYes() {
		return RemoveProductYes;
	}
	
	
	
	
	
	
	public void addProducToCart()
	{
		AddToCartButton.click();
		CartIcon.click();
	}
	
	public void increaseQtyOfProduct()
	{
		plusIcon.click();
	}
	
	public void decreaseQtyOfProduct()
	{
		minusIcon.click();
	}
	

	public void removeProductFromCart(WebElement ele)
	{
		RemoveFromCartButton.click();
		InitObjects initObj = new InitObjects();
		initObj.getUtilityMethods().acceptConfirmation(ele);
	}

	public void buyProductFromCart()
	{
		BuyNowButton.click();
	}
	
	public void continueShoppingFromCart()
	{
		ContinueShoppingButton.click();
	}
}
