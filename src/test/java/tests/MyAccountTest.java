package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456";
	String firstName = "yomna";
	String lastName = "saeed";
	String email = "test320912f317763692@gmail.com";
	

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		Thread.sleep(3000);
		homeObject.openRegistrationPage();

		registerObject = new UserRegisterationPage(driver);	
		Thread.sleep(3000);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() throws InterruptedException {

		myAccountObject = new MyAccountPage(driver);
		Thread.sleep(3000);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);   //3shan el step di 7atet fou2 variables as string for old and new password, badl ma kol shwaya a3'yrhom b edy
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
	}
	
	//b3d kda h3ml logout w a3ml login tani b el password el gdeeda 3shan at2kd
	//fa harga3 ageeb el testcases eli fl user registration test eli already 3amltaha
	
	@Test(priority = 3)   
	public void registeredUserCanLogout() throws InterruptedException {
		Thread.sleep(3000);
		registerObject.userLogout();
		Thread.sleep(3000);   //i did this step 3shan el net 3ndi kan batee2 fa maknsh byla2i el element, fa by3ml fail lel test case eli b3daha, w el a7san a7ot explicit wait
	}
	
	@Test(priority = 4)
	public void registeredUserCanLogin() throws InterruptedException {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		Thread.sleep(3000);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		driver.navigate().to("https://demo.nopcommerce.com/"); //3shan lama a run el suite.. el step di tsalm lel testcase eli b3daha
	}


}
