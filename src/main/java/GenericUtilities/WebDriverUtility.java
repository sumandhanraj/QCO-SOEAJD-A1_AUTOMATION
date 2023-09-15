package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;



/**
 * this class consists of all the webDriver methods
 * @author ASUS
 *
 */
public class WebDriverUtility
{
	/**
	 * this method will maximize the wimdow
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * this method will minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}

/**
 * this methos will perform window full screen
 * @param driver
 */
public void windowFullScreen(WebDriver driver)
{
	driver.manage().window().fullscreen();
}

/**
 * this method will wait till page load
 * @param driver
 */
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

/**
 * this method will wait untill the element is visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisisble(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * this method will wait untill the element is clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
 * this metghod will handle the drop down using index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}

/**
 * this method will handle dropdown using value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element,String value)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}

/**
 * this method will handle dropdown using visible text
 * @param text
 * @param element
 */
public void handleDropDown(String text,WebElement element)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}

/**
 * this method will do mouse hover actions
 * @param driver
 * @param element
 */
 public void mouseHover(WebDriver driver,WebElement element) 
 {
	 Actions act = new Actions(driver);
	 act.moveToElement(element).perform();
 }
 
 /**
  * this method will perform right click anywhere on the page
  * @param driver
  */
 public void rightClickAction(WebDriver driver)
 {
	 Actions act = new Actions(driver);
	 act.contextClick().perform();
 }
 
 /**
  * this method will perform right click on a particular element
  * @param driver
  * @param element
  */
 public void rightClickAction(WebDriver driver,WebElement element)
 {
	 Actions act = new Actions(driver);
	 act.contextClick(element).perform();
 }
 
 /**
  * this method will perform double click anywhere on the webpage
  * @param driver
  */
 public void doubleClick(WebDriver driver)
 {
	 Actions act = new Actions(driver);
	 act.doubleClick().perform();
	 
 }
 
 /**
  * this method will perform double click on a particular element
  * @param driver
  * @param element
  */
 public void doubleClick(WebDriver driver,WebElement element)
 {
	 Actions act = new Actions(driver);
	 act.doubleClick(element).perform();
 }
 
 /**
  * this method will perform drag and drop operation
  * @param driver
  * @param src
  * @param desc
  */
 public void dragAndDrop(WebDriver driver,WebElement src,WebElement desc)
 {
	 Actions act = new Actions(driver);
	 act.dragAndDrop(src, desc).perform();
 }
 
 /**
  * this method will move the curser offset and click
  * @param driver
  * @param x
  * @param y
  */
 public void moveTheCurserAndClick(WebDriver driver,int x,int y)
 {
	 Actions act = new Actions(driver);
	 act.moveByOffset(x, y).perform();
 }
 /**
  * this method will perform scroll down by 500 units
  * @param driver
  */
  public void scrollAction(WebDriver driver)
  {
	  JavascriptExecutor js =  (JavascriptExecutor) driver;
	  js.executeScript("window.ScrollBy(0,500)", "");
  }
  
  /**
   * this method will scroll down untill particular element
   * @param driver
   * @param element
   */
  public void scrollAction(WebDriver driver,WebElement element)
  {
	  JavascriptExecutor js =  (JavascriptExecutor) driver;
	  js.executeScript("argument[0].ScrollIntoView();", element);
  }
  /**
   * this method will accept the alert popup
   * @param driver
   */
  public void acceptAlertPopUp(WebDriver driver)

  {
	driver.switchTo().alert().accept();  
  }
  /**
   * thismethod will dismiss the alert popup
   * @param driver
   */
  public void dismissAlertpopUp(WebDriver driver)
  {
	  driver.switchTo().alert().dismiss();
  }
  /**
   * this method will get text and return it to the caller
   * @param driver
   * @return
   */
  public String getAlertText(WebDriver driver)
  {
	 String text = driver.switchTo().alert().getText();
	 return text;
  }
  /**
   * this method will handle frames using index
   * @param driver
   * @param index
   */
  public void handleFrames(WebDriver driver,int index)
  {
	  driver.switchTo().frame(index);
  }
  /**
   * this method will handle frames using name or id
   * @param driver
   * @param nameOrId
   */
  public void handleFrames(WebDriver driver,String nameOrId)
  {
	  driver.switchTo().frame(nameOrId);
  }
  /**
   * this method will handle frames using element
   * @param driver
   * @param element
   */
  public void handleFrames(WebDriver driver,WebElement element)
  {
	  driver.switchTo().frame(element);
  }
 
  /**
   * this method will switch to immedeate parent window
   * @param driver
   */
  public void switchToParentId(WebDriver driver)
  {
	  driver.switchTo().parentFrame();
  }
  
  /**
   * this method will switch to default page
   * @param driver
   */
  public void switchToDefaultContent(WebDriver driver)
  {
	  driver.switchTo().defaultContent();
  }
  /**
   * this method will help the control to switch from one window to another
   * @param driver
   * @param partialWinTitle
   */
  public void switchToWindow(WebDriver driver,String partialWinTitle)
  {
	  //step 1 get the all window ids
	  Set<String> allwinIds = driver.getWindowHandles();
	  
	  //step 2 navigate through each window
	  for(String id:allwinIds)
	  {
		  //step 3 switch to each window and capture the title
		String actTitle = driver.switchTo().window(id).getTitle();
	
	  
	//step 4 compare the titkle with required
	  
	      if(actTitle.contains(partialWinTitle)) //true
	     {
		     break;
	     }
	  }
  
  }
 /**
  * This method will take screenshot
  * @param driver
  * @param screenShotName
  * @throws Throwable
  */
  public String captureScreenShot(WebDriver driver,String screenShotName) throws Throwable
  {
	  TakesScreenshot ts = (TakesScreenshot) driver;
	   File src = ts.getScreenshotAs(OutputType.FILE);
	   File dest = new File(".\\ScreenShots\\"+screenShotName+".png");
	  Files.copy(src, dest);
	  return dest.getAbsolutePath(); //used for extent reporting
  }
}
