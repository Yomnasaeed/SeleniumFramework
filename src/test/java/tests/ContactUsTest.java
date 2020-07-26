package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

import java.net.URL;

public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage;
	
	String email = "test@test.com";
	String fullName = "test user";
	String enquiry = "Hello Admin, this is for test";
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Description("Contact us test case")
	@Link(name= "jira/aw ay esm ana 3aizah", url = "https://www.google.com/")
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
