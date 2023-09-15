package ContaCt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateContactWithOrgUsingGUTest extends BaseClass
{
	@Test(groups = "smokesuite")
public  void CreateContactWithOrgUsingGU()  throws Throwable
{

	  
	  /*read all the data from excel sheet*/
	  String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 2);
	  String ORGNAME = eutil.readDataFromExcelFile("Contacts", 4, 3)+jutil.randomNumber();
	  
	  
		 
		//Step 3: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
				
		//Step 4: Click On create Organization Look Up Image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				
		//Step 5: Create Organization with mandatory Information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 6: Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7: Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//thid will replace with hardassert
		/*if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}*/
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		//Assert.fail();//for screenshot we are failing the script
	    //step 8 click to contact link
		   driver.findElement(By.linkText("Contacts")).click();
		   
	 //step 9 click on look up img
		   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		   
		//step 10 add data for mandatary fields
		 driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling:: img[@title='Select']")).click();
		
		//step 11 switch to child window
		 wutil.switchToWindow(driver, "Accounts");
		 
		 //step 12 search for the organization
		 driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();

	  //step 13 switch back to parent window
		 wutil.switchToWindow(driver, "Contacts");
		 
		//step 14 save 
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  
		//step 15 validate
		  String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		  Assert.assertTrue(ContactHeader.contains(LASTNAME));
		  System.out.println(ContactHeader);
		
	
}
	  
	/*@Test
	public void demo()
	{
		System.out.println("hi");
	}*/
			
			
}

