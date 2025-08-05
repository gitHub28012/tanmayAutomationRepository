package autoSuggestion_shadowRootElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Working_with_ClosedShadowroot {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		Actions act = new Actions(driver);

		// Login heading is out of Closed Shadow root it is Host for close shadow_root
		// we can handle closed shadow root using actions class
		driver.findElement(By.xpath("//h1[.='Login']")).click();
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Tanmay").perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Tanmay@123").perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
