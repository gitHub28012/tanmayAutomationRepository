package parameterazionInTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Working_with_parameter {
	
	static WebDriver driver;
	
	@Parameters("browser")
	@Test
	public void setUp(@Optional("chrome") String browserValue) throws InvalidBrowserValueeException
	{
		if(browserValue.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else {
		   throw new InvalidBrowserValueeException();
		}
		
		driver.quit();
	}
	
}
     @SuppressWarnings("serial")
     class InvalidBrowserValueeException extends Exception
     {
    	 InvalidBrowserValueeException()
    	 {
    		 super("You have pass the invalid browser value");
    	 }
     }
