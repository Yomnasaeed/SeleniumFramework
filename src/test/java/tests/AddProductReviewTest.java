package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase{
	
	
	/*
	* 1- User Registration
	* 2- Search for Product
	* 3- Add review
	* 4- logout
	*/
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;
	
	//1- User registration
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws InterruptedException
	{
		Thread.sleep(3000);
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegisterationPage(driver);	
		Thread.sleep(2000);
		registerObject.userRegistration("Yomna", "Saeed", "test133224969965312554693666@gmail.com", "12345678");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	
	//2- Search for product
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		Thread.sleep(2000);
		searchObject = new SearchPage(driver);  
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	//3- Add Review
	@Test(priority = 3)
	public void RegisteredUserCanAddReview()
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("new review", "The product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is successfully added."));
		
	}
	
	//4- User Logout
	@Test(priority=4)
	public void registeredUserCanLogout() throws InterruptedException {
		Thread.sleep(2000);
		registerObject.userLogout();
	}

}
