package steps;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckoutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase{
	
	String productname = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	
	@Given("^user is on Home page$")
	public void user_is_on_Home_page()  {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1) {
		searchObject = new SearchPage(driver);   
		searchObject.ProductSearchUsingAutoSuggest("Mac");
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(), productname);
	}

	@When("^choose to buy two items$")
	public void choose_to_buy_two_items()  {
		cartPage = new ShoppingCartPage(driver);
		detailsObject.AddToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	    
	}
	
	
	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order()  {
		checkoutObject = new CheckoutPage(driver);
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct("Egypt", "Cairo", "test address", "89899", "0100556699", productname);
		Assert.assertTrue(checkoutObject.productName.isDisplayed());
		Assert.assertTrue(checkoutObject.productName.getText().contains(productname));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYouLbl.isDisplayed());
		
		
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() {
		checkoutObject.viewOrderDetails();
		orderObject = new OrderDetailsPage(driver);
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
	    
	}

}
