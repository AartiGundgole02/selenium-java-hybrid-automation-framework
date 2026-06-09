package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	
	}

	private By nameField = By.name("name");
	private By emailField = By.name("email");
	private By signupBtn = By.xpath("//button[contains(text(),'Signup')]");
	
	public void newUserSignup() {
		writeInput(nameField, "Aarti");
		writeInput(emailField, "max@gmail.com");
		verifyAndClick(signupBtn);
	}
}
