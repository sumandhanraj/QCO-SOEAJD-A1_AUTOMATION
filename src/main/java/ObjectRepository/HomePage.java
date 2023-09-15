package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility //rule 1 classname should b same as page name

{
//rule 2 udentify the locators
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLnk;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	
	
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}



	public WebElement getContactLnk() {
		return ContactLnk;
	}



	public WebElement getProductsLnk() {
		return ProductsLnk;
	}



	public WebElement getAdministratorLnk() {
		return AdministratorLnk;
	}



	public WebElement getSignOutBtn() {
		return SignOutLnk;
	}



	//rule 3 create comstructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//business logic
	/**
	 * this method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationLnk.click();
	}
	
	/**
	 * this meyhod will click on contact link
	 */
	public void clickOnContactsLink()
	{
		ContactLnk.click();
	}
	
	public void logoutToApplication(WebDriver driver)
	{
		mouseHover(driver, AdministratorLnk);
		SignOutLnk.click();
	}
}
