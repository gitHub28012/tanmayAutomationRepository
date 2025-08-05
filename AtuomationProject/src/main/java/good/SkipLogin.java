package good;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SkipLogin {
	
	static  WebDriver driver;
	
	public static void main(String[] args) {
		
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.get("https://login.upstox.com/");
      
//      driver.findElement(By.id("mobileNum")).sendKeys("");
//      driver.findElement(By.id("getOtp")).click();
      Cookie cookie = new Cookie("auth_identity_token_expiry","1709656365295");
      driver.manage().addCookie(cookie);
    //  driver.navigate().refresh();
		
	}

}
