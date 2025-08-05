package excellant;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TakesScreenShotOfFullWebPage {

	protected static WebDriver driver;
	static WebDriverWait explicitWait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println(driver.getTitle());
	}

	
	@Test
	public void ss() throws IOException
	{
	
		File src = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("./ss/FullScreenShot.png"));
		
	}
}
