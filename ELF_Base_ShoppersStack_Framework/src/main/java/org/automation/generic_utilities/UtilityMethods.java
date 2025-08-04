package org.automation.generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class UtilityMethods implements FrameworkConstants {
	
	/***
	 * this method used control specific window
	 * @param driver
	 * @param title
	 */
	public void switchToASpecificTitleWindow(WebDriver driver,String title)
	{
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String wh:allWindowId)
		{
			driver.switchTo().window(wh);
			if(driver.getTitle().equals(title))
			{
				break;
			}
		}
		
	}
	
	public void switchToASepecificWindow(WebDriver driver,WebElement ele)
	{
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentWindowId);
		for(String wh:allWindowId)
		{
			driver.switchTo().window(wh);
			if(ele.isDisplayed())
			{
				break;
			}
		}
	}

	public  String captureScreen(WebDriver driver, ITestResult result) {
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		String filePath = SCREENSHOT_PATH + result.getName()+".png";
		File tempFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		try {
			FileUtils.copyFile(tempFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

	
	public void selectDropDown(WebElement dropDownElement,String option)
	{
	       Select sel = new Select(dropDownElement);	
	       
	       int counter=0;
	       try {
	       int index = Integer.parseInt(option);
	       sel.selectByIndex(index);
	       counter++;
	       }
	       catch (Exception e)
	       {
	    	   System.out.println("It is not a index"); 
	       }
	       
	       if(counter==0)
	       {
	    	   try {
	    	  sel.selectByVisibleText(option);
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   sel.selectByValue(option);
	    	   }
	    	  
	       }
	}
	
	
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		try
		{
		int index = Integer.parseInt(nameOrId);
		driver.switchTo().frame(index);
		}
		catch(Exception e)
		{
			driver.switchTo().frame(nameOrId);
		}
	}
	
	public int getRandomNumber(int boundary)
	{
		Random random = new Random();
		return random.nextInt(boundary);
	}
	
	public Date giveSystemDate()
	{
		return new Date();
	}
	
	public void acceptConfirmation(WebElement ele)
	{
	   ele.click();	
	}
	
	public void dismissConfirmation(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	
	}
	
	public static String sentInputThroughCmd()
	{
	   return System.getProperty("loginAs");
	}
}
