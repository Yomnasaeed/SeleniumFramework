package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishListObject;
	
	
	@Test(priority = 1)
	public void userCanSearchWithAutoSuggest() throws InterruptedException
	{
		Thread.sleep(3000);
		searchObject = new SearchPage(driver);  
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productName);
	}
	
	@Test(priority = 2)
	public void userCanAddProductToWishList() throws InterruptedException
	{
		Thread.sleep(3000);
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishListObject = new WishListPage(driver);
		Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.ProductCell.getText().contains(productName));
	}
	

	@Test(priority = 3)
	public void userCanRemoveProductFromWishList() throws InterruptedException
	{
		Thread.sleep(3000);
		wishListObject = new WishListPage(driver);
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.emptyCartLbl.getText().contains("The wishlist is empty!"));
	}


}
