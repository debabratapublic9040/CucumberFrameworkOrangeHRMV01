package StepDefination;

import java.awt.Robot;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.*;
import PageObject.LoginPage;
import PageObject.PIMPage;
import Utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public PIMPage pmiPage;
	public Actions act;
	public Robot robot;
	public static Logger log;
	public ReadConfig readConfig;
	
	public String genarateUserID()
	{
		return RandomStringUtils.randomAlphanumeric(5);
	}

}
