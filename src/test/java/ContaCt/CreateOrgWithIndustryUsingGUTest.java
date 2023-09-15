package ContaCt;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
@Listeners(GenericUtilities.ListenerImplementation.class)
public class CreateOrgWithIndustryUsingGUTest extends BaseClass
{
	@Test(groups = "RegressionSuite")
	
 public  void CreateOrgWithIndustryUsingGU()  throws Throwable 
{
	  /*read the data from excel sheet*/
	  String ORGNAME = eutil.readDataFromExcelFile("Organizations", 4, 2)+jutil.randomNumber();
	 String INDUSTRY = eutil.readDataFromExcelFile("Organizations", 4, 3);
	 
	 
	 
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
	     	Assert.assertTrue(orgHeader.contains(ORGNAME));
	    	System.out.println(orgHeader);
			
		
}
}
