package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;          //protected di bshofha 3la level el package kolaha
	public JavascriptExecutor jse;   // di 3shan el scrolling void
	public Select select;  //b5tar select li gaya mn selenium, w da 3shan h3ml method lel dropdown list zay ma 3mlt lel setText w el click 3shan ha7tagha kteer w a call el select di fl test case eli ana 3ayzaha b3d lama a5od mnha object
	public Actions actions;  //take care en a5tar Actions eli gaya mn selenium, w a5tar actions msh action, w msh h3mlaha initialize hna , h3mmlo fl home page, ana 7atetha fl page base hna 3shan hast5dmha kteer
	
	
	//create constructor
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);           //ba5tar initiElements(webdriver, object page)
	}

	
	// kol el methods eli gaya b3mlha lel hagat eli bst5dmha kteer zay el click, writing text, scrolling
	protected static void clickButton(WebElement button)
	{
		button.click();
	}

	protected static void setTxtInElementTxt(WebElement txtElement, String value)
	{
		txtElement.sendKeys(value);
	}

	public void scrollToButtom()  //el scrolling banfzo 3n taree2 el javascript fa lazem a call el interface di w da 3amlto fou2 w adeeha esm (eli howa jse zay mahowa maktoob kda)
	{
		jse.executeScript("scrollBy(0,2500)");  //da code fl javascript baktbo zay mahowa kda w by3mli scroll l a5er el page
	}
	
	public void clearText(WebElement element)
	{
		element.clear();
	}
	
}


