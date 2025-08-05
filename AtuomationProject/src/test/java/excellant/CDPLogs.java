package excellant;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.log.model.LogEntry;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CDPLogs {

	

	static ChromeDriver driver;
	//ChromeOptions options;
	
	@BeforeClass
	public void setUp() {
	
		
//		WebDriverManager.chromedriver().setup();
//		options=new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		options.setExperimentalOption("w3c", false);	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void allLogsOfConsole() {
		// Get the DevTools and Create Session
		
		DevTools devTools = driver.getDevTools();
		
        devTools.createSession();
        
        //Enable The console Logs
        devTools.send(Log.enable());
        
//        //Add Listener for the console Logs 
//     //   devTools.addListener(Log.entryAdded(),logEntry->	
//        {
//        	System.out.println("----------");
//        	System.out.println("Level: "+logEntry.getLevel());
//        	System.out.println("Text: "+logEntry.getText());
//        	System.out.println("Url: "+logEntry.getUrl());
//        });
//        
//        //Launch Aut 
//        driver.get("https://the-internet.herokuapp.com/broken_images");
//	}

}
}