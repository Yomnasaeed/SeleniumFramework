package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{
	
	HomePage homeObject;
	
	@Test
	public void userCanSelectSubCategoryFromMainMenu () throws InterruptedException
	{
		Thread.sleep(3000);
		homeObject = new HomePage(driver);
		Thread.sleep(2000);
		homeObject.selectNotebookMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
