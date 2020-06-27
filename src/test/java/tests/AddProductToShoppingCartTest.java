package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;

	@Test(priority=1)
	public void userCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	@Test(priority=2)
	public void userCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com"+ "/cart");
		Thread.sleep(2000);
		cartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(cartPage.TotalLbl.getText().contains("3,600"));
	}
	
	@Test(priority=3)
	public void userCanRemoveProductFromShoppingCart()
	{
		cartPage = new ShoppingCartPage(driver);
		cartPage.removeProductFromCart();
	}
	
}
