package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(lDriver, this);
	}
	
	@FindBy (xpath="//input[@name='username']")
	WebElement username_textBoxField;
	@FindBy (xpath="//input[@name='password']")
	WebElement password_textBoxField;
	@FindBy (xpath="//button[text()=' Login ']")
	WebElement login_button;
	@FindBy (xpath="//p[@class='oxd-userdropdown-name']")
	WebElement user_dropdown;
	@FindBy (xpath="//a[text()='Logout']")
	WebElement logout_option;
	
	
	public void enterUserName(String userName)
	{
		username_textBoxField.clear();
		username_textBoxField.sendKeys(userName);
	}
	public void enterPassword(String password)
	{
		password_textBoxField.clear();
		password_textBoxField.sendKeys(password);
	}
	public void clickOnLoginBtn()
	{
		login_button.click();
	}
	public void clickOnLogoutBtn()
	{
		user_dropdown.click();
		logout_option.click();
	}

}
