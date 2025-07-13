package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	
	public WebDriver ldriver;
	
	
	public PIMPage(WebDriver rdriver)
	
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
	@FindBy (xpath="//span[text()='PIM']")
	WebElement pim_BTN;
	@FindBy (xpath="//a[text()='Add Employee']")
	WebElement addEmployee_BTN;
	@FindBy (name="firstName")
	WebElement firstName_Field;
	@FindBy (name="lastName")
	WebElement lastName_Field;
	@FindBy (xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement employeeID_Field;
	@FindBy (xpath="//button[normalize-space()='Save']")
	WebElement save_BTN1;
	@FindBy (xpath="//input[@class='oxd-input oxd-input--active']")
	WebElement drivingLicenseNumber_field;
	@FindBy (xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
	WebElement save_BTN2;
	@FindBy (xpath="//div[@class='orangehrm-edit-employee-name']/h6")
	WebElement userName_Text;
	@FindBy (xpath="//a[normalize-space()='Employee List']")
	WebElement userList_BTN;
	@FindBy (xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement search_userId_field;
	@FindBy (xpath="//button[normalize-space()='Search']")
	WebElement search_userSearch_BTN;
	@FindBy (xpath="//div[@class='oxd-table-card']//div[2]//div[1]")
	WebElement first_matched_UserID;
	@FindBy (xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement search_userName_field;
	
	
	
	
	
	
	//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']
	public void clickOn_PIM_BTN()
	{
		pim_BTN.click();
	}
	public void clickOn_addUser_BTN()
	{
		addEmployee_BTN.click();
	}
	public void enter_firstName(String firstName)
	{
		firstName_Field.clear();
		firstName_Field.sendKeys(firstName);
	}
	public void enter_lastName(String lastName)
	{
		lastName_Field.clear();
		lastName_Field.sendKeys(lastName);
	}
	public void enter_employeeID(String employeeID)
	{
		
		employeeID_Field.sendKeys(employeeID);
	}
	
	public WebElement  get_employeeIDField()
	{
		
		return employeeID_Field;
	}
	public WebElement  get_firstNaneField()
	{
		
		return firstName_Field;
	}
	
	public void clickOn_firstSaveBTN()
	{
		save_BTN1.click();
	}
	public void enter_drivingLicense(String drivingLicense)
	{
		drivingLicenseNumber_field.clear();
		drivingLicenseNumber_field.sendKeys(drivingLicense);
	}
	public void clickOn_seconsSaveBTN()
	{
		save_BTN2.click();
	}
	public String getUserName()
	{
		String userName=userName_Text.getText();
		return userName;
	}
	
	
	public void clickOn_UserListBTN()
	{
		userList_BTN.click();	
	}
	public void enter_UserIDForSearch(String userID)
	{
		search_userId_field.sendKeys(userID);
	}
	public void enter_UserFirstNameForSearch(String userFirstName)
	{
		search_userName_field.sendKeys(userFirstName);
	}
	public void clickOn_UserSearchBTN() throws InterruptedException
	{
		Thread.sleep(2000);
		search_userSearch_BTN.click();
	}
	public String get_UserID()
	{
		String userID=first_matched_UserID.getText();
		return userID;
		
	}
	

}
