package genericUtility;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class InitObjects implements IautoConstant {
	
	public ExtentReports extents;
	public ExtentSparkReporter spark;
	protected static WebDriver driver;
	public InitObjects init;
	public GenericMethods genM;
	public ExtentTest eTest;
    public ExtentSparkReporter getExtentSparkReporter(String nameOfReport)
    {
    	return new ExtentSparkReporter(EXTENT_REPORT_PATH+nameOfReport);
    }
    
    public ExtentReports getExtentReports()
    {
    	return new ExtentReports();
    }
    
    public InitObjects getInitObject()
    {
    	return new InitObjects();
    }
    
    public GenericMethods getGenMethods()
    {
    	return new GenericMethods();
    }
    
    
    public String name()
	{
		  LocalDateTime time = LocalDateTime.now();	
	      String name = time.toString().replace(":","-");
	      return name;
	}
	
}
