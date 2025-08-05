package excellant;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class MoveToElementMethod {

	static WebDriver driver;

	@Test
	public void moveToElementWeb() throws InterruptedException {
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.bluestone.com/");

		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleContains(driver.getTitle()));

		driver.findElement(By.id("denyBtn")).click();
		WebElement target = driver.findElement(By.xpath("//a[.='Coins ']"));

		Actions act = new Actions(driver);
		act.moveToElement(target).perform();

		driver.findElement(By.xpath("(//span[contains(@data-p,'gold-coins-weight-1gms') and (text()='1 gram')])[1]"))
				.click();

		WebElement coin = driver.findElement(By.xpath("//a[@id='5920']"));

		if (coin.isDisplayed()) {
			Thread.sleep(2000);
			driver.quit();
		} else {
			System.out.println("Exception!!");
		}

	}
}
