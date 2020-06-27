package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTestWithDDTandCSV extends TestBase{
	
	// for reading data from CSV we must download library from maven called openCSV and check tnat it is com.opencsv and paste the dependency in pom.xml
	// then i will take object from csvReader  //note that i dont make reader class for csv file however i implement everything in the test case
	
	CSVReader reader;
	
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws CsvValidationException, IOException, InterruptedException
	{
		// get path of CSV file
		String CSV_file = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		
		String[] csvCell;
		
		// while loop will be executed till the last value in csv file
		while((csvCell = reader.readNext()) != null)  
		{
			String firstName = csvCell[0];
			String lastName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			// el code da lazem a7oto gowa el while loop
			homeObject = new HomePage(driver);
			homeObject.openRegistrationPage();
			registerObject = new UserRegisterationPage(driver);
			Thread.sleep(2000);
			registerObject.userRegistration(firstName, lastName, email, password);
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
}
