package org.automation.element_repository;

import org.apache.commons.math3.analysis.function.Exp;
import org.automation.base.BasePage;
import org.automation.generic_utilities.ActionsUtil;
import org.automation.generic_utilities.InitObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductList_Page extends BasePage{

	public ProductList_Page(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[@id='women']/following-sibling::div/descendant::a[text()='Tshirts']")
	private WebElement womenTshirst;
	@FindBy(xpath = "//a[@id='women']/following-sibling::div/descendant::a[text()='Jackets & Coats']")
	private WebElement womenJacketCoats;
	@FindBy(xpath = "//a[@id='beautyProducts']/../descendant::a[text()='Makeup']")
	private WebElement beautyMakeup;
	@FindBy(xpath = "//a[@id='beautyProducts']/../descendant::a[text()='Lipstick']")
	private WebElement beautyLipstick;
	
	
	
	
	public WebElement getWomenTshirst() {
		return womenTshirst;
	}
	public WebElement getWomenJacketCoats() {
		return womenJacketCoats;
	}
	public WebElement getbeautyMakeup() {
		return beautyMakeup;
	}
	public WebElement getbeautyLipstick() {
		return beautyLipstick;
	}
	
	public void clickOnSubCategory(WebElement category,WebElement subCategory) throws InterruptedException
	{
		InitObjects initObj = new InitObjects();
		initObj.getActionsUtil(driver).mouseHoverOnElement(category);
		initObj.getActionsUtil(driver).mouseHoverOnElement(subCategory);
		subCategory.click();
		
//		ActionsUtil act = new ActionsUtil(driver);
//		Thread.sleep(2000);
//		act.mouseHoverOnElement(category);
//		Thread.sleep(2000);
//		act.mouseHoverOnElement(subCategory);
//		subCategory.click();
	}
	
	
}
