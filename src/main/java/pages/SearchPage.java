package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productList;   //di list w da el ID bta3ha fa lazem a3ml import lel list
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	
	public void productSearch(String productName) {
		
		setTxtInElementTxt(searchTxtBox, productName);
		clickButton(searchBtn);
		
	}
	
	public void openProductDetailsPage() 
	{
		clickButton(productTitle);
	}
	
	public void ProductSearchUsingAutoSuggest(String searchTxt)
	{
		setTxtInElementTxt(searchTxtBox, searchTxt);
		
		try {
			Thread.sleep(3000);   //ha3mlo thread.sleep 3shan el list sa3at bta5od w2t 3la ma tezhar
		} catch (InterruptedException e) {
			e.printStackTrace();	
		}      
		
		productList.get(0).click(); 
		//fl 5atwtien eli fato dol ana k2ny katbt el searchTxt(eli howa el haktbo fl testcase "klmt mac" 3shan ydawr 3la mac) fl searchTxtBox w b3d kda 2olt lel productList (eli ana 3mltha fou2 enaha list of web elements) get awel e5tyar haytla3 (eli howa index of zero), l2n ana lama aktb klmt mac hala2eeh tala3ly e5tyar wa7ed bas w howa da eli ana 3ayzah
	}

}
