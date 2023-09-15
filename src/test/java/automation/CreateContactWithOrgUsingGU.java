package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;

public class CreateContactWithOrgUsingGU 
{
	@Test
public  void CreateContactWithOrgUsingGU()  throws Throwable
{

	//step 1 read all the data objects
	 JavaUtility jutil = new JavaUtility();
	 WebDriverUtility wutil = new WebDriverUtility();
	 PropertyFileUtility putil = new PropertyFileUtility();
	 ExcelFileUtility eutil = new ExcelFileUtility();
	 WebDriver driver = null;
	 
		/*read the data from the properity file*/
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
	  String USERNAME = putil.readDataFromPropertyFile("username");
	  String PASSWORD = putil.readDataFromPropertyFile("password");
	   
	  
	  /*read all the data from excel sheet*/
	  String LASTNAME = eutil.readDataFromExcelFile("Contacts", 4, 2);
	  String ORGNAME = eutil.readDataFromExcelFile("Contacts", 4, 3)+jutil.randomNumber();
	  
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
		 
		 //login to application
		//Step 2: Login To Application
	      driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		System.out.println("login to application is successfully");
				
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
		 
		 //Step 16: Logout of App
			WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.mouseHover(driver, mouseHover);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("sign out successfully done");
			
		//Step 17: Close the browser
			driver.quit();
	  
}
}
