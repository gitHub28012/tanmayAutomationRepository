package com.orangeHRM.genericPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends InitObjects{
	
	               
	public BasePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}
	
	
}