package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static FileInputStream fis = null;
	
	public FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.xlsx";
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data not found, Terminating process !!  : check file path of test data");
			System.exit(0);
		}
		
		return fis;
	}

	
	// I musttt download POI dependency(because i am using xlsx file) from maven repository to be able to read the excel file (search google for poi apache maven then choose poi OOXML or choose poi then add -ooxml beside poi to be written this way in the pom.xml : <artifactId>poi-ooxml</artifactId>)
	public Object[][] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);		//XSSF library da lel xlsx extension, but if i have xls file then i will use HSSf library
		XSSFSheet sheet = wb.getSheetAt(0);		// 0 di eli hya index of 0 eli hya get sheet 1
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 4;
		
		//b3d kda ha3ml array a7ot feeha el total number of rows&cols 3shan fl a5er da eli haytla3li el object of 2 dimension array
		String[][] arrayExcelData = new String [TotalNumberOfRows][TotalNumberOfCols]; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) {
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		
		wb.close();
		return arrayExcelData;
	}
}
