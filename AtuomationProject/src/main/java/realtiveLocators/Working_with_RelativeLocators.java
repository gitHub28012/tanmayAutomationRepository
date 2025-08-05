package realtiveLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Working_with_RelativeLocators {
	
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch the demo web shop
		 driver.get("https://demowebshop.tricentis.com");
		 
		 
			/*
			 * //pass the inputs to Search store field which is Left to search button
			 * driver.findElement(RelativeLocator.with(By.tagName("input"))
			 * .toLeftOf(By.cssSelector(".button-1.search-box-button"))).sendKeys("mobiles");
			 *
			 * 
			 * //click on search button which is Right to search store field
			 * driver.findElement(RelativeLocator.with(By.tagName("input"))
			 * .toRightOf(By.id("small-searchterms"))).click();
			 */
		 
		 
			/*
			 * //click on Excellent radio button which is above to Good radio button
			 * driver.findElement(RelativeLocator.with(By.tagName("input"))
			 * .above(By.id("pollanswers-2"))).click();
			 * 
			 * //click on Good radio button which is below to Excellent radio button
			 * driver.findElement(RelativeLocator.with(By.tagName("input"))
			 * .below(By.id("pollanswers-1"))).click();
			 */
		 
		 
			/*
			 * //click on Register link which is near to Log in link
			 * driver.findElement(RelativeLocator.with(By.tagName("a"))
			 * .near(By.partialLinkText("Log"))).click();
			 */
	}

}
