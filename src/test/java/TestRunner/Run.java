package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)// Not required post adding the testNG dependencies
@CucumberOptions(
		//features=".\\Feature\\002AddEmployee.feature",               //To run a specific feature files
		//features=".\\Feature",                                       //To run all feature files
		features={".\\Feature\\001LoginTest.feature",".\\Feature\\002AddEmployee.feature"},//To run multiple specific feature files
		
		glue="StepDefination",
		dryRun=false,
		monochrome=true,
		
		//tags="@Smoke",
		//tags="@DDT",
		tags="@e2e",                       //To run only Sanity tests
		//tags="@Sanity or @Regression",        //To run Sanity and Regression both tests
		//tags="@Sanity and @Regression",       //To run only tests which have both Sanity and Regression tags
		//tags="@Regression and not @Sanity",   //To run only tests which have both tags Sanity tests but wants to run only sanity tests
		
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin= {"pretty","html:target/Cucumber-reports/html_report.html"}      //Generate html report
		//plugin= {"pretty","junit:target/Cucumber-reports/xml_report.xml"}     //Generate xml report
		//plugin= {"pretty","json:target/Cucumber-reports/json_report.json"}    //Generate json report
		//plugin= {"pretty","html:target/Cucumber-reports/html_report.html","junit:target/Cucumber-reports/xml_report.xml","json:target/Cucumber-reports/json_report.json"}//Generate html,xml & json report
		)
public class Run extends AbstractTestNGCucumberTests{
	
	//this class will be empty

}
