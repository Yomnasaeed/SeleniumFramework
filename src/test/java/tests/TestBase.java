package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;
	public static String downloadsPath = System.getProperty("user.dir")+"\\Downloads";
	
	
	public static ChromeOptions chromeOption()   //dont forget eni b add chromeOptions fl startDriver void m3 el object (see below)
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadsPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	
	public static FirefoxOptions fireFoxOption() 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadsPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		return option;
	}
	

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)   //@optional di m3naha en est5dm el "chrome aw 7asab mana katba eh" law ana b run el testcase isolated (y3ni b runha lwa7daha msh b runha mn el testNG.xml)  //optional di law msh mawgooda //optional di m3naha en law el value fl testNG fadya fa hia bt7ot nafsaha makan el browserName 
	{
		if (browserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver(chromeOption());    //chromeOption()---> el goz2 da zawdto b3d lama 7atiet void el download
		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver(fireFoxOption());     //fireFoxOption()---> el goz2 da zawdto b3d lama 7atiet void el download
		}
		
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	
	@AfterMethod
	public void screenshotOnFaliure(ITestResult result)               //h3ml method fl base lel screenshot 3shan kol ma method t fail yroo7 ya5od screenshot  
																		//ha7ot ITest result as a parameter 3shan howa eli bygbli el resultr mn el testNG
	
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking screenshot...");
			//w ha call el method eli 3mltha fl helper class w msh ha5od mnha object 3shan hia static
			Helper.CaptureScreenShot(driver, result.getName());   //result.getName()  --> di ba7otha badl el screenshot name, w el getName di btgbli esm el method eli 7asal fail feeha
		}
		
	}

}
