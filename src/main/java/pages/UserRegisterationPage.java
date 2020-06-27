package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class UserRegisterationPage extends PageBase {           //talama 3mlt inheretence l class gowaha constructor yb2a lazem a3ml inheret lel constructor m3aha w da b3mlo b eni adoos 3la el error w a5tar add constructor 

	public UserRegisterationPage(WebDriver driver) {
		super(driver);

		//b3d kda habd2 a find el elements w ashtaghal fl test cases
	}

	@FindBy(id="gender-male")
	WebElement genderRdoBtn;

	@FindBy(id="FirstName")
	WebElement fnTxtBox;

	@FindBy(id="LastName")
	WebElement lnTxtBox;

	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successMessage;		//ha3mlha public 3shan ashofha fl userRegisterationTest 3shan a3ml assertion

	@FindBy(css="a.ico-logout")
	public WebElement logoutLink;
	
	@FindBy(linkText="My account")
	public WebElement myAccountLink;



	public void userRegistration(String firstName, String lastName, String email, String password) 
	{
		clickButton(genderRdoBtn);			//genderRdoBtn.click();
		setTxtInElementTxt(fnTxtBox, firstName);		//fnTxtBox.sendKeys(firstName);
		setTxtInElementTxt(lnTxtBox, lastName);			//lnTxtBox.sendKeys(lastName);
		setTxtInElementTxt(emailTxtBox, email);			//emailTxtBox.sendKeys(email);
		setTxtInElementTxt(passwordTxtBox, password);			//passwordTxtBox.sendKeys(password);
		setTxtInElementTxt(confirmPasswordTxtBox, password);		//confirmPasswordTxtBox.sendKeys(password);
		clickButton(registerBtn);			//registerBtn.click();
	}

	public void userLogout() {
		clickButton(logoutLink);      //matnsesh t3mli el step di lama tigi t3mli el testcase eli b3daha eli hia el login, l2n ana kont b3ml registeration fa tabee3y i am logged in fa lazem a logout 3shan arga3 a log in
	}
	
	public void openMyAccountPage() {
		clickButton(myAccountLink);
	}
}

