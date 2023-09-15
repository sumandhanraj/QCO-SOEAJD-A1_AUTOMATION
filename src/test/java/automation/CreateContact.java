package automation;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact
{
public static void main(String[] args) 
{
      Random rad = new Random();
      int ra = rad.nextInt(1000);
	//step 1 launch the browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println("browser is launched");
	
	//step 2 get url
	driver.get("http://localhost:8888/index.php");
	
	//step 3 login to the application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   System.out.println("login is succesfull");
	   
	//step 4 click to contact link
	   driver.findElement(By.linkText("Contacts")).click();
	   
	//step 5 click to lookup img
	   driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	   
	//step 6 input manadatory fields
	   driver.findElement(By.name("lastname")).sendKeys("Nihaan"+ra);
	   
	 //step 7 save
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	//step 8 verify
	   String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if(ContactHeader.contains("Nihaan"))
	   {
		   System.out.println("PASS");
		   System.out.println(ContactHeader);
	   }
	   else
	   {
		   System.out.println("FAIL");
	   }
	//step 9 logout
	   WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successfully");
		
	//step 10 close browser
		driver.quit();
}
}
