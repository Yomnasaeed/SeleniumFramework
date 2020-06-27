package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement productNameBreadCrumb;
	
	
	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(css="span.price-value-4")
	public WebElement ProductPriceLbl;
	
	@FindBy(linkText="Add your review")
	WebElement AddReviewLink;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id="add-to-cart-button-4")
	WebElement AddToCartBtn;
	
	
	
	public void openSendEmail() {
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(AddReviewLink);
	}
	
	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void AddProductToCompare()
	{
		clickButton(addToCompareBtn);
	}
	
	public void AddToCart()
	{
		clickButton(AddToCartBtn);
	}
}
