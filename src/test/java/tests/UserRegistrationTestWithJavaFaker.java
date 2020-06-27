package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	//download javafaker library and paste the dependency in pom.xml (javafaker eli gaya mn Ruby)
	// take an object from Faker library
		Faker fakeData = new Faker();
		String firstname = fakeData.name().firstName();
		String lastname = fakeData.name().lastName();
		String email = fakeData.internet().emailAddress();
		String password = fakeData.number().digits(8).toString();		// toString di m3naha eni b2olo y7ot el 8 digits eli ana talbtaha di f string

	@Test(priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);	
		registerObject.userRegistration(firstname, lastname, email, password);
		System.out.println("the user data is: "+ firstname +", "+ lastname +", " + email +", " + password +", ");
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
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
