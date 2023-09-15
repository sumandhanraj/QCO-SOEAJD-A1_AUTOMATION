package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateingNewOrganizationPage extends WebDriverUtility
{
@FindBy(name = "accountname")
private WebElement orgNameTxt;

@FindBy(name = "industry")
private WebElement industryDropDown;
 
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

//create constructer
public CreateingNewOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//getters
public WebElement getOrgNameTxt() {
	return orgNameTxt;
}

public WebElement getIndustryDropDown() {
	return industryDropDown;
}


 //business library
/**
 * this method will create orgname
 * @param ORGNAME
 */
public void CreateingNewOrganization(String ORGNAME)
{
	orgNameTxt.sendKeys(ORGNAME);
	saveBtn.click();
}
 /**
  * this method will create org name woith industry
  * @param ORGNAME
  * @param INDUSTRY
  */
public void CreateingNewOrganization(String ORGNAME,String INDUSTRY)
{
	orgNameTxt.sendKeys(ORGNAME);
	handleDropDown(industryDropDown, INDUSTRY);
	saveBtn.click();
}
}
