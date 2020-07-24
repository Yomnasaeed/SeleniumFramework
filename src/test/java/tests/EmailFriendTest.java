package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	
	//1- User registration
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws InterruptedException
	{
		Thread.sleep(3000);
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegisterationPage(driver);	
		Thread.sleep(3000);
		registerObject.userRegistration("Yomna", "Saeed", "test13349669692411698713666@gmail.com", "12345678");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	//2- Search for product
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);  
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	//3- Email to friend
	@Test(priority = 3)
	public void RegisteredUserCanSendProductToFriend() throws InterruptedException
	{
		detailsObject.openSendEmail();
		emailObject = new EmailFriendPage(driver);
		Thread.sleep(2000);
		emailObject.sendEmailToFriend("aaa@test.com", "Hello my friend, check this product");
		Assert.assertTrue(emailObject.MessageNotification.getText().contains("Your message has been sent."));
		
	}
	
	//4- User Logout
	@Test(priority=4)
	public void registeredUserCanLogout() {
		registerObject.userLogout();
	}

}
