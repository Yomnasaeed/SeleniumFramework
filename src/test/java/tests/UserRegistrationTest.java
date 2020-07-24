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
	public void userCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegisterationPage(driver);	
		Thread.sleep(2000);
		registerObject.userRegistration("Yomna", "Saeed", "test222171231993393123665799@gmail.com", "12345678");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})   //depends on 3shan law el method eli hia mo3tameda 3aleha failes yroo7 3amel l di skip badl fail
	public void registeredUserCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanLogout"})
	public void registeredUserCanLogin() throws InterruptedException {
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.userLogin("test222171231993393123665799@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		Thread.sleep(2000);
		registerObject.userLogout();
	}
}
