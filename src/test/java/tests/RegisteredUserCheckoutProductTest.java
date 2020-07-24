package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class RegisteredUserCheckoutProductTest extends TestBase{
	
	/*
	 * 1- Registered User
	 * 2- Search for product
	 * 3- Add to cart
	 * 4- Checkout
	 * 5- Logout
	 */

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	
	@Test(priority=1)
	public void userCanRegisterSuccessfully() throws InterruptedException
	{
		Thread.sleep(3000);
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver);	
		Thread.sleep(3000);
		registerObject.userRegistration("Yomna", "Saeed", "test16613333332323866@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		
		searchObject = new SearchPage(driver);   //law nsiet a5od el object hna haydeeny null pointer exception
		Thread.sleep(3000);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	@Test(priority=3)
	public void userCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		detailsObject.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com"+ "/cart");
		Thread.sleep(3000);
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.TotalLbl.getText().contains("3,600"));
	}
	
	
	@Test(priority=4)
	public void userCanCheckoutProduct() throws InterruptedException
	{
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(3000);
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct("Egypt", "Cairo", "test address", "89899", "0100556699", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		Thread.sleep(3000);
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
		
		//Print invoice as PDF or print page
		checkoutObject.viewOrderDetails();
		orderObject = new OrderDetailsPage(driver);
		Thread.sleep(3000);
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	}
	
	
	@Test(priority=5)
	public void registeredUserCanLogout() throws InterruptedException
	{
		Thread.sleep(3000);
		registerObject.userLogout();
		
	}
}
