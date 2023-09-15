package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithEnergyAndCustomer
{
   public static void main(String[] args) 
   {
	
	   //step 1 launch the browser
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	   //step 2 get the url
	   driver.get("http://localhost:8888/index.php");
	   
	   //step 3 login to application
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   //step 4 click on organization link
	   driver.findElement(By.linkText("Organizations")).click();
	   
	   //step 5 click on create org look up img
	   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	   
	   //step 6 enter org name
	   driver.findElement(By.name("accountname")).sendKeys("Naksh");
	   
	   //step 7 select the industry dropdown
	  WebElement industryDrop = driver.findElement(By.name("industry"));
	   Select sel= new Select(industryDrop);
	   sel.selectByValue("Energy");
	   
	   //step 8 select type
	   WebElement typeDrop = driver.findElement(By.name("accounttype"));
	   Select sel1=new Select(typeDrop);
	   sel1.deselectByValue("Customer");
	   
	   //step 9 save
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	   //step 10 verify
	   String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains("wipro"))
		{
			System.out.println("passed");
			System.out.println(header);
		}
		else
		{
			System.out.println("failed");
		}
		
		//step 10  signout
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successfully");
		
		//step 11 close the browwser
		driver.quit();

   }
}
