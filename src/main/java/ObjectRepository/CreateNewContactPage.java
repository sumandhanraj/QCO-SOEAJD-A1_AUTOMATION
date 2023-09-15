package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
@FindBy(name = "lastname")
private WebElement lastNameTxt;

@FindBy(xpath = "//input[@name='account_name']/following-sibling:: img[@title='Select']")
private WebElement contactWithOrgTxt;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "search_text")
private WebElement orgSeacrhEdt;
 
@FindBy(name = "search")
private WebElement orgSearchBtn;

public CreateNewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getLastNameTxt() {
	return lastNameTxt;
}

public WebElement getContactWithOrgTxt() {
	return contactWithOrgTxt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getOrgSeacrhEdt() {
	return orgSeacrhEdt;
}

public WebElement getOrgSearchBtn() {
	return orgSearchBtn;
}

//business library
/**
 * this method will create a new contact
 * @param LASTNAME
 */
public void createContact(String LASTNAME)
{
	lastNameTxt.sendKeys(LASTNAME);
	saveBtn.click();
}
 /**
  * this method will create contact with organization
  * @param driver
  * @param LASTNAME
  * @param ORGNAME
  */
public void createContact(WebDriver driver,String LASTNAME,String ORGNAME)
{
	lastNameTxt.sendKeys(LASTNAME);
	contactWithOrgTxt.click();
	switchToWindow(driver, "Accounts");
	orgSeacrhEdt.sendKeys(ORGNAME);
	orgSearchBtn.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();//dynamic xpath
	switchToWindow(driver, "Contacts");
	saveBtn.click();
}
}
