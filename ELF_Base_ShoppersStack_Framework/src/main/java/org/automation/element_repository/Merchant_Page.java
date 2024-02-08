package org.automation.element_repository;

import java.util.List;

import org.automation.base.BasePage;
import org.automation.generic_utilities.InitObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Merchant_Page extends BasePage {

	public Merchant_Page(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//button[@aria-label='open drawer']")
	private WebElement hamburgerIcon;
	@FindBy(xpath = "//span[text()='Product ']/ancestor::div[@id='panel1a-header']")
	private WebElement productIcon;
	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProductLink;
	@FindBy(xpath = "//span[text()='View All Products']")
	private WebElement viewAllProductsLink;
	@FindBy(xpath = "//span[text()='Account']/ancestor::div[@id='panel1a-header']")
    private WebElement accountIcon;
	@FindBy(xpath = "//span[text()='view profile']")
	private WebElement viewProfileLink;
	@FindBy(id="pname")
	private WebElement productNameTB;
	@FindBy(id = "brand")
	private WebElement brandTB;
	@FindBy(id = "productTilte")
	private WebElement productTilteTB;
	@FindBy(id = "category")
	private WebElement categoryDropDown;
	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz']")
	private List<WebElement> allCategory;
	@FindBy(xpath = "//li[contains(@class,'MuiButt')]")
	private List<WebElement> subCategory;
	@FindBy(id = "categoryType")
	private WebElement categoryTypeDropDown;
	@FindBy(id = "offer")
	private WebElement offerTB;
	@FindBy(xpath = "//input[@id='outlined-size-small'][1]")
	private WebElement priceTB;
	@FindBy(xpath = "(//input[@id='outlined-size-small'])[2]")
	private WebElement quantityTB;
	@FindBy(id = "thumbnailImages")
	private WebElement thumbnailImagesTB;
	@FindBy(id = "description")
	private WebElement descriptionTA;
	@FindBy(id = "ProductImages")
	private WebElement ProductImagesTB;
	@FindBy(css = "path[d*='M13 7h-2v4']")
	private WebElement plusIcon;
	@FindBy(id = "searchTags")
	private WebElement searchTagsTB;
	@FindBy(xpath = "//button[@class='product_bn5__VFa-4']")
	private WebElement saveProductButton;
	@FindBy(xpath = "//button[text()='Submit Products']")
	private WebElement submitProductsButton;
	@FindBy(xpath = "(//span[@class='MuiIconButton-label'])[2]")
	private WebElement plusSearchTagIcon;
	
	
	
	
	
	public WebElement getPlusSearchTagIcon() {
		return plusSearchTagIcon;
	}
	public WebElement getHamburgerIcon() {
		return hamburgerIcon;
	}
	public WebElement getProductIcon() {
		return productIcon;
	}
	public WebElement getAddProductLink() {
		return addProductLink;
	}
	public WebElement getViewAllProductsLink() {
		return viewAllProductsLink;
	}
	public WebElement getAccountIcon() {
		return accountIcon;
	}
	public WebElement getViewProfileLink() {
		return viewProfileLink;
	}
	public WebElement getProductNameTB() {
		return productNameTB;
	}
	public WebElement getBrandTB() {
		return brandTB;
	}
	public WebElement getProductTilteTB() {
		return productTilteTB;
	}
	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}
	public WebElement getOfferTB() {
		return offerTB;
	}
	public WebElement getPriceTB() {
		return priceTB;
	}
	public WebElement getQuantityTB() {
		return quantityTB;
	}
	public WebElement getThumbnailImagesTB() {
		return thumbnailImagesTB;
	}
	public WebElement getDescriptionTA() {
		return descriptionTA;
	}
	public WebElement getProductImagesTB() {
		return ProductImagesTB;
	}
	public WebElement getPlusIcon() {
		return plusIcon;
	}
	public WebElement getSearchTagsTB() {
		return searchTagsTB;
	}
	public WebElement getSaveProductButton() {
		return saveProductButton;
	}
	public WebElement getSubmitProductsButton() {
		return submitProductsButton;
	}
	
	public List<WebElement> getAllCategory() {
		return allCategory;
	}
	public List<WebElement> getSubCategory() {
		return subCategory;
	}
	public WebElement getCategoryTypeDropDown() {
		return categoryTypeDropDown;
	}
	
	
	
	public void addProductDetails(String productName,String brand,String productTitle) throws InterruptedException
	{
	    hamburgerIcon.click();
	    Thread.sleep(2000);
	    productIcon.click();
	    addProductLink.click();
		productNameTB.sendKeys(productName);
		brandTB.sendKeys(brand);
		productTilteTB.sendKeys(productTitle);
		
	}
	
	public void selectProductCategoryAndOffer(String cateGory,String subCate,String off)
	{
	    categoryDropDown.click();
		for(WebElement cate:allCategory)
		{
		     if (cate.getText().equalsIgnoreCase(cateGory)) 
		     {
				cate.click();
				break;
			}
			
		}
		categoryTypeDropDown.click();
		for(WebElement sc:subCategory)
		{
			if (sc.getText().equalsIgnoreCase(subCate))
			{
				sc.click();
				break;
			}
			
		}
		//offerTB.clear();
		offerTB.sendKeys(off);
	}
	
	public void productPriceQtyAndThumbnail(String price,String qty,String thumbn)
	{
		priceTB.clear();
		priceTB.sendKeys(price);
		quantityTB.sendKeys(qty);
		thumbnailImagesTB.sendKeys(thumbn);
	}
	
	public void productDescriptionLinkAndSearchTag(String desc,String link,String tag) throws InterruptedException
	{
	
		descriptionTA.sendKeys(desc);
		ProductImagesTB.sendKeys(link);
		plusIcon.click();
		Thread.sleep(2000);
		searchTagsTB.sendKeys(tag);
		Thread.sleep(2000);
		plusSearchTagIcon.click();
		Thread.sleep(2000);
	}
	
	public void saveAndSubmitProduct()
	{
		saveProductButton.click();
		submitProductsButton.click();
	}
	
	
}
