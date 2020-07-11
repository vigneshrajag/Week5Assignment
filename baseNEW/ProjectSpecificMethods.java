package com.leaftaps.testNG.baseNEW;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utility.ReadExcel;

public class ProjectSpecificMethods {
public static ChromeDriver driver;
public String excelFileName;
@Parameters({"url","uname","pwd",})
@BeforeMethod
	public void openApp(String URL,String userName , String password) {
		System.out.println("Before Method Started");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		
		System.out.println("Before Method Ended");
	}

@AfterMethod
public void closeApp(){
	System.out.println("After Method Started");
	driver.close();
	System.out.println("After Method Ended");
}

@DataProvider(name ="namedata")
public String[][] sendData () throws IOException {
	String[][] readArrayData = ReadExcel.readExcelValue(excelFileName);
	return readArrayData;
	
}
}
