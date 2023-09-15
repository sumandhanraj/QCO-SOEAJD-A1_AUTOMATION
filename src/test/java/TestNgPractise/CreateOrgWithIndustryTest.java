package TestNgPractise;


	import java.io.FileInputStream;
	import java.time.Duration;
	import java.util.Properties;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
	import GenericUtilities.JavaUtility;
	import GenericUtilities.PropertyFileUtility;
	import GenericUtilities.WebDriverUtility;



public class CreateOrgWithIndustryTest 
	{
	@Test
	 public  void createOrgWithIndustry() throws Throwable 
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
		  
		  /*read the data from excel sheet*/
		  String ORGNAME = eutil.readDataFromExcelFile("Organizations", 4, 2)+jutil.randomNumber();
		 String INDUSTRY = eutil.readDataFromExcelFile("Organizations", 4, 3);
		 
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
				
				//Step 6: Select 'Chemicals' in industry Drop down
				WebElement dropDown = driver.findElement(By.name("industry"));
				wutil.handleDropDown(dropDown, INDUSTRY);
				
				//Step 7: Save 
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Validate
				String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println("PASS");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 9: Logout of App
				WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wutil.mouseHover(driver, mouseHover);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("sign out successfully done");
				
				//Step 10: Close the browser
				driver.quit();
	}
	}


