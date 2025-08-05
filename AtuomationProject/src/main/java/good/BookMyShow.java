package good;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		driver.get("https://in.bookmyshow.com/sports/india-vs-bangladesh-icc-mens-cwc-2023/seat-layout/aerialcanvas/ET00367564/MCAS/10111?groupEventCode=ET00367219");
		
		
		Thread.sleep(2000);
		for(int i=0;i<=100;i++)
		{
			
		Thread.sleep(100000);
		driver.navigate().refresh();
		}
		
		
	}
}
