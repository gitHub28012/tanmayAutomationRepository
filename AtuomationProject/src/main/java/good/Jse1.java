package good;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Jse1 {
	
	
	public static void main(String[] args) {
		
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.selenium.dev");
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 
		 jse.executeScript("alert ('Hello Selenium!!');");
		 
		 driver.switchTo().alert().accept();
		 
		 WebElement ReadMoreButton = driver.findElement(By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase font-weight-bold']"));
		 
		 jse.executeScript("arguments[0].click();",ReadMoreButton);
		
	}

}
