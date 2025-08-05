package working_with_Waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Working_with_FluientWait {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		FluentWait fluentWait = new FluentWait(driver);
		fluentWait.pollingEvery(Duration.ofSeconds(1));
		fluentWait.withTimeout(Duration.ofSeconds(15));
		fluentWait.ignoring(NoSuchElementException.class);
		
		
		driver.get("https://demowebshop.tricentis.com/");
		
		
		driver.findElement(By.id("small-searchterms")).sendKeys("computers");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		fluentWait.pollingEvery(Duration.ofSeconds(1));
		fluentWait.withTimeout(Duration.ofSeconds(15));
		fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Searc']"))));
		fluentWait.ignoring(NoSuchElementException.class);
		
		driver.quit();
		
		
	}

}
