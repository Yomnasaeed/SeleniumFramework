package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	@Test(priority=1)
	public void userCanChangeCurrency() throws InterruptedException
	{
		Thread.sleep(4000);
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
	}
	
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		Thread.sleep(3000);
		searchObject = new SearchPage(driver);   
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
		//Assert.assertTrue(detailsObject.ProductPriceLbl.getText().contains("Ђ"));
		System.out.println(detailsObject.ProductPriceLbl.getText());
	}
}
