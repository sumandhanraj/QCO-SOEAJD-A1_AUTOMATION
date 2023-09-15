package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizatioInfoPage
{
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement orgHeader;

public OrganizatioInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getOrgHeader() {
	return orgHeader;
}

//business library
/**
 * this method will get orgHeader text
 * @return
 */
public String getHeaderText()
{
	return orgHeader.getText();
}
}
