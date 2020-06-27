package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTest extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@Test(priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegisterationPage(driver);	
		registerObject.userRegistration("Yomna", "Saeed", "test14966999821312693666@gmail.com", "12345678");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})   //depends on 3shan law el method eli hia mo3tameda 3aleha failes yroo7 3amel l di skip badl fail
	public void registeredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void registeredUserCanLogin() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("yomnayomna@gmail.com", "yomnayomna");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
