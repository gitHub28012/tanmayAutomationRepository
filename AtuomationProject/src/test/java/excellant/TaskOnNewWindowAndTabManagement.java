package excellant;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.genericpackage.BaseTest;

public class TaskOnNewWindowAndTabManagement extends BaseTest {

	protected static WebDriver driver;
	static WebDriverWait explicitWait;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println(driver.getTitle());
	}

//	@Test(priority = 0)
//	public void newWindowOne() {
//
//		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
//		newWindow.get("https://demowebshop.tricentis.com/search");
//		System.out.println(driver.getTitle());
//
//	}

	@Test(priority = 0)
	public void newTask() {
		driver.switchTo().newWindow(WindowType.TAB).get("https://demowebshop.tricentis.com/newproducts");
		System.out.println(driver.getTitle());

		driver.findElement(By.name("q")).sendKeys("Books");
		driver.findElement(By.xpath("//input[@value='Search']")).click();

		Set<String> allHandles = driver.getWindowHandles();
		Iterator<String> handles = allHandles.iterator();

		String wh = handles.next();

		driver.switchTo().window(wh);

		driver.findElement(By.partialLinkText("Register")).click();
		
		
	}
	
	
	
	
}
