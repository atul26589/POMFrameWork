package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;

//import org.apache.logging.log4j.core.util.FileUtils;

//import org.apache.logging.log4j.core.util.FileUtils;
import java.io.File;

import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.crm.qa.util.TestUtil;

public class Base {

	
	public static WebDriver driver;
	 public static Properties prop;
	
	public Base(){
		try{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Selenium\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch(FileNotFoundException e){
			
			e.printStackTrace();
		}
	}
	/*public void getScreenshot(String result) {
        // TODO Auto-generated method stub
        File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir=System.getProperty("user.dir");
        try {
                        FileUtils.copyFile(src, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        }
	}*/

	public static void intialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
			driver=new FirefoxDriver();
			
	}
		
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}
}
