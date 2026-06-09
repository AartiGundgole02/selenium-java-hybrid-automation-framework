package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver= driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public boolean verifyElementIsPresent(By locator) {
		
		try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		}catch(Exception e) {
		System.out.println("Element Not found" + e);
		return false;
		}	
		
	}
	
	public boolean verifyAndClick(By locator) {

	    try {
	        WebElement element = wait.until(
	                ExpectedConditions.elementToBeClickable(locator));

	        element.click();

	        return true;

	    } catch (Exception e) {

	        System.out.println("Unable to click on element: " + locator);
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public String getAttributeValue(By locator, String attributeName) {

	    try {
	        WebElement element =
	                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        return element.getDomAttribute(attributeName);

	    } catch (Exception e) {

	        System.out.println("Unable to fetch attribute value for: " + locator);
	        return null;
	    }
	}
	
	public boolean writeInput(By locator, String data) {

	    try {
	        WebElement element =
	                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        element.clear();
	        element.sendKeys(data);

	        return true;

	    } catch (Exception e) {

	        System.out.println("Unable to enter data into field: " + locator);
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public boolean selectValueFromList(By locator, String expectedValue) {

	    try {

	        List<WebElement> elements = driver.findElements(locator);

	        for (WebElement element : elements) {

	            String actualValue = element.getText().trim();

	            if (actualValue.equalsIgnoreCase(expectedValue.trim())) {

	                element.click();
	                return true;
	            }
	        }

	        System.out.println("Value not found in list: " + expectedValue);
	        return false;

	    } catch (Exception e) {

	        System.out.println("Unable to select value from list");
	        e.printStackTrace();
	        return false;
	    }
	}
public List<String> getAllDropDownValues(By locator){
		
		List<String> dropDownValues = new ArrayList<String>();
		try {
		List<WebElement> elements = driver.findElements(locator);
		for (WebElement element : elements) {
			dropDownValues.add(element.getText().trim());
		}
		}catch(Exception e){
			System.out.println("Unable to Fetch the dropdown values" +  locator);
			e.printStackTrace();
		}
		return dropDownValues;
	}
	
	
	public String getFormattedTodaysDate(String data) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(data);
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            String todaysdate = dateFormat.format(date);
            return todaysdate;
        } catch (Exception e) {
            return null;
        }
    }
	
	public boolean pressKey(By locator, String key) {

	    try {

	        WebElement element = driver.findElement(locator);

	        switch (key.toLowerCase()) {

	            case "enter":
	                element.sendKeys(Keys.ENTER);
	                break;

	            case "tab":
	                element.sendKeys(Keys.TAB);
	                break;

	            case "delete":
	                element.sendKeys(Keys.DELETE);
	                break;

	            case "backspace":
	                element.sendKeys(Keys.BACK_SPACE);
	                break;

	            case "up":
	                element.sendKeys(Keys.ARROW_UP);
	                break;

	            case "down":
	                element.sendKeys(Keys.ARROW_DOWN);
	                break;

	            case "pageup":
	                element.sendKeys(Keys.PAGE_UP);
	                break;

	            case "pagedown":
	                element.sendKeys(Keys.PAGE_DOWN);
	                break;

	            default:
	                System.out.println("Unsupported key : " + key);
	                return false;
	        }

	        return true;

	    } catch (Exception e) {

	        System.out.println("Unable to press key : " + key);
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
}
