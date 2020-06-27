package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;   //da el object eli 5adto lel javascriptexecuter eli 3rfto fl page base 3shan a3ml scrolling void (see video contact us section 11)
		actions = new Actions(driver);  //b3ml initialize lel actions hna eli 3mltlha define fl pagebase w b5tar el RHS actions eli feeha driver eli gaya mn selenium
	}
	
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy (linkText="Contact us")
	WebElement contactUsLink;
	
	@FindBy(id="customerCurrency")
	WebElement currencyDropList;
	
	@FindBy (linkText="Computers")
	WebElement computerMenu;
	
	@FindBy (linkText="Notebooks")
	WebElement NotebooksMenu;
	
	
	
	public void openRegistrationPage() 
	{
		clickButton(registerLink);          //registerLink.click();
	}
	
	public void openLoginPage() 
	{
		clickButton(LoginLink);
	}
	
	public void openContactUsPage() 
	{
		scrollToButtom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency()
	{
		select = new Select(currencyDropList);  //ba5od object mn el select class(eli hya bt3t el dropdownList) eli 3mltaha fl pagebase
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebookMenu()
	{
		actions.moveToElement(computerMenu).moveToElement(NotebooksMenu).click().build().perform();  //moveToElement di eli hya k2ny b3ml hoover
	}

}
