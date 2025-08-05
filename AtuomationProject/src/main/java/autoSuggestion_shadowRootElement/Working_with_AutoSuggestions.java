package autoSuggestion_shadowRootElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_with_AutoSuggestions {


	    public static void main(String[] args) throws Exception {
			
	    	
	    	WebDriver driver=new ChromeDriver();
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	driver.get("https://www.flipkart.com/");
	    	Thread.sleep(5000);
	    	driver.findElement(By.name("q")).sendKeys("Mobiles");
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//div[text()='vivo mobiles 5g']")).click();
		}
}
