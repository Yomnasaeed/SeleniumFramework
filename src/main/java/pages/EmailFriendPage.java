package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FriendEmail")
	private WebElement emailFriendTxt;
	
	@FindBy(id="PersonalMessage")
	private WebElement personalMessageTxt;
	
	@FindBy(css="input.button-1.send-email-a-friend-button")
	private WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	public WebElement MessageNotification;
	
	
	public void sendEmailToFriend(String friendEmail, String personalMessage)
	{
		setTxtInElementTxt(emailFriendTxt, friendEmail);
		setTxtInElementTxt(personalMessageTxt, personalMessage);
		clickButton(sendEmailBtn); 
	}
}
