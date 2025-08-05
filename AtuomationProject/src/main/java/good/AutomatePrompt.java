package good;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatePrompt {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("https://chat.openai.com/");
		
		driver.findElement(By.xpath("//button[text()u='Log in']")).click();
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
	}

}
