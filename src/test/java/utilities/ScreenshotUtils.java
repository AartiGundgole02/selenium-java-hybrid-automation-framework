package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	
	public static String captureScreenshots(WebDriver driver, String testName) {
		String path = System.getProperty("user.dir")+
				"/reports/screenshots/"+
				testName + ".png";
		try {
			File src = ((TakesScreenshot)driver).
					getScreenshotAs(OutputType.FILE);
			
			File dest = new File(path);
			Files.createDirectories(dest.getParentFile().toPath());
			Files.copy(src.toPath(),dest.toPath());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return path;
		
	}
	
	
	
}
