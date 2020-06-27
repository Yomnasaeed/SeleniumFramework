package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTestWithDDTandDataProvider extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name="testData")
	public static Object[][] userData() 
	{
		return new Object[][] {
			{"yomna","saeed","test1233rfffss964@gmail.com","123456"},{"ahmed","ali","test88fssr283eff288@gmail.com","123456"}};
	}
	
	
	
	@Test(priority = 1 , dataProvider="testData")
	public void userCanRegisterSuccessfully(String fName, String lName, String email, String password) throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		Thread.sleep(2000);
		registerObject = new UserRegisterationPage(driver);	
		registerObject.userRegistration(fName, lName, email, password);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		Thread.sleep(2000);
		registerObject.userLogout();
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.userLogin(email, password);
		Thread.sleep(2000);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
	
}
