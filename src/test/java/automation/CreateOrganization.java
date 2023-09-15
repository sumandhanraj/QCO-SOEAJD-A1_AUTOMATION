package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization 
{
public static void main(String[] args)
{
	//step 1 launch the browser
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println("browser is launched");
	
	//step 2 get the url
	   driver.get("http://localhost:8888/index.php");
	   
	   //step 3 login to application
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   System.out.println("login is successfull");
	   
	   //step 4 click on organization link
	   driver.findElement(By.linkText("Organizations")).click();
	   
	   //step 5 click on create org look up img
	   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	   
	   //step 6 enter org name
	   driver.findElement(By.name("accountname")).sendKeys("TechMaha");
	
	   //step 7 save
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	   //step 8 verify
	   String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains("TechMaha"))
		{
			System.out.println("passed");
			System.out.println(header);
		}
		else
		{
			System.out.println("failed");
		}
		
		//step 9  signout
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successfully");
		
		//step 10 close the browwser
		driver.quit();
	
	
	
}
}
