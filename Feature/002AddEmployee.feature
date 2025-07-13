Feature: AddEmployee

Background: Common steps for all scenarios

 	Given User Launch Chrome browser 
	When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "admin123" 
	And Click on Login 
	Then Dashboard Page should be displayed and the Title should be "OrangeHRM" 

@Regression @Sanity @e2e 
Scenario: Add new employee
	
	When User click on PMI Menu
	And click on Add Employee
	Then Add Employee Page should be displayed and the Title should be "OrangeHRM"
	When Add Employee details
	And Click on save first button
	Then User Details page should be displayed and the Title should be "OrangeHRM" 
	When User enter DrivingLicenceNumber
	And Click on save second button
	Then Verify the Username in Personal Details page
	And close browser
	
@Regression	@e2e 
Scenario: Search employee by employee id
	
	When User click on PMI Menu
	And click on Employee List
	Then Employee List page should be displayed and the Title should be "OrangeHRM"
	When Search employee by employee id
	And Click on search button
	Then Added user should be displayed
	And close browser
	
@Regression	@e2e
Scenario: Search employee by first name
	
	When User click on PMI Menu
	And click on Employee List
	Then Employee List page should be displayed and the Title should be "OrangeHRM"
	When Search employee by first name
	And Click on search button
	Then Added user should be displayed
	And close browser
	
	