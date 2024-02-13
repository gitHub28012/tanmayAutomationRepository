package org.automation.base;

import org.automation.generic_utilities.InitObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends InitObjects{
	
	public BasePage(WebDriver driver)
	{
	    PageFactory.initElements(driver,this);	
	}

	
	//================Web elements or Property================
	
//	@FindBy(xpath="//button[@id='loginBtn']")
	@FindBy(id = "loginBtn")
	private WebElement Welcome_Page_LoginButton;
	@FindBy(partialLinkText="Men")
	private WebElement MenCategoryLink;
	@FindBy(xpath = "//a[text()='Women']")
	private WebElement WomenCategoryLink;
	@FindBy(partialLinkText="Kids")
	private WebElement KidsCategoryLink;
	@FindBy(partialLinkText ="Electronic")
	private WebElement ElectronicsCategoryLink;
	@FindBy(partialLinkText = "Beauty")
	private WebElement BeautyCategoryLink;
	@FindBy(partialLinkText = "Help Center")
	private WebElement HelpCenterLink;
	
	//================Getters or Public services================
	
	public WebElement getWelcome_Page_LoginButton() {
		return Welcome_Page_LoginButton;
	}
	public WebElement getMenCategoryLink() {
		return MenCategoryLink;
	}
	public WebElement getWomenCategoryLink() {
		return WomenCategoryLink;
	}
	public WebElement getKidsCategoryLink() {
		return KidsCategoryLink;
	}
	public WebElement getElectronicsCategoryLink() {
		return ElectronicsCategoryLink;
	}
	public WebElement getBeautyCategoryLink() {
		return BeautyCategoryLink;
	}
	public WebElement getHelpCenterLink() {
		return HelpCenterLink;
	}
	
	
	
	
}
