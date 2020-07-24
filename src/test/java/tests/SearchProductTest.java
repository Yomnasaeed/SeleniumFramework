package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void userCanSearchForProducts() throws InterruptedException {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		Thread.sleep(3000);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));     //haroo7 a3ml productDetailsPage class w a7ot feh details ay product ha7tag b3d kda a3mlo assertion
		//Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);  //di taree2a tanya lel asssertion
	}

}
