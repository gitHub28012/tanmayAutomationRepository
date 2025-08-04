#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@LoginTag
Feature: login page Feature 
  @Loginfeature
  Scenario: verify the login page with valid set of inputs 
    Given users should be navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" by opening the chrome browser
    When  user enters "Admin" as username and "admin123" as password
    Then  Home should be display
 
 

  
