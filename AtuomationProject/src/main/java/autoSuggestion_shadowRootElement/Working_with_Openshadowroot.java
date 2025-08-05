package autoSuggestion_shadowRootElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_Openshadowroot {
	
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://demoapps.qspiders.com/");
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		
		//ui Testing WebElement 
		WebElement ui_testing_webelement = driver.findElement(By.xpath("//p[contains(text(),'UI Testing ')]"));
		action.moveToElement(ui_testing_webelement).click().build().perform();
		
		Thread.sleep(2000);
		// scroll till shadow root element
		WebElement all_shadow_root_element = driver.findElement(By.xpath("//section[text()='Shadow Root Elements']"));
		action.scrollToElement(all_shadow_root_element).perform();

		Thread.sleep(2000);
		action.moveToElement(all_shadow_root_element).click().build().perform();
		
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(2000);
		
		// handle open shadow root element...
		WebElement first_shadow_hostElement = driver.findElement(By.xpath("(//div[@class='my-3'])[1]"));
		SearchContext username_shadowRootElement = first_shadow_hostElement.getShadowRoot();
		Thread.sleep(2000);
		username_shadowRootElement.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("Tanmay");

		Thread.sleep(2000);
		
		WebElement second_shadow_hostElement = driver.findElement(By.xpath("(//div[@class='my-3'])[2]"));
		SearchContext password_shadowRootElement = second_shadow_hostElement.getShadowRoot();
		password_shadowRootElement.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys("Tanmay@123");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
