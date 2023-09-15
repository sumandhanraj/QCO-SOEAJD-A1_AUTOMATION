package automation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganization 
{
   public static void main(String[] args) throws Throwable
   { 
	   //step 1 launch the browser
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   //step 2 login to application
	   driver.get("http://localhost:8888/index.php");
	   
	   //step 3 login with valid credential
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   //step 4 click to contact link
	   driver.findElement(By.linkText("Contacts")).click();
	   
	   //step 5 click on look up img
	   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	   
	   //step 6 add data for mandatary fields
	   driver.findElement(By.name("lastname")).sendKeys("Dhanraj");
	   driver.findElement(By.xpath("//input[@name='account_name']/following-sibling:: img[@title='Select']")).click();
	   
	   //step 7 switch the control to child wimdow
	   String mainwinId = driver.getWindowHandle();
	   Set<String> allwinId = driver.getWindowHandles();
	   for(String Id:allwinId)
	   {
		   if(!Id.equals(mainwinId))
		   {
			   driver.switchTo().window(Id);
			   System.out.println("control switched to child");
		   }
	   }
	  
	//step 8 search for organization
	   driver.findElement(By.name("search_text")).sendKeys("xyz123");
	   driver.findElement(By.name("search")).click();
	   driver.findElement(By.xpath("//a[.='xyz123']")).click();
	   
	//step 9 switch back to main window
	   driver.switchTo().window(mainwinId);
	   
	//step 10 save 
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	  
	  //step 11 validate
	  String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if(ContactHeader.contains("Dhanraj"))
	   {
		   System.out.println("PASS");
		   System.out.println(ContactHeader);
	   }
	   else
	   {
		   System.out.println("FAIL");
	   }
	   
	   //step 12 signout
	   WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successfully");
	   
	   //step 13 close the browser
	   driver.quit();
	   
}
}
