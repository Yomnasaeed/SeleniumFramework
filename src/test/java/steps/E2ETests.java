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
	
	SearchPage searchPage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutPage;
	OrderDetailsPage orderPage;
	String productName = "Apple MacBook Pro 13-inch";

	@Given("^user is on Home page$")
	public void user_is_on_Home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1) {
		searchPage = new SearchPage(driver);
		searchPage.ProductSearchUsingAutoSuggest(productName);
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNameBreadCrumb.getText().contains(productName));
	}

	@When("^choose to buy two items$")
	public void choose_to_buy_two_items() throws InterruptedException  {
		cartPage = new ShoppingCartPage(driver);
		productDetails.AddToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Thread.sleep(3000);
	}

	@When("^moves to checkout cart and enter personal details on checkout page and place the order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutPage = new CheckoutPage(driver);
		cartPage.openCheckoutPageAsGuest();
		checkoutPage.CheckoutProduct("test", "user", "test11@test.com", "Egypt", "Cairo", "123Street", "11311", "0100656656", productName);
		Assert.assertTrue(checkoutPage.productName.isDisplayed());
		Assert.assertTrue(checkoutPage.productName.getText().contains(productName));
		checkoutPage.confirmOrder();
		Assert.assertTrue(checkoutPage.ThankYouLbl.isDisplayed());
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws InterruptedException  {
		orderPage = new OrderDetailsPage(driver);
		checkoutPage.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderPage.DownloadPDFInvoice();
	}

}
