package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage//rule1 class name should b same as page name
{
	//ruke 2 identify the locators
@FindBy(xpath = "//img[@alt=\"Create Organization...\"]")
private WebElement createOrgLookUpImg;

public OrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//create the constructoe
public WebElement getCreateOrgLookUpImg() {
	return createOrgLookUpImg;
}

//business libray
/**
 * this method will click on create img look up img
 */
public void clickOnCreateOrgLookUpImg()
{
	createOrgLookUpImg.click();
}

}
