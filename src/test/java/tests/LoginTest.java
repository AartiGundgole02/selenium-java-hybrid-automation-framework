package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{
@Test
public void verifyNavigationToLoginPage() {
	HomePage home = new HomePage(driver);
	home.clickSignInBtn();
	Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	LoginPage login = new LoginPage(driver);
	login.newUserSignup();
}
	


}
