package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fnTxt;

	@FindBy(id="BillingNewAddress_LastName")
	WebElement lnTxt;

	@FindBy(id="BillingNewAddress_Email")
	WebElement emailTxt;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id="BillingNewAddress_City")
	WebElement cityTxt;

	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressTxt;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCodeTxt;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneTxt;

	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;

	@FindBy(id="shippingoption_1")
	WebElement shippingMethodRdo;

	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueShippingBtn;

	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuePaymentBtn;

	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueInfoBtn;

	@FindBy(css="a.product-name")
	public WebElement productName;

	@FindBy(css="input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(css="h1")
	public WebElement ThankYouLbl;

	@FindBy(css="div.title")
	public WebElement successMessage;

	@FindBy(linkText="Click here for order details.")
	public WebElement orderDetailsLink;



	public void RegisteredUserCheckoutProduct (String countryName, String cityName, String addressName, 
			String postalCode, String phone, String productName) throws InterruptedException
	{
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTxtInElementTxt(cityTxt, cityName);
		setTxtInElementTxt(addressTxt, addressName);
		setTxtInElementTxt(postalCodeTxt, postalCode);
		setTxtInElementTxt(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);	
	}
	
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	
	public void viewOrderDetails ()
	{
		clickButton(orderDetailsLink);
	}
	
	public void CheckoutProduct (String firstName, String lastName, String email, String countryName, String cityName, String addressName, 
			String postalCode, String phone, String productName) throws InterruptedException
	{
		setTxtInElementTxt(fnTxt, firstName);
		setTxtInElementTxt(lnTxt, lastName);
		setTxtInElementTxt(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTxtInElementTxt(cityTxt, cityName);
		setTxtInElementTxt(addressTxt, addressName);
		setTxtInElementTxt(postalCodeTxt, postalCode);
		setTxtInElementTxt(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);	
	}
}
