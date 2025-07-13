Feature: Login 

@Sanity @e2e @Regression @Smoke
Scenario: Successful Login with Valid Credentials 
	Given User Launch Chrome browser 
	When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" 
	And User enters UserName as "Admin" and Password as "admin123" 
	And Click on Login 
	Then Dashboard Page should be displayed and the Title should be "OrangeHRM"  
	When User click on Log out link 
	Then Login Page Title should be "OrangeHRM" 
	And close browser

@Regression	@DDT
Scenario Outline: Successful Login with Valid Credentials DDT
	Given User Launch Chrome browser 
	When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" 
	And User enters UserName as "<username>" and Password as "<password>" 
	And Click on Login 
	Then Dashboard Page should be displayed and the Title should be "OrangeHRM" 
	When User click on Log out link 
	Then Login Page Title should be "OrangeHRM" 
	And close browser
	
Examples: 
|username|password|
|Admin|admin123|
|Admin1|admin1234|
