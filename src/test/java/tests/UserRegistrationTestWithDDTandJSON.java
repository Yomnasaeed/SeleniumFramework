package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTestWithDDTandJSON extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	// Download JSON tools from Eclipse marketplace
	// create json file to write the data in it---downloading json tools will let the json file be understood as key, value for the data written in it
	// in the json file separate between the {} or block of data by comma
	
	@Test(priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//ha5od object mn el jsonDataReader class w lazem tb2a gowa el method(void) msh a7otaha global bara el void
		JsonDataReader jsonReader = new JsonDataReader();
		jsonReader.jsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);
		Thread.sleep(2000);
		registerObject.userRegistration(jsonReader.firstName , jsonReader.lastName, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		Thread.sleep(2000);
		registerObject.userLogout();
		Thread.sleep(2000);
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(2000);
		loginObject.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
