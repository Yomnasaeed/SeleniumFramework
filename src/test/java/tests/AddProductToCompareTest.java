package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{
	
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	// 1- search for product number 1
	// 2- search for product number 2
	// 3- add to compare list
	// 4- clear compare list
	
	ProductDetailsPage detailsObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	
	@Test(priority=1)
	public void userCanCompareProducts() throws InterruptedException
	{
		Thread.sleep(3000);
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);
		
		Thread.sleep(3000);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(firstProductName));
		detailsObject.AddProductToCompare();
		
		
		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().contains(secondProductName));
		detailsObject.AddProductToCompare();
		Thread.sleep(2000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Apple MacBook Pro 13-inch"));
		//Assert.assertTrue(compareObject.firstProductName.isDisplayed());        //this is another way to assert
		Assert.assertTrue(compareObject.secondProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		//Assert.assertTrue(compareObject.secondProductName.isDisplayed());
		compareObject.compareProducts();
	}

	
	@Test(priority=2)
	public void userCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLbl.getText().contains("You have no items to compare."));
	}
}
