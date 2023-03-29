Feature: User Registration
  i want to check that the user can registration our CRM website
  Scenario Outline: User Registration
    Given the user in the userRegistration page
    When i entered "<username>" ,"<password>"
    Then the registration page displayed successfully
    Examples:
      |username|password|
      |Ahmed_1 |123456789|