 package broken_Linkes;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Links {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com");
		
		Thread.sleep(2000);
		//find the links in Home Page
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//no links in home page
		System.out.println("no of links: "+links.size());
		
		//create list to add the links 
		ArrayList<String> urlList = new ArrayList<String>();
		
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			urlList.add(url);
			//brokenLinkCheck(url);
			
		}
		
		urlList.parallelStream().forEach(link -> brokenLinkCheck(link));

		driver.quit();
		
		
	}

	     public static void brokenLinkCheck(String Linkurl)
	     {
	    	 try {
	    	 URL url = new URL(Linkurl);
	    	 HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
	    	 httpUrlConnection.setConnectTimeout(5000);
	    	 httpUrlConnection.connect();
	    	 
	    	 if(httpUrlConnection.getResponseCode()>=400)
	    	 {
	    		 System.out.println(Linkurl+" "+httpUrlConnection.getResponseMessage()+" is broken link");
	    		 System.out.println();
	    	 }
	    	 else {
	    		 System.out.println(Linkurl+" "+httpUrlConnection.getResponseMessage());
	    		 System.out.println();
	    	 }
	    	 
	    	 }
	    	 catch (Exception e) {
				// TODO: handle exception
			}
	    	 
	     }
	
}
