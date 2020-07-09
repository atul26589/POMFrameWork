package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

 import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.crm.qa.base.Base;

public class TestUtil extends Base {
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	
	public void switchToFrame(){
	driver.switchTo().frame("mainpanel");
	
	}
	public static String TEST_DATA_SHEETPATH="D:\\Selenium\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_TestData.xlsx";
static Workbook book;
static Sheet sheet;

public static Object[][] getTestData(String sheetName) throws InvalidFormatException{
	FileInputStream file=null;
	try {
		file=new FileInputStream(TEST_DATA_SHEETPATH);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try{
		book=WorkbookFactory.create(file);
	}catch(IOException e){
		e.printStackTrace();
		
	}
	sheet=book.getSheet(sheetName);
	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++){
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	
}
public static void takeScreenshotAtEndOfTest() throws IOException {
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

}
}
