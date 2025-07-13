package StepDefination;

import io.cucumber.java.en.Then;

public class stepClose extends BaseClass{

	
	@Then("close browser")
	public void close_browser() {
		log.info("************Close the tab***********");
		//driver.close();
		driver.quit();
	}
	
}
