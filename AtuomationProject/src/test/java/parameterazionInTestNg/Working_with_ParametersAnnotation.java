package parameterazionInTestNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Working_with_ParametersAnnotation {
	
	static WebDriver driver;
	//String url,String searchItems
	
	@Parameters("browser")
	@Test
	public void searchTestCase(String browserValue) throws InvalidBrowserValueException
	{
		
		if(browserValue.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browserValue.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browserValue.equalsIgnoreCase("Edge"))
			driver=new EdgeDriver();
		else 
			throw new InvalidBrowserValueException();
	}

}

        class InvalidBrowserValueException extends Exception
        {
        	public InvalidBrowserValueException()
        	{
        		super("You have Seleceted invalid browser value");
        	}
        }
