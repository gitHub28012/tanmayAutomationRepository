package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.ReadTestData;

public class MakeMyTripFlightBookTest extends ReadTestData{

	static WebDriver driver;
	
	@Test(invocationCount = 2)
	public void flightBookTest() throws InterruptedException
	{
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Browser Launch SuccessFully!!",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.makemytrip.com/");
		Reporter.log("Application Launch Successfully!!",true);
		
		//craete obj of action class
		Actions act = new Actions(driver);
		//create obj of ReadTestData
		ReadTestData raedTestData = new ReadTestData();
		
		//handle modle in mmt
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
		
		//mouse Hover on from
		act.moveToElement(driver.findElement(By.xpath("//span[text()='From']"))).click().build().perform();
		
		//send inputs into from text field 
		String fromLoc = raedTestData.readStringData("Sheet1",1,0);
		
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromLoc);
		Thread.sleep(2000);
		driver.switchTo().frame("notification-frame-~10cb51856").findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		driver.findElement(By.xpath("//li[@data-section-index='0']")).click();
		
		Thread.sleep(2000);
		
		//mouse Hover on To
		act.moveToElement(driver.findElement(By.xpath("//span[text()='To']"))).click().build().perform();
		
		//send inputs into from text field 
		String toLoc = readStringData("Sheet1",1,1);
		
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toLoc);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-section-index='0']")).click();
		
		Thread.sleep(2000);
		driver.quit();
		
		/*
		 * Thread.sleep(2000); List<WebElement> dates = driver.findElements(By.xpath(
		 * "//div[@class='DayPicker-Caption']/../descendant::div[@class='DayPicker-Week']/div"
		 * ));
		 * 
		 * for(int i=0;i<dates.size();i++) {
		 * 
		 * if(dates.get(i).getAttribute("aria-label").contentEquals(readStringData(
		 * "Sheet1",1,2))) { dates.get(i).click(); break; }
		 * 
		 * }
		 */
		
		
		
	}
}
