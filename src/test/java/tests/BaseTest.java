package tests;

import java.lang.reflect.Method;
import utilities.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExtentManager;

public class BaseTest {
	 protected ExtentTest test;
	protected WebDriver driver;
	protected static ExtentReports extent;
	@BeforeMethod
	public void setup(Method method) {
		test = extent.createTest(method.getName());
		String browser = ConfigReader.getProperty("browser");
		driver = DriverFactory.getDriver(browser);
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
	}
	
	
	@BeforeSuite
	public void startReport() {
		extent = ExtentManager.getReport();
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()== ITestResult.FAILURE) {
			String path = ScreenshotUtils.captureScreenshots(driver, result.getName());
			test.fail("Test Failed").addScreenCaptureFromPath(path);
		}
		else if (result.getStatus()== ITestResult.SUCCESS) {
			test.pass("Test Passed");
		}
	driver.quit();	
	}
	
	
}
