package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchPageUsingAutoSuggestTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void userCanSearchWithAutoSuggest()
	{
		searchObject = new SearchPage(driver);   //law nsiet a5od el object hna haydeeny null pointer exception
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
		
		//fi goz2 zyada howa 3amlo fl video maloosh lazma -- by7ot try w catch 3shan law 7asl error n3mlo handling--u can watch bardo :)
	}
	
}
