package automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndustryUsingDDT 
{
 public static void main(String[] args) throws Throwable
 {
	Random r=new Random();
	int ran = r.nextInt(1000);
	
	WebDriver driver=null;
	
	//step 1 read all the data
	/*read the data from the properity file*/
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\Common.properties");
   Properties p=new Properties();
   p.load(fisp);
   String BROWSER = p.getProperty("browser");
   String URL = p.getProperty("url");
  String USERNAME = p.getProperty("username");
  String PASSWORD = p.getProperty("password");
  
  /*read the data from excel sheet*/
  FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\exceladvsel.xlsx");
 Workbook wb = WorkbookFactory.create(fise);
 Sheet sheet = wb.getSheet("Organizations");
 String ORGNAME = sheet.getRow(4).getCell(2).getStringCellValue();
 String INDUSTRY = sheet.getRow(4).getCell(3).getStringCellValue();
 
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
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+ran);
		
		//Step 6: Select 'Chemicals' in industry Drop down
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(dropDown);
		sel.selectByValue(INDUSTRY);
		
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
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("sign out successfully done");
		
		//Step 10: Close the browser
		driver.quit();
 }
}
