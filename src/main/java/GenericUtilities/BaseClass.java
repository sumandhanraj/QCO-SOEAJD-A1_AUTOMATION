package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass
{
	public PropertyFileUtility putil = new PropertyFileUtility();
	public WebDriverUtility wutil  = new WebDriverUtility();
	public ExcelFileUtility eutil = new ExcelFileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("=======Database connection=====");
	}
	
	//@Parameters("browser")
	//@BeforeTest
     @BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		sdriver=driver;
		System.out.println(BROWSER+"===========browser is launched====");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = putil.readDataFromPropertyFile("username");
	    String PASSWORD = putil.readDataFromPropertyFile("password");
	  LoginPage lp = new LoginPage(driver);
	  lp.loginToApp(USERNAME, PASSWORD);
	  System.out.println("login is successful");
	}
	 
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
      HomePage hp = new HomePage(driver);
	    hp.logoutToApplication(driver);
	    System.out.println("logout is successfull");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfif()
	{
		driver.quit();
		System.out.println("===browser is cloased====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("==========Database closed========");
	}
}
