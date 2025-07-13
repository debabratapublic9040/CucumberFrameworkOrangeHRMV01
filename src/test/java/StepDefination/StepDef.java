package StepDefination;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.LoginPage;
import PageObject.PIMPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import io.cucumber.java.en.*;//this is used for all import at one go
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass {

	public String browser;

	@Before(order=0)//We can add multiple  before methods in the script and it will run based on the order and if order is not there then it will execute based on alphabets order.
	public void setup1()
	{
		log=LogManager.getLogger("StepDef");
		//log=LogManager.getLogger(this.getClass());
		//log=LogManager.getLogger(StepDef.class);
		//System.out.println("Setup1() method executed");
		log.info("************Open the Browser***********");
		readConfig=new ReadConfig();
		browser=readConfig.getBrowser();
		System.out.println(browser);
		
		switch (browser.toLowerCase()){
		
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			driver=null;
			System.out.println("Invalid browser, please check the url");
			break;
		}
		
	}
	
	@Before(order=1)//First setup1() method will execute then setup2() will execute, this is not compulsory we can add in one method also.
	public void setup2()
	{
		//System.out.println("Setup2() method executed");
		log.info("************Maximize the Browser***********");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		
	}
	
	/*@Before("@Smoke")// We can add Before setup() for a particular group of test scenarios and that method will execute particular scenarios.
	public void setup()// We can also add other tags also like e2e, Sanity
	{
		System.out.println("Setup1() method executed");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		
	}*/
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() throws AWTException {
		loginPage = new LoginPage(driver);
		pmiPage = new PIMPage(driver);
		act = new Actions(driver);
		robot=new Robot();
				
	}

	@When("User opens URL {string}")
	public void user_opens_url(String appUrl) throws InterruptedException {
		
		try{
			log.info("************Launch the OrangeHRM url***********");
			driver.get(appUrl);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@When("User enters UserName as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		try{
			log.info("************Enter the Username***********");
			loginPage.enterUserName(username);
			log.info("************Enter the password***********");
			loginPage.enterPassword(password);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		
		try{
			log.info("************Click on login button***********");
			loginPage.clickOnLoginBtn();
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
		
	}

	@Then("Dashboard Page should be displayed and the Title should be {string}")
	public void dashboard_page_should_be_displayed_and_the_title_should_be(String ExpectedPageTitle) throws InterruptedException {
		String actualTitle = driver.getTitle();
		log.info("************Verify the Dashboard page title***********");
		if (actualTitle.equals(ExpectedPageTitle)) {
			log.info("************Title Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************Title did not Matched***********");
			Assert.fail();
		}
		
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		
		try{
			log.info("************Click on logout button***********");
			loginPage.clickOnLogoutBtn();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@Then("Login Page Title should be {string}")
	public void login_page_title_should_be(String ExpectedPageTitle) {
		log.info("************Verify the login page title***********");
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(ExpectedPageTitle)) {
			log.info("************Title Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************Title did not Matched***********");
			Assert.assertTrue(false);
		}

	}



	/////////////////////Add Employee Method///////////////////////////

	@When("User click on PMI Menu")
	public void user_click_on_pmi_menu() {
		
		try{
			log.info("************Click on PIM button***********");

			pmiPage.clickOn_PIM_BTN();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@When("click on Add Employee")
	public void click_on_add_employee() {
		
		try{
			log.info("************Click on AddUser button***********");
			pmiPage.clickOn_addUser_BTN();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@Then("Add Employee Page should be displayed and the Title should be {string}")
	public void add_employee_page_should_be_displayed_and_the_title_should_be(String ExpectedPageTitle) {
		String actualTitle = driver.getTitle();
		log.info("************Verify the PIM page title***********");
		if (actualTitle.equals(ExpectedPageTitle)) {
			log.info("************Title Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************Title did not Matched***********");
			Assert.fail();
		}
	}

	@When("Add Employee details")
	public void add_employee_details() {
		
		try{
			log.info("************Enter the First Name***********");
			pmiPage.enter_firstName(readConfig.getUserData());
			log.info("************Enter the Lat Name***********");
			pmiPage.enter_lastName(readConfig.getUserData());
			pmiPage.get_employeeIDField().click();
			//Action Class
//			act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
//			act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
//			act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
//			act.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
			//Robot Class
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
	        robot.keyRelease(KeyEvent.VK_A);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_BACK_SPACE);
	        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	        
			pmiPage.get_firstNaneField().click();
			log.info("************Enter the Employee ID***********");
			pmiPage.enter_employeeID(readConfig.getUserData());
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@When("Click on save first button")
	public void click_on_save_first_button() throws InterruptedException {
		
		try{
			log.info("************Click on save1 button***********");
			pmiPage.clickOn_firstSaveBTN();
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@Then("User Details page should be displayed and the Title should be {string}")
	public void user_details_page_should_be_displayed_and_the_title_should_be(String ExpectedPageTitle) {
		String actualTitle = driver.getTitle();
		log.info("************Verify the PIM page title***********");
		if (actualTitle.equals(ExpectedPageTitle)) {
			log.info("************Title Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************Title did not Matched***********");
			Assert.fail();
		}
	}

	@When("User enter DrivingLicenceNumber")
	public void user_enter_driving_licence_number() {
		
		try{
			log.info("************Enter the User Driving Licence Number***********");
			pmiPage.enter_drivingLicense(readConfig.getUserData());
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@When("Click on save second button")
	public void click_on_save_second_button() throws InterruptedException {
		
		try{
			log.info("************Click on save2 button***********");
			pmiPage.clickOn_seconsSaveBTN();
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}

	}

	@Then("Verify the Username in Personal Details page")
	public void verify_the_username_in_personal_details_page() {
		String actualUserName = pmiPage.getUserName();
		log.info("************Verify the PIM page title***********");
		if (actualUserName.equals(readConfig.getUserData() + " " + readConfig.getUserData())) {
			Assert.assertTrue(true);
			log.info("************Username Matched***********");
		} else {
			log.warn("************User Name did not Matched***********");
			Assert.assertTrue(false);
		}
	}

	////////////////Search added employee through id///////////////////

	@When("click on Employee List")
	public void click_on_employee_list() {
		
		try{
			log.info("************Click on user List button***********");
			pmiPage.clickOn_UserListBTN();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@Then("Employee List page should be displayed and the Title should be {string}")
	public void employee_list_page_should_be_displayed_and_the_title_should_be(String ExpectedPageTitle) {
		String actualTitle = driver.getTitle();
		log.info("************Verify the PIM page title***********");
		if (actualTitle.equals(ExpectedPageTitle)) {
			log.info("************Title Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************Title did not Matched***********");
			Assert.fail();
		}
	}

	@When("Search employee by employee id")
	public void search_employee_by_employee_id() throws InterruptedException {
		
		try{
			Thread.sleep(1000);
			log.info("************Enter the user id for search***********");
			pmiPage.enter_UserIDForSearch(readConfig.getUserData());
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		
		try{
			log.info("************Click on the search button***********");
			pmiPage.clickOn_UserSearchBTN();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}

	@Then("Added user should be displayed")
	public void added_user_should_be_displayed() {
		String actualUserID = pmiPage.get_UserID();
		log.info("************Verify the User ID***********");

		if (actualUserID.equals(readConfig.getUserData())) {
			log.info("************User ID Matched***********");
			Assert.assertTrue(true);
		} else {
			log.warn("************User ID did not Matched***********");
			Assert.fail();
		}

	}
	
////////////////Search added employee through first name///////////////////
	
	@When("Search employee by first name")
	public void search_employee_by_first_name() {
		
	    try{
	    	log.info("************Enter the user first name for search***********");
		    pmiPage.enter_UserFirstNameForSearch(readConfig.getUserData());
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			Assert.fail();
		}
	}
	
	@After(order=2)//(We can add multiple after method in the script)//We have commented this because we want to take screenshot after each steps, so added screenshot method in afteStep tag.
	public void tearDown1(Scenario sc)//For now this method is not required because we are closing browser through feature file steps 
	{
		//System.out.println("TearDown1() method executed");
		/*String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		if(sc.isFailed()==true)
		{
			String filePath="C:\\Workspace\\Workspace22052025\\MyCucumberProjectV01\\Screenshot\\Failed_Screenshot"+timeStamp+".png";
			TakesScreenshot ts=((TakesScreenshot)driver);
			File source=ts.getScreenshotAs(OutputType.FILE);
			File destination=new File(filePath);
			try {
				FileUtils.copyFile(source, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		log.info("************Close the entire browser***********");
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media type, name of the attachment)
		scenario.attach(screenshot,"image/png",scenario.getName());
		}
	}
	
	/*@After(order=1)//Here the flow will work in reverse order  first TearDown2() method and then TearDown1()
	public void tearDown2()
	{
		System.out.println("TearDown2() method executed");
		driver.quit();
	}
	@AfterStep
	public void afterStep()
	{
		System.out.println("afterStep() method executed");
		
	}
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("beforeStep() method executed");
		
	}*/
	

}
