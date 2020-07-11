package assignment.testNG;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.testNG.baseNEW.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setdata() {
		excelFileName="TC001";
	}
	
	@Test(dataProvider = "namedata")
	public void createLeadTC001(String CName, String Uname,String pwd, String phone) {
		System.out.println("Test Method Started");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(CName);
		driver.findElementById("createLeadForm_firstName").sendKeys(Uname);
		driver.findElementById("createLeadForm_lastName").sendKeys(pwd);
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(phone);
		driver.findElementByName("submitButton").click();
		System.out.println("Test Method Ended");
}
}






