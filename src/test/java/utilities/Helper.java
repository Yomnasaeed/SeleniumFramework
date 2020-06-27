package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	//Method to take screenshot when the test case fail
	public static void CaptureScreenShot(WebDriver driver, String screenshotName) 
	{
		// 1- i create the path
		// 2- i create the file w n create the directory bta3o 3n taree2 eni ageeb el parent aw el destination eli howa el path
		// 3- w b3d kda a3ml streaming mn el dest.toString
		// 4- w b3d kda b3ml write lel stream da w a2olo ya driver 5od el screenshot w get it as bytes
		// 5- w b3d kda a2fl el stream l2n law m2fltoosh hayfdal maftoo7
		
		Path dest = Paths.get("./Screenshots/", screenshotName + ".png");   //path di interface 3shan adeelo el path eli ha7ot feh el screenshot  //also not en el path eli 3la el right hand side plural
		try {
			Files.createDirectories(dest.getParent()); //files class tb2a gaya mn nafs el name space aw el library eli gaya mnha el path  //w lazem a7otha f try/catch
			FileOutputStream out = new FileOutputStream(dest.toString());  //hna bn3ml streaming mn el destination 3shan n save el image
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot" + e.getMessage());
		}   
		
	}

}
