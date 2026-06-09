package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.BasePage;

public class HomePage extends BasePage {

	private By signupLoginBtn = By.xpath("//a[contains(text(),' Signup / Login')]");
	private By productBtn = By.xpath("//a[contains(text(),' Products')]");
	private By cartBtn = By.xpath("//a[contains(text(),'Cart')]");
	
	
	public HomePage(WebDriver driver) {
		super (driver);
	}
	
	
	public void clickSignInBtn()
	{
		verifyAndClick(signupLoginBtn);
	}
	
	public void clickOnProductBtn() {
		verifyAndClick(productBtn);
	}
}
