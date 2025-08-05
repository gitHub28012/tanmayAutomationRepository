package genericUtility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GenericMethods extends InitObjects {

	public String screenShotOfWebPage(WebDriver driver) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String src = ts.getScreenshotAs(OutputType.BASE64);
			String dest = SCREENSHOT_PATH + name() + ".png";
			byte[] decodaedSS = Base64.getDecoder().decode(src);

			try (FileOutputStream fos = new FileOutputStream(dest)) {
				fos.write(decodaedSS);
			}
			return dest;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
