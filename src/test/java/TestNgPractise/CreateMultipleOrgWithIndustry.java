package TestNgPractise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.CreateingNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizatioInfoPage;
import ObjectRepository.OrganizationPage;

public class CreateMultipleOrgWithIndustry 
{
	//read objects of all the utility
	JavaUtility jutil = new JavaUtility();
	 WebDriverUtility wutil = new WebDriverUtility();
	 PropertyFileUtility putil = new PropertyFileUtility();
	 ExcelFileUtility eutil = new ExcelFileUtility();
	 
	 
	 @Test(dataProvider = "getData")
	 public void createMultipleOrg(String ORG,String INDUSTRYTYPE) throws Throwable
	 {
		 WebDriver driver = null;
		 /*read the data from the properity file*/
			String BROWSER = putil.readDataFromPropertyFile("browser");
			String URL = putil.readDataFromPropertyFile("url");
		  String USERNAME = putil.readDataFromPropertyFile("username");
		  String PASSWORD = putil.readDataFromPropertyFile("password");
		  String ORGNAME = ORG+jutil.randomNumber();
		  
		 
		 //step 2 launch the browser
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
			 driver=new ChromeDriver();
			 System.out.println("chrome browser is launched");
		 }
		 else if(BROWSER.equalsIgnoreCase("edge"))
		 {
			 driver=new EdgeDriver();
			 System.out.println("edge browser is launched");
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver=new FirefoxDriver();
			 System.out.println("firefox browser is launched");
			
		 }
		 else
		 {
			 System.out.println("invalid browser");
		 }
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		 driver.get(URL);
		 
		  
		    //login to the application 
			LoginPage log=new LoginPage(driver);
			log.loginToApp(USERNAME, PASSWORD);
			
			//click on  organization link
			HomePage hm = new HomePage(driver);
			hm.clickOnOrganizationLink();
			
			//click on create organization lookup img
			OrganizationPage op  = new OrganizationPage(driver);
			op.clickOnCreateOrgLookUpImg();
			
			//create organization with industry
			CreateingNewOrganizationPage cnop  = new CreateingNewOrganizationPage(driver);
			cnop.CreateingNewOrganization(ORGNAME);
			
			//validate
			OrganizatioInfoPage oip = new OrganizatioInfoPage(driver);
			String ORGHEADER = oip.getHeaderText();
					if(ORGHEADER.contains(ORGNAME))
					{
						System.out.println("PASS");
						System.out.println(ORGHEADER);
					}
					else
					{
						System.out.println("FAIL");
					}
					
	//signout
	hm.logoutToApplication(driver);
	
	//close the browser
	driver.quit();
	 }
	 
	 @DataProvider 
	 public Object[][] getData() throws Throwable, IOException
	 {
		 Object[][] data =eutil.readMutlipleDataFromExcel("MutlipleData");
		return data;
	 }
}
