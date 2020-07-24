package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage;
	
	String email = "test@test.com";
	String fullName = "test user";
	String enquiry = "Hello Admin, this is for test";
	
	@Test
	public void userCanUseContactUs() throws InterruptedException
	{
		Thread.sleep(3000);
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}
}
