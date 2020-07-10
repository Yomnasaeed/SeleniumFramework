package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	@Given("^the user in the home page$")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
	   
	}

	@When("^I click on the regiter link$")
	public void i_click_on_the_regiter_link() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*@When("^I entererd the user data$")
	public void i_entererd_the_user_data()  {
	    registerObject = new UserRegisterationPage(driver);
	    registerObject.userRegistration("yomna", "yomna", "yomna33@test.com", "12345678");
	}*/

	
	@When("^I entererd \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void i_entererd(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegisterationPage(driver);
	    registerObject.userRegistration(firstname, lastname, email, password);
		

	}
	
	
	@Then("^The registration page displayed successfully$")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogout();
	}

}
