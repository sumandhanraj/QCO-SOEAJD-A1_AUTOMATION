package TestingPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateingNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizatioInfoPage;
import ObjectRepository.OrganizationPage;
import automation.CreateContact;

public class TestPOMTest extends BaseClass
{
	@Test
public  void TestPOMTest()throws Throwable 
{
	//read data from excel
	 String ORGNAME = eutil.readDataFromExcelFile("Contacts", 4, 3)+jutil.randomNumber();
	// String INDUSTRY = eutil.readDataFromExcelFile("Organizations", 4, 3);
	 String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 2);

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
			Assert.assertTrue(ORGHEADER.contains(ORGNAME));
			System.out.println(ORGHEADER);
		
			//craete contact
			hm.clickOnContactsLink();
			
			//click on create contact lookup img
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnCreateContactLink();
			
			//enter the manadatory field
			CreateNewContactPage cncp = new CreateNewContactPage(driver);
			cncp.createContact(driver, LASTNAME, ORGNAME);
			
			//validate
			ContactInfoPage cip = new ContactInfoPage(driver);
			String CONTACTHEADER = cip.getContactHeaderText();
			Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
			System.out.println(CONTACTHEADER);
}
}
