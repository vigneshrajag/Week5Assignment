package assignment.testNG;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testNG.baseNEW.ProjectSpecificMethods;

public class DuplicateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		excelFileName = "TC003";
	}
	@Test(dataProvider = "namedata")
	public void duplicateLeadTC003(String phone) throws InterruptedException {
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phone);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Duplicate Lead").click();
		driver.findElementByName("submitButton").click();
		driver.close();
}
}






