package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutProductFromCartTest extends TestBase{
	
	HomePage homeObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test(priority=1)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		Thread.sleep(3000);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	@Test(priority=2)
	public void userCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com"+ "/cart");
		Thread.sleep(3000);
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.TotalLbl.getText().contains("3,600"));
	}
	
	@Test(priority=3)
	public void userCanCheckoutProduct() throws InterruptedException
	{
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(3000);
		cartPage.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct("test", "user", "test1234359@test.com", "Egypt", "Cairo", "test address", "89899", "0100556699", productName);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
	}

	
	@Test(priority=4)
	public void userCanViewOrderDetails() throws InterruptedException
	{
		orderObject = new OrderDetailsPage(driver);
		Thread.sleep(3000);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		Thread.sleep(3000);
		orderObject.PrintOrderDetails();
	}
	
}
