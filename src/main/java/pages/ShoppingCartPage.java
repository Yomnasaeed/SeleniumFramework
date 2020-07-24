package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="removefromcart")
	WebElement removeCheck;
	
	@FindBy(name="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(id="itemquantity11215")
	public WebElement quantityTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement TotalLbl;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckBox;
	
	@FindBy(css="input.button-1.checkout-as-guest-button")
	WebElement CheckoutAsGuestBtn;
	
	
	public void removeProductFromCart()
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
	}
	
	public void updateProductQuantityInCart(String quantity)
	{
		//clear quantity textbox 
		clearText(quantityTxt);      // i used the method of clearing that i did in the test page base
		setTxtInElementTxt(quantityTxt, quantity);
		clickButton(updateCartBtn);
	}
	
	public void openCheckoutPage()
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
	}
	
	public void openCheckoutPageAsGuest() throws InterruptedException
	{
		clickButton(agreeCheckBox);
		clickButton(checkoutBtn);
		Thread.sleep(3000);
		clickButton(CheckoutAsGuestBtn);
	}
	
}
